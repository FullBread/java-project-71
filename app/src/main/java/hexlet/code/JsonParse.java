package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public final class JsonParse implements Extension {

    public Map<String, Object> parse(String path) throws Exception {
        File jsonFile = new File(path);
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, Object> parseData;
        parseData = mapper.readValue(jsonFile, new TypeReference<>() {
        });
        return parseData;
    }
}
