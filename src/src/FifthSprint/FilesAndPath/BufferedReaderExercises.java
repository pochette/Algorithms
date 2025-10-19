package FifthSprint.FilesAndPath;

import java.io.*;

public class BufferedReaderExercises {
    public static void main(String[] args) throws IOException {
        try(Resource1 resource1 = new Resource1(); Resource2 resource2 = new Resource2()) {
            System.out.println("into try block");
            System.out.println((char) 38);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    static class Resource1 implements AutoCloseable {

        @Override
        public void close() throws IOException {
            System.out.println("method close of Resource1");
        }
    }
    static class Resource2 implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("method close of Resource2");
        }

    }

}
