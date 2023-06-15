package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferYmlTest {
    @Test
    public void ymlTest() throws Exception {
        final String file1 = "file1.yml";
        final String file2 = "file2.yml";
        final String expected = """
                             {
                             - follow: false
                               host: hexlet.io
                             - proxy: 123.234.53.22
                             - timeout: 50
                             + timeout: 20
                             + verbose: true
                             }""";
        assertEquals(expected, Differ.generate(file1, file2));
    }
    @Test
    public void testNested() throws Exception {
        final String file1 = "./src/test/resources/nestedFile1.yml";
        final String file2 = "./src/test/resources/nestedFile2.yml";
        final String expected = """
                             {
                               chars1: [a, b, c]
                             - chars2: [d, e, f]
                             + chars2: false
                             - checked: false
                             + checked: true
                             - default: null
                             + default: [value1, value2]
                             - id: 45
                             + id: null
                             - key1: value1
                             + key2: value2
                               numbers1: [1, 2, 3, 4]
                             - numbers2: [2, 3, 4, 5]
                             + numbers2: [22, 33, 44, 55]
                             - numbers3: [3, 4, 5]
                             + numbers4: [4, 5, 6]
                             + obj1: {nestedKey=value, isNested=true}
                             - setting1: Some value
                             + setting1: Another value
                             - setting2: 200
                             + setting2: 300
                             - setting3: true
                             + setting3: none
                             }""";
        assertEquals(expected, Differ.generate(file1, file2));
    }
}
