package Patterns.Decorator;

public class FileWorkerDecorator implements FileWorker {

    private FileWorker fileWorker;

    public FileWorkerDecorator (FileWorker fileWorker) {

    }

    @Override
    public void write(String s) {
        System.out.println("additional functionality");
        fileWorker.write(s);
    }

    @Override
    public String read() {
        System.out.println("additional functionality");
        return fileWorker.read();
    }
}
