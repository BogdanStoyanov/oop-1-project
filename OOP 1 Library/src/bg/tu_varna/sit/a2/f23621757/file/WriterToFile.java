package bg.tu_varna.sit.a2.f23621757.file;

import bg.tu_varna.sit.a2.f23621757.book.Book;
import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.user.User;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriterToFile {
    public static void writeBooksToFile(BookList bookList,String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Book book : bookList.getBookList()) {
                writer.write(book.getAuthor() + "\n");
                writer.write(book.getTitle() + "\n");
                writer.write(book.getGenre() + "\n");
                writer.write(book.getDescription() + "\n");
                writer.write(book.getYearOfPublishing() + "\n");
                writer.write(book.getTag() + "\n");
                writer.write(book.getRating() + "\n");
                writer.write(book.getIsbn() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: ");
            e.printStackTrace();
        }
    }

    public static void writeUsersToFile(UserList userList,String fileName){
        String filePath = System.getProperty("user.dir") + File.separator + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            for (User user : userList.getUserList()) {
                writer.write(user.getUsername() + "\n");
                writer.write(user.getPassword() + "\n");
                writer.write(user.isAdmin() + "\n");
                writer.write("\n");
            }
        } catch (IOException exception) {
            System.out.println("Error writing to file: ");
            exception.printStackTrace();
        }
    }
}
