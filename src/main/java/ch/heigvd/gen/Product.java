package ch.heigvd.gen;

import org.json.simple.JSONObject;

public class Product implements JSONConvertible {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSizeString() {
        return size.toString();
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
        obj.put("code", getCode());
        obj.put("color", getColor());
        if (this.getSize() != Size.NO_SIZE) {
            obj.put("size", getSize());
        }
        obj.put("price", getPrice());
        obj.put("currency", getCurrency());

        return obj;
    }
}