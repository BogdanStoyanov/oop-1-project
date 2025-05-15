package bg.tu_varna.sit.a2.f23621757.commands.commands_setter;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands.*;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класът {@code BookCommandSetter} предоставя метод за настройване на
 * команди, свързани с операции върху книги.
 * <p>
 * Използва обекти за представяне на действия,
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
     * @return Map, който съпоставя име на команда с нейното действие
     */
    public static Map<String, Command> setBookCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                       UserList userList, String userFile) {
        Map<String, Command> bookCommands = new HashMap<>();
        bookCommands.put("all", new BooksAllCommand(currentUser, bookList));
        bookCommands.put("find", new BooksFindCommand(currentUser, scanner, bookList));
        bookCommands.put("sort", new BooksSortCommand(currentUser, scanner, bookList));
        bookCommands.put("info", new BooksInfoCommand(bookList, scanner, currentUser));
        bookCommands.put("add", new BooksAddCommand(currentUser, bookList));
        bookCommands.put("remove", new BooksRemoveCommand(currentUser,scanner,bookList));
        return bookCommands;
    }
}
