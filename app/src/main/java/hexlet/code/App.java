package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-h", "--help"},
            usageHelp = true,
            description = "Show this help message and exit.")
    private boolean helpRequested;

    @Option(names = {"-V", "--version"},
            versionHelp = true,
            description = "Print version information and exit.")
    private boolean versionRequested;

    @Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "Output format [default: ${DEFAULT-VALUE}].")
    private String format = "stylish";

    @Parameters(index = "0",
            paramLabel = "filepath1",
            description = "Path to first file.")
    private String file1;

    @Parameters(index = "1",
            paramLabel = "filepath2",
            description = "Path to second file.")
    private String file2;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
