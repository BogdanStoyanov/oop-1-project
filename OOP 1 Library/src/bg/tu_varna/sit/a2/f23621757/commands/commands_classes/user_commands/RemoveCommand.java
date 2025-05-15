package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.user_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.Scanner;


/**
 * Класът служи за премахване на потребител от системата.
 * <p>
 * Само влязъл потребител с администраторски права може да използва тази команда.
 * След премахване, списъкът с потребители се записва обратно във файл.
 * </p>
 */
public class RemoveCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private UserList userList;
    private String userFile;

    /**
     * Конструктор за инициализация на RemoveCommand.
     *
     * @param scanner     обект за въвеждане от конзолата
     * @param currentUser текущият влязъл потребител
     * @param userList    списък с потребители
     * @param userFile    път до файла, в който се съхраняват потребителите
     */
    public RemoveCommand(Scanner scanner, CurrentUser currentUser, UserList userList, String userFile) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.userList = userList;
        this.userFile = userFile;
    }

    /**
     * Изпълнява премахване на потребител.
     * <ul>
     *   <li>Проверява дали потребителят е влязъл в системата</li>
     *   <li>Проверява дали е администратор</li>
     *   <li>Премахва потребителя по подадено потребителско име</li>
     *   <li>Записва обновения списък във файла</li>
     * </ul>
     */
    @Override
    public void executeCommand() {
        String username;
        username = scanner.next();
        if (!currentUser.isHasLoggedIn()) {
            ConsolePrinter.askForUser();
            return;
        }
        if (!currentUser.isAdmin()) {
            ConsolePrinter.askForAdmin();
            return;
        }
        userList.remove(username);
        WriterToFile.writeUsersToFile(userList, userFile);
    }
}
