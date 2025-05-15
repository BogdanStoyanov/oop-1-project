package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;

public class ExitCommand implements Command {
    @Override
    public void executeCommand() {
        System.out.println("Exiting the program...\n");
    }
}
