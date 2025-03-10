package bg.tu_varna.sit.a2.f23621757.file;

import bg.tu_varna.sit.a2.f23621757.book.Book;
import bg.tu_varna.sit.a2.f23621757.book.BookList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriterToFile {
    public static void writeBooksToFile(BookList bookList, String filename) {
        if (!filename.endsWith(".txt")) {
            filename = filename.concat(".txt");
        }
        String filePath = System.getProperty("user.dir") + File.separator + filename;

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Book item : bookList.getBookList()) {
                writer.write(item.getAuthor() + "\n");
                writer.write(item.getTitle() + "\n");
                writer.write(item.getGenre() + "\n");
                writer.write(item.getDescription() + "\n");
                writer.write(item.getYearOfPublishing() + "\n");
                writer.write(item.getTag() + "\n");
                writer.write(item.getRating() + "\n");
                writer.write(item.getIsbn() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: ");
            e.printStackTrace();
        }
    }
}
