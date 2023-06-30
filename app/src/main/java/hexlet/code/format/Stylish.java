package hexlet.code.format;


import java.util.Map;


public class Stylish {
    public static String format(Map<String, Map<String, Object>> map) {
        StringBuilder result = new StringBuilder("{\n");

        for (String key : map.keySet()) {
            Map<String, Object> innerMap = map.get(key);
            String status = innerMap.get("Status").toString();
            Object oldValue = innerMap.get("old value");
            Object newValue = innerMap.get("new value");

            switch (status) {
                case "added" -> {
                    result.append("  ");
                    result.append("+ ");
                    result.append(key).append(": ");
                    result.append(newValue).append("\n");
                }
                case "deleted" -> {
                    result.append("  ");
                    result.append("- ");
                    result.append(key).append(": ");
                    result.append(oldValue).append("\n");
                }
                case "unchanged" -> {
                    result.append("    ");
                    result.append(key).append(": ");
                    result.append(oldValue).append("\n");
                }
                case "changed" -> {
                    result.append("  ");
                    result.append("- ");
                    result.append(key).append(": ");
                    result.append(oldValue).append("\n");
                    result.append("  ");
                    result.append("+ ");
                    result.append(key).append(": ");
                    result.append(newValue).append("\n");
                }
                default -> throw new IllegalStateException("Unexpected value: " + status);
            }
        }
        result.append("}");
        return result.toString();
    }
}
