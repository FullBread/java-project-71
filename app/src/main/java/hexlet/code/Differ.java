package hexlet.code;
import hexlet.code.formater.Stylish;
import java.io.File;
import java.util.TreeMap;
import java.util.TreeSet;


public class Differ {

    public static String generate(String file1, String file2) throws Exception {
        String absoluteFile1;
        String absoluteFile2;
        if (new File(file1).exists()) {
            absoluteFile1 = file1;
        } else {
            absoluteFile1 = searchFile(".", file1);
        }
        if (new File(file2).exists()) {
            absoluteFile2 = file2;
        } else {
            absoluteFile2 = searchFile(".", file2);
        }


        final TreeMap<String, Object> firstFile = Parser.parser(new File(absoluteFile1));
        final TreeMap<String, Object> secondFile = Parser.parser(new File(absoluteFile2));

        TreeSet<String> keys = new TreeSet<>(firstFile.keySet());
        keys.addAll(secondFile.keySet());
        return Stylish.format(keys, firstFile, secondFile);
    }

    public static String searchFile(String directory, String fileName) {
        File[] files = new File(directory).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String filePath = searchFile(file.getAbsolutePath(), fileName);
                if (filePath != null) {
                    return filePath;
                }
            } else if (file.getName().equals(fileName)) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }
}

