package hexlet.code.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;


public class Json {
    public static String format(Map<String, Map<String, Object>> map) throws JsonProcessingException {
        ObjectMapper result = new ObjectMapper();
        Map<String, Object> resultJson = new LinkedHashMap<>();

        for (String key : map.keySet()) {
            Map<String, Object> innerMap = map.get(key);
            String status = innerMap.get("Status").toString();
            var oldValue = String.valueOf(innerMap.get("old value"));
            var newValue = String.valueOf(innerMap.get("new value"));
            switch (status) {
                case "added":
                    resultJson.put("+ " + key, newValue);
                    break;
                case "deleted":
                    resultJson.put("- " + key, oldValue);

                    break;
                case "unchanged":
                    resultJson.put(key, oldValue);

                    break;
                case "changed":
                    resultJson.put("- " + key, oldValue);
                    resultJson.put("+ " + key, newValue);

                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        return result.writeValueAsString(resultJson);
    }

}
