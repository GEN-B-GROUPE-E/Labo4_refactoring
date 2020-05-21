package ch.heigvd.gen;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Order implements JSONConvertible {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }


    @Override
    public JSONObject jsonConvert() {
        JSONObject obj = new JSONObject();
        JSONArray jsonProducts = new JSONArray();
        for (int j = 0; j < this.getProductsCount(); j++) {
            jsonProducts.add(getProduct(j).jsonConvert());
        }
        obj.put("id", getOrderId());
        obj.put("products", jsonProducts);


        return obj;
    }
}
