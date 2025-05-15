package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.Console;
import java.util.Scanner;

/**
 * Команда за вход в системата. Изисква потребителско име и парола.
 * <p>
 * Ако вече има влязъл потребител, се показва съобщение и командата не прави нищо.
 * Паролата се въвежда скрито чрез Console readPassword().
 * </p>
 */
public class LoginCommand implements Command {
    private CurrentUser currentUser;
    private Scanner scanner;
    private UserList userList;

    /**
     * Конструктор за инициализация на командата за вход.
     *
     * @param currentUser текущият потребител на приложението
     * @param scanner     скенер за въвеждане на потребителско име
     * @param userList    списък с регистрирани потребители
     */
    public LoginCommand(CurrentUser currentUser, Scanner scanner, UserList userList) {
        this.currentUser = currentUser;
        this.scanner = scanner;
        this.userList = userList;
    }

    /**
     * Изпълнява логиката по вход в системата.
     * Проверява дали вече има логнат потребител.
     * Ако не, изисква потребителско име и скрита парола, след което извиква метода за вход.
     */
    @Override
    public void executeCommand() {
        if (currentUser.isHasLoggedIn()) {
            System.out.println("You are already logged in.\n");
            return;
        }

        System.out.print("Please enter a username: ");
        String username = scanner.next();

        Console console = System.console();
        //https://stackoverflow.com/questions/8138411/masking-password-input-from-the-console-java
        if (console == null) {
            System.out.println("Couldn't get Console instance");
        } else {
            char[] password = console.readPassword("Please enter a password: ");
            String myPassword = new String(password);
            userList.logIn(username, myPassword, currentUser);
        }
    }
}
