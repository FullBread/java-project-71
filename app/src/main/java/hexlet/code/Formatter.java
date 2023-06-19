package hexlet.code;

import hexlet.code.format.Plain;
import hexlet.code.format.Stylish;

import java.util.TreeMap;
import java.util.TreeSet;

public class Formatter {
    public static String choiceFormat(TreeSet<String> keys, TreeMap<String, Object> firstFile,
                                    TreeMap<String, Object> secondFile, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(keys, firstFile, secondFile);
            case "plain" -> Plain.format(keys, firstFile, secondFile);
            default -> throw new Exception("There is unknown output format.");
        };
    }
}
