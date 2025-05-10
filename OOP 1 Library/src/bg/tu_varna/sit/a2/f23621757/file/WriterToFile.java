package bg.tu_varna.sit.a2.f23621757.file;

import bg.tu_varna.sit.a2.f23621757.book.Book;
import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.user.User;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класът {@code WriterToFile} предоставя методи за запис на информация
 * за книги и потребители във файлове. Използва се за запазване на данни
 * в директорията {@code myFiles}.
 */
public class WriterToFile {
    /**
     * Записва всички книги от дадения {@code BookList} в текстов файл.
     * Всеки атрибут на книгата се записва на нов ред в следния ред:
     * автор, заглавие, жанр, описание, година, таг, рейтинг, ISBN.
     *
     * @param bookList списък с книги, които ще се запишат
     * @param fileName името на файла, в който ще се записват книгите
     */
    public static void writeBooksToFile(BookList bookList, String fileName) {
        File directory = new File("myFiles");
        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            for (Book book : bookList.getBookList()) {
                writer.write(book.getAuthor() + "\n");
                writer.write(book.getTitle() + "\n");
                writer.write(book.getGenre() + "\n");
                writer.write(book.getDescription() + "\n");
                writer.write(book.getYearOfPublishing() + "\n");
                writer.write(book.getTag() + "\n");
                writer.write(book.getRating() + "\n");
                writer.write(book.getIsbn() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: ");
            e.printStackTrace();
        }
    }

    /**
     * Записва списъка с потребители в указан файл.
     * <p>
     * Този метод преминава през подаденото {@link UserList} и записва детайлите на всеки {@link User}
     * (потребителско име, парола и статус на администратор) в указания файл.
     * <p>
     * Файлът ще бъде създаден в директорията "myFiles", ако тя не съществува.
     *
     * @param userList Списъкът с потребители, чиято информация ще бъде записана в файла.
     *                 Записват се потребителското име, паролата и статусът на администратор.
     * @param fileName Името на файла, в който ще бъдат записани данните на потребителите.
     *                 Файлът ще бъде запазен в директорията "myFiles".
     *
     *
     */
    public static void writeUsersToFile(UserList userList, String fileName) {
        File directory = new File("myFiles");
        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {
            for (User user : userList.getUserList()) {
                writer.write(user.getUsername() + "\n");
                writer.write(user.getPassword() + "\n");
                writer.write(user.isAdmin() + "\n");
            }
        } catch (IOException exception) {
            System.out.println("Error writing to file: ");
            exception.printStackTrace();
        }
    }
}
