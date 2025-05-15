package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.commands.commands_setter.BookCommandSetter;
import bg.tu_varna.sit.a2.f23621757.commands.commands_setter.UserCommandSetter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.Map;
import java.util.Scanner;

/**
 * Команда, която служи като входна точка за потребителските команди.
 * <p>
 * Извиква се, когато потребителят въведе команда, свързана с управление
 * на потребители (например add, remove, login, logout и др.).
 * Командата използва {@link UserCommandSetter}, за да получи съответната команда и я изпълнява.
 * </p>
 */
public class UserCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private BookList bookList;
    private UserList userList;
    private String userFile;


    /**
     * Конструктор за инициализиране на командата UserCommand.
     *
     * @param scanner    входен поток от команди
     * @param currentUser текущо активният потребител
     * @param bookList   списък с книги
     * @param userList   списък с потребители
     * @param userFile   име на файла за потребителски данни
     */
    public UserCommand(Scanner scanner, CurrentUser currentUser, BookList bookList, UserList userList, String userFile) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.bookList = bookList;
        this.userList = userList;
        this.userFile = userFile;
    }


    /**
     * Изпълнява командата, като чете въведената подкоманда и
     */
    @Override
    public void executeCommand() {
        String currentCommand;
        currentCommand = scanner.next();

        Map<String, Command> userCommands = UserCommandSetter.setUserCommands(scanner, currentUser, bookList, userList, userFile);

        if (userCommands.containsKey(currentCommand)) {
            userCommands.get(currentCommand).executeCommand();
        }
    }
}
