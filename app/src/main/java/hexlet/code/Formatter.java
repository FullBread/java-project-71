package hexlet.code;

import hexlet.code.format.Json;
import hexlet.code.format.Plain;
import hexlet.code.format.Stylish;

import java.util.Map;

public class Formatter {
    public static String choiceFormat(Map<String, Map<String, Object>> diffMap, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(diffMap);
            case "plain" -> Plain.format(diffMap);
            case "json" -> Json.format(diffMap);
            default -> throw new Exception("There is unknown output format.");
        };
    }
}
