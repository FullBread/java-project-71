package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static final Map<String, Class<? extends Extension>> REGISTRY = new HashMap<>();

    static {
        REGISTRY.put("json", JsonParse.class);
        REGISTRY.put("yml", YmlParse.class);
    }

    public Extension fileToMap(String extension) {
        Class<? extends Extension> extensionClass = REGISTRY.get(extension);
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


