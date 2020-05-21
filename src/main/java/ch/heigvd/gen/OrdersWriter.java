package ch.heigvd.gen;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class OrdersWriter {
    private ArrayList<Order> orders;

    public OrdersWriter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getContents() {
        JSONObject obj = new JSONObject();
        JSONArray jsonOrders = new JSONArray();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            jsonOrders.add(order.jsonConvert());
        }

        obj.put("orders", jsonOrders);
        return obj.toString();
    }
}