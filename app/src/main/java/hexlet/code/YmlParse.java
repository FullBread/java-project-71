package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public final class YmlParse implements Extension {

    @Override
    public Map<String, Object> parse(String path) throws Exception {
        File ymlFile = new File(path);
        final ObjectMapper mapper = new YAMLMapper();
        final TreeMap<String, Object> parseData;
        parseData = mapper.readValue(ymlFile, new TypeReference<>() {
        });
        return parseData;
    }
}
