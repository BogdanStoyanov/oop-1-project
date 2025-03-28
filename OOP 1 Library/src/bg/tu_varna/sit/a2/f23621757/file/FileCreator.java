package bg.tu_varna.sit.a2.f23621757.file;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public static void createFile(File file) {
        try {
            if(file.createNewFile()){
                System.out.println("Successfully opened "+file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
