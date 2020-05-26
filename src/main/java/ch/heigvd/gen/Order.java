package ch.heigvd.gen;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Order implements JSONConvertible {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    /**
     * Constructor
     * @param id the Order's identifier
     */
    public Order(int id) {
        this.id = id;
    }

    /**
     * Adds a product to the order
     * @param product the product to be added
     */
    public void AddProduct(Product product) {
        products.add(product);
    }

    @Override
    public JSONObject jsonConvert() {
        JSONObject obj = new JSONObject();
        JSONArray jsonProducts = new JSONArray();
        for (int j = 0; j < this.products.size(); j++) {
            jsonProducts.add(products.get(j).jsonConvert());
        }
        obj.put("id", id);
        obj.put("products", jsonProducts);


        return obj;
    }
}
