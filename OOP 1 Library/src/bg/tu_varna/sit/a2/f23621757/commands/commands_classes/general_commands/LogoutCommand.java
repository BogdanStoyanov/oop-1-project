package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

/**
 * Команда за излизане от текущата сесия на потребителя (Logout).
 * <p>
 * Проверява дали потребителят е влязъл в системата. Ако е, изходът го маркира
 * като излязъл и премахва администраторския му статус (ако има такъв).
 * </p>
 */
public class LogoutCommand implements Command {
    private CurrentUser currentUser;

    /**
     * Конструктор за инициализиране на командата Logout.
     *
     * @param currentUser текущо активният потребител
     */
    public LogoutCommand(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * Изпълнява командата за изход от системата.
     * <p>
     * Ако потребителят не е влязъл, се показва съобщение. В противен случай
     * се извършва изход, като се променя състоянието на потребителя.
     * </p>
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasLoggedIn()) {
            System.out.println("You are not logged in.\n");
            return;
        }

        currentUser.setHasLoggedIn(false);
        currentUser.setAdmin(false);
        System.out.println("You successfully logged out.\n");
    }
}
