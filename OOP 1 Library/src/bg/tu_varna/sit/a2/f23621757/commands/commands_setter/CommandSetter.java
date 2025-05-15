package bg.tu_varna.sit.a2.f23621757.commands.commands_setter;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands.*;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класът {@code CommandSetter} предоставя метод за управляване на
 * файлове, потребители и книги.
 * <p>
 * Използва обекти за представяне на действия,
 * които могат да се извикват по команда от потребителския интерфейс.
 */
public class CommandSetter {
    /**
     * Настройва и връща мапа от с всички основни команди на системата.
     * Тези команди позволяват управление на:
     * <ul>
     *     <li>файлове (open, close, save, saveas)</li>
     *     <li>потребители (login, logout, users)</li>
     *     <li>книги (books)</li>
     *     <li>други операции (help, exit)</li>
     * </ul>
     *
     * @param scanner     {@code Scanner} за въвеждане на данни от потребителя
     * @param currentUser следи дали текущия потребител е: отворил файл; логнат; админ; името на файла, ако го е отворил
     * @param bookList    списъкът с книги, върху който ще се прилагат командите
     * @param userList    списъкът с потребители
     * @param userFile    име на файла, съдържащ потребителските данни
     * @return Map, който съпоставя име на команда с нейното действие
     */
    public static Map<String, Command> setCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                   UserList userList, String userFile) {
        Map<String, Command> commands = new HashMap<>();
        commands.put("open", new OpenCommand(scanner, currentUser, bookList));
        commands.put("close", new CloseCommand(currentUser, bookList));
        commands.put("save", new SaveCommand(currentUser, bookList));
        commands.put("saveas", new SaveAsCommand(scanner, currentUser, bookList));
        commands.put("help", new HelpCommand());
        commands.put("login", new LoginCommand(currentUser, scanner, userList));
        commands.put("logout", new LogoutCommand(currentUser));
        commands.put("books", new BooksCommand(scanner, currentUser, bookList, userList, userFile));
        commands.put("users", new UserCommand(scanner, currentUser, bookList, userList, userFile));
        commands.put("exit", new ExitCommand());
        return commands;
    }
}
