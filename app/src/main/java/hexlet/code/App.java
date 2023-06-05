package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@Command(name = "gendif", mixinStandardHelpOptions = true, version = "gendif v1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<String>  {


    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String file1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String file2;

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String format;

    @Override
    public String call() throws Exception {
        Path pathToFile1 = Paths.get(file1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(file2).toAbsolutePath().normalize();
        String result = Differ.generate(pathToFile1, pathToFile2);
        System.out.println(result);
        return result;
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
