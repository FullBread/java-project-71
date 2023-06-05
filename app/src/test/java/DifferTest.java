import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    public void testValid() throws Exception {
        Path file1 =
                Paths.get("./src/test/resources/file1.json").toAbsolutePath().normalize();
        Path file2 =
                Paths.get("./src/test/resources/file2.json").toAbsolutePath().normalize();
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
