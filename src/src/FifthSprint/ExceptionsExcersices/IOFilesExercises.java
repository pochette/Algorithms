package FifthSprint.ExceptionsExcersices;

import java.io.File;

public class IOFilesExercises {
    private static final String HOME = System.getProperty("user.home");
    public static void main(String[] args) {
        File dir = new File (HOME + File.separator + "NewDir");

        boolean created = dir.mkdir();
        if(created){
            System.out.println("Директория создана.");
        }
        File newDir = new File(HOME + File.separator + "NewDirRenamed");
        dir.renameTo(newDir);
        boolean deleted = newDir.delete();
        if(deleted)
            System.out.println("Директория удалена.");

        int count = 0;
        if(dir.isDirectory()) {
            for(File file : dir.listFiles()) {
                if(file.isDirectory()){
                    System.out.printf("\nКаталог: %s", file.getName());
                    count++;
                } else {
                    System.out.printf("\nФайл: %s",  file.getName());
                    count++;
                }

            }
            System.out.println("\nЧисло файлов: " + count);
        }


    }
}
