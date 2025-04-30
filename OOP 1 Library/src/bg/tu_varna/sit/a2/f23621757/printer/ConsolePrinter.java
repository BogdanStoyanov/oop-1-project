package bg.tu_varna.sit.a2.f23621757.printer;

public class ConsolePrinter {
    public static void welcome() {
        System.out.println("Welcome! If you don't know the commands type 'help'!\n");
    }

    public static void askForUser() {
        System.out.println("You need to be logged in to use this command!\n");
    }

    public static void askForAdmin() {
        System.out.println("You need to be an admin to use this command!\n");
    }

    public static void unknownCommand() {
        System.out.println("Unknown command!\n");
    }

    public static void askForFile() {
        System.out.println("You haven't opened a file!\n");
    }
}
