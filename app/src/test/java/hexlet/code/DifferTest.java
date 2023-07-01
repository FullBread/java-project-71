package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("textForTest4.txt");
        resultPlain = readFixture("textForTest3.txt");
        resultStylish = readFixture("textForTest2.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("nestedFile1." + format).toString();
        String filePath2 = getFixturePath("nestedFile2." + format).toString();

        Assertions.assertEquals(resultStylish, Differ.generate(filePath1, filePath2));

        Assertions.assertEquals(resultStylish, Differ.generate(filePath1, filePath2, "stylish"));

        Assertions.assertEquals(resultPlain, Differ.generate(filePath1, filePath2, "plain"));

        Assertions.assertEquals(resultJson, Differ.generate(filePath1, filePath2, "json"));
    }
}

