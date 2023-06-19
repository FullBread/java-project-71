package hexlet.code.format;

import org.apache.commons.lang3.ObjectUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Plain {

    public static String format(TreeSet<String> keys, TreeMap<String, Object> firstFile,
                                TreeMap<String, Object> secondFile) {
        StringJoiner resultStringJoiner = new StringJoiner("\n");
        for (String key : keys) {
            var firstValue = firstFile.get(key);
            var secondValue = secondFile.get(key);
            if (!firstFile.containsKey(key)) {
                resultStringJoiner.add("Property '" + key + "'" + " was added with value: "
                        + getStringValue(secondValue));
            } else if (!secondFile.containsKey(key)) {
                resultStringJoiner.add("Property '" + key + "'" + " was removed");
            } else  if (ObjectUtils.notEqual(firstValue, secondValue)) {
                resultStringJoiner.add("Property '" + key + "'" + " was updated. From "
                        + getStringValue(firstValue) + " to " + getStringValue(secondValue));
            }
        }
        return resultStringJoiner.toString();
    }


    private static Object getStringValue(Object value) {
        if (value instanceof ArrayList || value instanceof LinkedHashMap) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value;
        }
    }

}

