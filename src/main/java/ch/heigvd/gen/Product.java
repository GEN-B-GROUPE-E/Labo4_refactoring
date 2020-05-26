package ch.heigvd.gen;

import org.json.simple.JSONObject;

public class Product implements JSONConvertible {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    /**
     * Constructor
     * @param code the product's code as a String
     * @param color the product's color as an Color Enum
     * @param size the product's size as an Enum
     * @param price the product's price
     * @param currency the product's currency (String)
     */
    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getColor() {
        if(color != null){
            return color.toString();
        }else{
            return "no color";
        }
    }

    @Override
    public JSONObject jsonConvert() {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("color", getColor());
        if (size != Size.NO_SIZE) {
            obj.put("size", size.toString());
        }
        obj.put("price", price);
        obj.put("currency", currency);

        return obj;
    }
}