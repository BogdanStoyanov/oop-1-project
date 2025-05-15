package bg.tu_varna.sit.a2.f23621757.commands.commands_setter;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_classes.user_commands.RemoveCommand;
import bg.tu_varna.sit.a2.f23621757.commands.commands_classes.user_commands.UsersAddCommand;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класът {@code UserCommandSetter} предоставя метод за настройване на
 * команди, свързани с операции върху потребутели.
 * <p>
 * Използва обекти за представяне на действия,
 * които могат да се извикват по команда от потребителския интерфейс.
 */
public class UserCommandSetter {
    /**
     * Методът {@code setUserCommands} дефинира команди за управление на потребители
     * и връща {@code Map}, свързващ всяка команда с нейното поведение.
     * <p>
     * Позволява добавяне и премахване на потребители само от администратор.
     *
     * @param scanner     {@code Scanner} обект за въвеждане на данни от потребителя
     * @param currentUser текущият потребител, използван за проверка на права
     * @param bookList    списък с книги (не се използва директно тук, но се подава за съвместимост)
     * @param userList    списък с всички регистрирани потребители
     * @param userFile    път до файла с потребителска информация
     * @return {@code Map} с командите за потребителско управление
     */
    public static Map<String, Command> setUserCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                       UserList userList, String userFile) {
        Map<String, Command> userCommands = new HashMap<>();
        userCommands.put("add", new UsersAddCommand(scanner, currentUser, userList, userFile));
        userCommands.put("remove", new RemoveCommand(scanner, currentUser, userList, userFile));
        return userCommands;
    }
}
