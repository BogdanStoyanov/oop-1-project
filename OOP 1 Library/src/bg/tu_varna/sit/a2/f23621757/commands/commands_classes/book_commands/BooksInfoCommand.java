package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.util.Scanner;


/**
 * Класът {@code BooksAddCommand} отговаря за добавянето на нова книга в системата.
 * <p>
 * Командата може да се използва само от администратор, който е влязъл
 * в профила си и е отворил файл с книги.
 * </p>
 */
public class BooksInfoCommand implements Command {
    private CurrentUser currentUser;
    private Scanner scanner;
    private BookList bookList;

    /**
     * Конструктор за създаване на BooksAddCommand.
     *
     * @param currentUser текущият потребител
     * @param bookList    списък с книги, в който ще се добавя нова книга
     */
    public BooksInfoCommand(BookList bookList, Scanner scanner, CurrentUser currentUser) {
        this.bookList = bookList;
        this.scanner = scanner;
        this.currentUser = currentUser;
    }

    /**
     * Изпълнява командата за добавяне на книга.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл в системата</li>
     *   <li>Проверява дали има администраторски права</li>
     *   <li>Проверява дали има отворен файл</li>
     *   <li>Извиква {@code add()} метода на {@link BookList} за добавяне на нова книга</li>
     * </ul>
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasLoggedIn()) {
            ConsolePrinter.askForUser();
            return;
        }
        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }
        String isbn;
        isbn = scanner.next();
        bookList.info(isbn);
    }
}
