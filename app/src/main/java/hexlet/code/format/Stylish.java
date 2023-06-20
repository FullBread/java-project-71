package hexlet.code.format;

import org.apache.commons.lang3.ObjectUtils;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Stylish {
    public static String format(TreeSet<String> keys, TreeMap<String, Object> firstFile,
                                TreeMap<String, Object> secondFile) {
        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : keys) {
            Object firstValue = firstFile.get(key);
            Object secondValue = secondFile.get(key);
            if (!firstFile.containsKey(key)) {
                resultStringJoiner.add("  + " + key + ": " + secondValue);
            } else if (!secondFile.containsKey(key)) {
                resultStringJoiner.add("  - " + key + ": " + firstValue);
            } else {
                if (!ObjectUtils.notEqual(firstValue, secondValue)) {
                    resultStringJoiner.add("    " + key + ": " + firstValue);
                } else {
                    resultStringJoiner.add("  - " + key + ": " + firstValue)
                            .add("  + " + key + ": " + secondValue);
                }
            }
        }
        return resultStringJoiner.toString();
    }
}
