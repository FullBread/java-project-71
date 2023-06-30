package hexlet.code;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String path, String extension) throws Exception {
        Factory factory = new Factory();
        Extension resultExtension = factory.fileToMap(extension);
        return resultExtension.parse(path);
    }
}




