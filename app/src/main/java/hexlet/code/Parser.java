package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parser(File filepath) throws Exception {
        if (getFileExtension(filepath).equals("json")) {
            return parseJson(filepath);
        } else {
            return parseYml(filepath);
        }
    }

    public static TreeMap<String, Object> parseJson(File filepath) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<TreeMap<String, Object>>() {
        });
        return value;
    }

    public static TreeMap<String, Object> parseYml(File filepath) throws Exception {
        final ObjectMapper mapper = new YAMLMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<TreeMap<String, Object>>() {
        });
        return value;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}

