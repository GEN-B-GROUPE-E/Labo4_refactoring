package ch.heigvd.gen;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class OrdersWriter {
    private ArrayList<Order> orders;

    /**
     * Constructor
     * @param orders the list of orders to be Written in JSON
     */
    public OrdersWriter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * writes the String representation of this instance's list of orders
     * @return a JSON-style string representing the list of orders of this writer
     */
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