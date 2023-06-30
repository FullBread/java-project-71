package hexlet.code;

import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DiffMap {
    public static Map<String, Map<String, Object>> creatingDiffMap(Map<String, Object> firstFile,
                                                                   Map<String, Object> secondFile) {
        Set<String> keys = new TreeSet<>();
        Map<String, Map<String, Object>> comparedMap = new LinkedHashMap<>();

        keys.addAll(firstFile.keySet());
        keys.addAll(secondFile.keySet());

        for (String key : keys) {
            if (!firstFile.containsKey(key)) {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("Status", "added");
                tempMap.put("old value", "");
                tempMap.put("new value", secondFile.get(key));
                comparedMap.put(key, tempMap);
            } else if (!secondFile.containsKey(key)) {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("Status", "deleted");
                tempMap.put("old value", firstFile.get(key));
                tempMap.put("new value", "");
                comparedMap.put(key, tempMap);
            } else {
                var firstValue = firstFile.get(key);
                var secondValue = secondFile.get(key);
                Map<String, Object> tempMap = new HashMap<>();
                if (!ObjectUtils.notEqual(firstValue, secondValue)) {
                    tempMap.put("Status", "unchanged");
                } else {
                    tempMap.put("Status", "changed");
                }
                tempMap.put("old value", firstValue);
                tempMap.put("new value", secondValue);
                comparedMap.put(key, tempMap);

            }
        }
        return comparedMap;
    }
}
