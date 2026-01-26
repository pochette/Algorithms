package Patterns.Decorator;

public class FileWorkerImpl implements FileWorker {

    String name;


    @Override
    public void write(String s) {
        System.out.println("OK");
    }

    @Override
    public String read() {
        return "read from " + name;
    }
}
