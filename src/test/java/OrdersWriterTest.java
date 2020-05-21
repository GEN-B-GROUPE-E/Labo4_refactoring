import ch.heigvd.gen.Order;
import ch.heigvd.gen.OrdersWriter;
import ch.heigvd.gen.Product;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import ch.heigvd.gen.*;

import java.util.ArrayList;


public class OrdersWriterTest {
    ArrayList<Order> orders = new ArrayList<>();
    Order order111 = new Order(111);

    @BeforeEach
    public void SetupOneOrder() {
        orders.add(order111);
    }

    @Test
    public void NoOrder() {
        JSONObject obj = new JSONObject();
        obj.put("orders", new JSONArray());
        assertEquals(obj.toString(), new OrdersWriter(new ArrayList()).getContents());
    }

    @Test
    public void OneOrder() {

        JSONObject order111 = new JSONObject();
        order111.put("id", 111);
        order111.put("products", new JSONArray());
        JSONArray jsonOrders = new JSONArray();
        jsonOrders.add(order111);
        JSONObject orders = new JSONObject();
        orders.put("orders",jsonOrders);

        assertEquals(orders.toString(), new OrdersWriter(this.orders).getContents());
    }

    @Test
    public void TwoOrders() {
        orders.add(new Order(222));

        JSONObject order111Json = JsonOrderWithProduct(111, new JSONArray());
        JSONArray ordersArray = new JSONArray();
        ordersArray.add(order111Json);
        JSONObject order222Json = JsonOrderWithProduct(222, new JSONArray());
        ordersArray.add(order222Json);

        JSONObject ordersObj = new JSONObject();
        ordersObj.put("orders", ordersArray);
        assertEquals(ordersObj.toString(), new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProduct() {
        order111.AddProduct(new Product("Shirt", Color.BLUE, Size.M, 2.99, "TWD"));
        JSONArray productArray = new JSONArray();
        productArray.add(createProduct("Shirt","blue", "M",2.99,"TWD"));
        JSONObject order111Json = JsonOrderWithProduct(111, productArray);
        JSONArray ordersArray = new JSONArray();
        ordersArray.add(order111Json);
        JSONObject obj = new JSONObject();
        obj.put("orders", ordersArray);
        assertEquals(obj.toString(), new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProductNoSize() {
        order111.AddProduct(new Product("Pot", Color.RED, Size.NO_SIZE, 16.50, "SGD"));

        JSONArray productArray = new JSONArray();
        productArray.add(createProduct("Pot","red",16.5,"SGD"));
        JSONObject order111Json = JsonOrderWithProduct(111, productArray);
        JSONArray ordersArray = new JSONArray();
        ordersArray.add(order111Json);
        JSONObject obj = new JSONObject();
        obj.put("orders", ordersArray);

        assertEquals(obj.toString(), new OrdersWriter(orders).getContents());
    }
    private JSONObject createProduct(String code, String color, String size, double price, String currency){
        JSONObject product = new JSONObject();
        product.put("code", code);
        product.put("color", color);
        product.put("size", size);
        product.put("price", price);
        product.put("currency", currency);
        return product;
    }

    private JSONObject createProduct(String code, String color, double price, String currency){
        JSONObject product = new JSONObject();
        product.put("code", code);
        product.put("color", color);
        product.put("price", price);
        product.put("currency", currency);
        return product;
    }
    private JSONObject JsonOrderWithProduct(int id, JSONArray productJson) {
        JSONObject obj = new JSONObject();
        obj.put("id",id);
        obj.put("products", productJson);
        return obj;
    }

}
