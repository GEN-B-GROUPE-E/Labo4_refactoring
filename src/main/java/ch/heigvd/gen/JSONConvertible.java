package ch.heigvd.gen;

import org.json.simple.JSONObject;
public interface JSONConvertible {
     /**
      * Returns a JSONObject representing the current instance of the JSONConvertible
      * @return this instance as a JSONObject
      */
     JSONObject jsonConvert();
}
