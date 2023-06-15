package hexlet.code.formater;

import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Stylish {
    public static String format(TreeSet<String> keys, TreeMap<String, Object> firstFile,
                                TreeMap<String, Object> secondFile) {
        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : keys) {
            if (!firstFile.containsKey(key)) {
                resultStringJoiner.add("+ " + key + ": " + secondFile.get(key));
            } else if (!secondFile.containsKey(key)) {
                resultStringJoiner.add("- " + key + ": " + firstFile.get(key));
            } else {
                Object firstValue = firstFile.get(key);
                Object secondValue = secondFile.get(key);
                firstValue = firstValue == null ? "null" : firstValue;
                secondValue = secondValue == null ? "null" : secondValue;

                if (firstValue.equals(secondValue)) {
                    resultStringJoiner.add("  " + key + ": " + firstValue);
                } else {
                    resultStringJoiner.add("- " + key + ": " + firstValue)
                            .add("+ " + key + ": " + secondValue);
                }
            }
        }
        return resultStringJoiner.toString();
    }
}
