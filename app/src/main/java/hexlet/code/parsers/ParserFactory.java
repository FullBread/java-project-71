package hexlet.code.parsers;

import java.util.HashMap;
import java.util.Map;

public final class ParserFactory {
    private static final Map<String, Class<? extends Parser>> REGISTRY = new HashMap<>();

    static {
        REGISTRY.put("json", JsonParser.class);
        REGISTRY.put("yml", YmlParser.class);
    }

    public static Parser getParser(String extension) {
        Class<? extends Parser> extensionClass = REGISTRY.get(extension);
        if (extensionClass != null) {
            try {
                return extensionClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create extension instance", e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported extension");
        }
    }
}


