package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Differ {

    public static String generate(Path file1, Path file2) throws Exception {
        if (!Files.exists(file1)) {
            throw new Exception("File " + file1 + " doesn't exist.");
        }
        if (!Files.exists(file2)) {
            throw new Exception("File " + file2 + " doesn't exist.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> firstFile = objectMapper.readValue(file1.toFile(),
                    new TypeReference<Map<String, Object>>() { });
        Map<String, Object> secondFile = objectMapper.readValue(file2.toFile(),
                    new TypeReference<Map<String, Object>>() { });
        Set<String> keys = new TreeSet<>(firstFile.keySet());
        keys.addAll(secondFile.keySet());
        String result = getResultString(keys, firstFile, secondFile);
        return result;
    }
    private static String getResultString(Set<String> keys, Map<String, Object> firstFile,
                                          Map<String, Object> secondFile) {

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
