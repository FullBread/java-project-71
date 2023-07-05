package hexlet.code;

import java.nio.file.Files;
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


        String content1 = Files.readString(Paths.get(absolutePath1));
        String content2 = Files.readString(Paths.get(absolutePath2));

        ParserFactory factory = new ParserFactory();
        Parser parser1 = factory.getParser(getExtension(absolutePath1));
        Parser parser2 = factory.getParser(getExtension(absolutePath2));


        final Map<String, Object> data1 = parser1.parse(content1);
        final Map<String, Object> data2 = parser2.parse(content2);

        Map<String, Map<String, Object>> difference = DiffBuilder.build(data1, data2);
        return Formatter.choiceFormat(difference, format);
    }

    private static String getExtension(String path) {
        int lastDotIndex = path.lastIndexOf(".");
        if (lastDotIndex >= 0) {
            return path.substring(lastDotIndex + 1);
        } else {
            throw new IllegalArgumentException("Invalid path: " + path);
        }
    }
}
