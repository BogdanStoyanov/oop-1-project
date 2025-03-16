package bg.tu_varna.sit.a2.f23621757.printer;

public class ConsolePrinter {
    public static void welcome() {
        System.out.println("Welcome! Would you like to log in?");
    }

    public static void askForUser() {
        System.out.println("You need to be logged in to use this command!");
    }

    public static void askForAdmin() {
        System.out.println("You need to be an admin to use this command!");
    }
}
