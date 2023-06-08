package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void testValid() throws Exception {
        File file1 = new File("./src/test/resources/file1.json");
        File file2 = new File("./src/test/resources/file2.json");
        String expected = """
                             {
                             - follow: false
                               host: hexlet.io
                             - proxy: 123.234.53.22
                             - timeout: 50
                             + timeout: 20
                             + verbose: true
                             }""";

        assertThat(Differ.generate(file1, file2)).isEqualTo(expected);

    }
}
