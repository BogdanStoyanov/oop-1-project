package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.util.Scanner;

/**
 * Класът {@code BooksRemoveCommand} реализира интерфейса {@link Command}
 * и отговаря за премахване на книга от системата чрез ISBN.
 * <p>
 * Командата може да се използва само от потребител с администраторски права,
 * който е влязъл в профила си и е отворил файл с книги.
 * </p>
 */
public class BooksRemoveCommand implements Command {
    private CurrentUser currentUser;
    private Scanner scanner;
    private BookList bookList;

    /**
     * Конструктор за създаване на {@code BooksRemoveCommand}.
     *
     * @param currentUser текущият потребител
     * @param scanner     скенер за въвеждане от конзолата
     * @param bookList    списък с книги, от който ще се премахва книга
     */
    public BooksRemoveCommand(CurrentUser currentUser, Scanner scanner, BookList bookList) {
        this.currentUser = currentUser;
        this.scanner = scanner;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за премахване на книга.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл в системата</li>
     *   <li>Проверява дали има администраторски права</li>
     *   <li>Проверява дали има отворен файл</li>
     *   <li>Чете ISBN от потребителя</li>
     *   <li>Извиква {@code remove()} метода на {@link BookList} за премахване на книгата</li>
     * </ul>
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasLoggedIn()) {
            ConsolePrinter.askForUser();
            return;
        }
        if (!currentUser.isAdmin()) {
            ConsolePrinter.askForAdmin();
            return;
        }
        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }
        String isbn;
        isbn = scanner.next();
        bookList.remove(isbn);
    }
}
