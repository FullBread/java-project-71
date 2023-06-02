package hexlet.code;


import java.io.FileReader;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2) throws IOException {

        try (FileReader fileReader1 = new FileReader(file1);
             FileReader fileReader2 = new FileReader(file2)) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> firstFile = objectMapper.readValue(fileReader1, new TypeReference<Map<String, Object>>(){});
            Map<String, Object> secondFile = objectMapper.readValue(fileReader2, new TypeReference<Map<String, Object>>(){});
            Set<String> keys = new TreeSet<>(firstFile.keySet());
            keys.addAll(secondFile.keySet());
            String result = getResultString(keys, firstFile, secondFile);
            return result;
        }
    }
    private static String getResultString(Set<String> keys, Map<String, Object> firstFile, Map<String, Object> secondFile) {
        StringJoiner resultStringJoiner = new StringJoiner("\n", "{\n", "\n}");
        for (String key : keys) {
            if (!firstFile.containsKey(key)) {
                resultStringJoiner.add("+ " + key + ": " + secondFile.get(key));
            } else if (!secondFile.containsKey(key)) {
                resultStringJoiner.add("- " + key + ": " + firstFile.get(key));
            } else {
                Object firstValue = firstFile.get(key);
                Object secondValue = secondFile.get(key);
                if (firstValue.equals(secondValue)) {
                    resultStringJoiner.add("  " + key + ": " + firstValue);
                } else {
                    resultStringJoiner.add("- " + key + ": " + firstValue)
                            .add("+ " + key + ": " + secondValue);
                }
            }
        }
        return resultStringJoiner.toString();
    }
}