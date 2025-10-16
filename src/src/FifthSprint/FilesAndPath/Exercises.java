package FifthSprint.FilesAndPath;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercises {
    public static final Path HOME = Paths.get("user.home");
    public static void main(String[] args) {
        Path path = Paths.get("G:\\Новая папка");

        System.out.println("toString: " + path.toString());
        System.out.println("getParent(): " + path.getParent());
        System.out.println("getFileName: " + path.getFileName());
        System.out.println("getRoot: " + path.getRoot());
        System.out.println("getFileSystem: " + path.getFileSystem());

        System.out.println("\ntoString: " + HOME.toString());
        System.out.println("getParent(): " + HOME.getParent());
        System.out.println("getFileName: " + HOME.getFileName());
        System.out.println("getRoot: " + HOME.getRoot());
        System.out.println("getFileSystem: " + HOME.getFileSystem());

        Files.


    }
}
