package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void ymlTest() throws Exception {
        final File filepath1 = new File("./src/test/resources/file1.yml");
        final File filepath2 = new File("./src/test/resources/file2.yml");
        final String result = """
                             {
                             - follow: false
                               host: hexlet.io
                             - proxy: 123.234.53.22
                             - timeout: 50
                             + timeout: 20
                             + verbose: true
                             }""";
        assertEquals(result, Differ.generate(filepath1, filepath2));
    }
}
