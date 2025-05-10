package bg.tu_varna.sit.a2.f23621757.commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класът {@code BookCommandSetter} предоставя метод за настройване на
 * команди, свързани с операции върху книги.
 * <p>
 * Използва {@code Runnable} обекти за представяне на действия,
 * които могат да се извикват по команда от потребителския интерфейс.
 */
public class BookCommandSetter {

    /**
     * Настройва и връща мапа от команди за работа с книги. Командите се
     * изпълняват само ако текущият потребител е влязъл в системата и е отворил файл.
     * Някои команди изискват потребителят да има администраторски права.
     *
     * @param scanner     {@code Scanner} за въвеждане на данни от потребителя
     * @param currentUser следи дали текущия потребител е: отворил файл; логнат; админ; името на файла, ако го е отворил
     * @param bookList    списъкът с книги, върху който ще се прилагат командите
     * @param userList    списъкът с потребители
     * @param userFile    име на файла, съдържащ потребителските данни
     * @return Map, който съпоставя име на команда с нейното действие (Runnable)
     */
    public static Map<String, Runnable> setBookCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                        UserList userList, String userFile) {
        Map<String, Runnable> bookCommands = new HashMap<>();

        bookCommands.put("all", () -> {
            if (!currentUser.isHasLoggedIn()) {
                ConsolePrinter.askForUser();
                return;
            }
            if (!currentUser.isHasOpenedFile()) {
                ConsolePrinter.askForFile();
                return;
            }
            bookList.all();
        });

        bookCommands.put("find", () -> {
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
            search=search.trim();
            bookList.find(option, search);
        });

        bookCommands.put("sort", () -> {
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
        });

        bookCommands.put("info", () -> {
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
        });

        bookCommands.put("add", () -> {
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
            bookList.add();
        });

        bookCommands.put("remove", () -> {
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
        });

        return bookCommands;
    }
}
