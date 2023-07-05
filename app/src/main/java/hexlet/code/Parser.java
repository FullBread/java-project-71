package hexlet.code;

import java.util.Map;

public interface Parser {
    Map<String, Object> parse(String path) throws Exception;
}
