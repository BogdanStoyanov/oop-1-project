package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.util.Scanner;

/**
 * Класът предоставя функционалност за сортиране на книги по зададен критерий и ред.
 * <p>
 * Командата изисква потребителят да е влязъл в профила си и да има отворен файл с книги.
 * </p>
 */
public class BooksSortCommand implements Command {
    private CurrentUser currentUser;
    private Scanner scanner;
    private BookList bookList;

    /**
     * Конструктор на класа {@code BooksSortCommand}.
     *
     * @param currentUser текущият потребител
     * @param scanner     скенер за вход от конзолата
     * @param bookList    списък с книги, който ще бъде сортиран
     */
    public BooksSortCommand(CurrentUser currentUser, Scanner scanner, BookList bookList) {
        this.currentUser = currentUser;
        this.scanner = scanner;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за сортиране на книгите.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл</li>
     *   <li>Проверява дали е отворен файл</li>
     *   <li>Чете критерий (напр. title, author, year, rating)</li>
     *   <li>Чете ред (asc или desc)</li>
     *   <li>Извиква метода {@code insertionSort()} от {@link BookList}</li>
     * </ul>
     * Ако проверките не преминат успешно, извежда съответното съобщение.
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
        String criteria = scanner.next();
        String order = scanner.next();
        bookList.insertionSort(criteria, order);
        System.out.println("Books were sorted!\n");
    }
}
