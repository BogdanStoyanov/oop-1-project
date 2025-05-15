package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.util.Scanner;

/**
 * Класътслужи за намиране на книги по зададен критерий като заглавие, автор или таг.
 * <p>
 * Командата е достъпна само за влезли потребители и при отворен файл с книги.
 * </p>
 */
public class BooksFindCommand implements Command {
    private CurrentUser currentUser;
    private Scanner scanner;
    private BookList bookList;

    /**
     * Конструктор за инициализация на BooksFindCommand.
     *
     * @param currentUser текущият потребител
     * @param scanner     обект за четене на вход от потребителя
     * @param bookList    списък с книги, в който ще се извършва търсенето
     */
    public BooksFindCommand(CurrentUser currentUser, Scanner scanner, BookList bookList) {
        this.currentUser = currentUser;
        this.scanner = scanner;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за търсене на книга по избран критерий.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл в системата</li>
     *   <li>Проверява дали има отворен файл</li>
     *   <li>Извлича критерий за търсене (title, author, tag)</li>
     *   <li>Извлича стойността за търсене</li>
     *   <li>Извиква метода {@code find} на {@link BookList}</li>
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
        String option, search;
        option = scanner.next();
        search = scanner.nextLine();
        search = search.trim();
        bookList.find(option, search);
    }
}
