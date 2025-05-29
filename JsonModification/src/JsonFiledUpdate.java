import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonFiledUpdate {

    public static void updateFields(Object json, Map<String, Object> updates) {

        if (json instanceof JSONObject) {
            JSONObject obj = (JSONObject) json;

            for (String key : updates.keySet()) {
                if (obj.has(key)) {
                    obj.put(key, updates.get(key));
                }
            }


            for (String key : obj.keySet()) {
                Object value = obj.get(key);

                if (value instanceof JSONObject) {
                    updateFields(value, updates);
                }


                if (value instanceof JSONArray) {
                    JSONArray array = (JSONArray) value;
                    for (int i = 0; i < array.length(); i++) {
                        Object element = array.get(i);
                        if (element instanceof JSONObject || element instanceof JSONArray) {
                            updateFields(element, updates);
                        }
                    }
                }
            }
        }
    }
}

