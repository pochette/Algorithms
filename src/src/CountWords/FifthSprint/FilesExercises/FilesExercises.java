package CountWords.FifthSprint.FilesExercises;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExercises {
    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) {
        Path testFilePath = Paths.get(HOME, "test", "file.txt");

        System.out.println("Information about file: ");
        System.out.println(" - name: " + testFilePath.getFileName());
        System.out.println(" - root directory: " + testFilePath.getRoot());
        System.out.println(" - parent directory: " + testFilePath.getParent());

        System.out.println("Elements of path: ");
        for (Path path : testFilePath) {
            System.out.println(" - element of path: " + path);
        }
    }
}
