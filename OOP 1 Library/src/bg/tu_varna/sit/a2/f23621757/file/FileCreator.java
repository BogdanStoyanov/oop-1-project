package bg.tu_varna.sit.a2.f23621757.file;

import java.io.File;
import java.io.IOException;

/**
 * Класът {@code FileCreator} предоставя функционалност за създаване на нови файлове,
 * използвайки Java I/O. Използва се при отваряне на файл, който все още не съществува.
 */
public class FileCreator {
    /**
     * Създава нов файл, ако такъв не съществува вече.
     * <p>
     * Ако файлът е създаден успешно, извежда съобщение за успех.
     * В противен случай извежда съобщение за неуспех или грешка.
     *
     * @param file {@code File} обект, който представлява файла, който трябва да бъде създаден
     */
    public static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("Successfully opened " + file.getName() + "\n");
            } else {
                System.out.println("Failed to open " + file.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
