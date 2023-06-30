package hexlet.code;

import java.util.Map;

public interface Extension {
    Map<String, Object> parse(String path) throws Exception;
}
