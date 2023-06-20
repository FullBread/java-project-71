package hexlet.code.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {
    public static String format(TreeSet<String> keys, TreeMap<String, Object> firstFile,
                                TreeMap<String, Object> secondFile) throws JsonProcessingException {
        Map<String, Object> resultJson = new LinkedHashMap<>();
        ObjectMapper result = new ObjectMapper();
        for (String key : keys) {
            var firstValue = String.valueOf(firstFile.get(key));
            var secondValue = String.valueOf(secondFile.get(key));
            if (!firstFile.containsKey(key)) {
                resultJson.put("+ " + key, secondValue);
            } else if (!secondFile.containsKey(key)) {
                resultJson.put("- " + key, firstValue);
            } else {
                if (!ObjectUtils.notEqual(firstValue, secondValue)) {
                    resultJson.put(key, firstValue);
                } else {
                    resultJson.put("- " + key, firstValue);
                    resultJson.put("+ " + key, secondValue);
                }
            }
        }
        return result.writeValueAsString(resultJson);
    }

}
