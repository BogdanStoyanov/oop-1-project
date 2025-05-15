package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.user_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.Scanner;

/**
 * Класът {@code UsersAddCommand} реализира интерфейса {@link Command}
 * и представлява команда за добавяне на нов потребител от администратор.
 * <p>
 * Проверките включват дали потребителят е влязъл в системата и дали има администраторски права.
 * Ако условията са изпълнени, новият потребител се добавя и данните се записват във файл.
 * </p>
 */
public class UsersAddCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private UserList userList;
    private String userFile;

    /**
     * Конструктор с параметри за инициализация на командата.
     *
     * @param scanner     обект за въвеждане от конзолата
     * @param currentUser текущо влязъл потребител
     * @param userList    списък с потребители
     * @param userFile    име на файла, в който се съхраняват потребителите
     */
    public UsersAddCommand(Scanner scanner, CurrentUser currentUser, UserList userList, String userFile) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.userList = userList;
        this.userFile = userFile;
    }

    /**
     * Изпълнява командата за добавяне на потребител.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл в системата</li>
     *   <li>Проверява дали има администраторски права</li>
     *   <li>Проверява дали потребителското име вече съществува</li>
     *   <li>Добавя нов потребител и записва списъка във файл</li>
     * </ul>
     */
    @Override
    public void executeCommand() {
        String username, password;
        username = scanner.next();
        password = scanner.next();

        if (!currentUser.isHasLoggedIn()) {
            ConsolePrinter.askForUser();
            return;
        }
        if (!currentUser.isAdmin()) {
            ConsolePrinter.askForAdmin();
            return;
        }
        if (userList.checkForUsername(username)) {
            System.out.println("Username already exists!");
            return;
        }

        userList.add(username, password, false);
        WriterToFile.writeUsersToFile(userList, userFile);
        System.out.println("Successfully added a user!\n");
    }
}
