package CountWords.FifthSprint.FilesAndPath;

import java.io.*;

public class WriterAndReader {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("filereader.txt");

        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }
        reader.close();



    }
}
