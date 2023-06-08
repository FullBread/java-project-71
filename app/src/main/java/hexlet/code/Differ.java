package hexlet.code;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(File file1, File file2) throws Exception {
        final TreeMap<String, Object> firstFile = Parser.parser(file1);
        final TreeMap<String, Object> secondFile = Parser.parser(file2);

        Set<String> keys = new TreeSet<>(firstFile.keySet());
        keys.addAll(secondFile.keySet());
        String result = getResultString(keys, firstFile, secondFile);
        return result;
    }
    private static String getResultString(Set<String> keys, Map<String, Object> firstFile,
                                          Map<String, Object> secondFile) {

        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : keys) {
            if (!firstFile.containsKey(key)) {
                resultStringJoiner.add("+ " + key + ": " + secondFile.get(key));
            } else if (!secondFile.containsKey(key)) {
                resultStringJoiner.add("- " + key + ": " + firstFile.get(key));
            } else {
                Object firstValue = firstFile.get(key);
                Object secondValue = secondFile.get(key);
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
