package hexlet.code;

import java.nio.file.Paths;
import java.util.Map;


public class Differ {

    public static String generate(String path1, String path2) throws Exception {
        final String defaultFormat = "stylish";
        return generate(path1, path2, defaultFormat);
    }

    public static String generate(String path1, String path2, String format) throws Exception {
        String absolutePath1 = Paths.get(path1).toAbsolutePath().normalize().toString();
        String absolutePath2 = Paths.get(path2).toAbsolutePath().normalize().toString();

        final Map<String, Object> firstFile = Parser.parse(absolutePath1, getExtension(absolutePath1));
        final Map<String, Object> secondFile = Parser.parse(absolutePath2, getExtension(absolutePath2));

        Map<String, Map<String, Object>> diffMap = DiffMap.creatingDiffMap(firstFile, secondFile);
        return Formatter.choiceFormat(diffMap, format);
    }

    private static String getExtension(String path) {
        int lastDotIndex = path.lastIndexOf(".");
        if (lastDotIndex >= 0) {
            return path.substring(lastDotIndex + 1);
        } else {
            return "";
        }
    }
}
