package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public final class JsonParser implements Parser {

    public Map<String, Object> parse(String content) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, Object> parseData;
        parseData = mapper.readValue(content, new TypeReference<>() {
        });
        return parseData;
    }
}
