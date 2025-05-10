package bg.tu_varna.sit.a2.f23621757.printer;

/**
 * Класът {@code ConsolePrinter} съдържа статични методи за отпечатване
 * на често използвани съобщения в конзолата.
 * Използва се за подобряване на четимостта и централизиране на съобщенията към потребителя.
 */
public class ConsolePrinter {
    /**
     * Извежда приветствено съобщение при стартиране на програмата.
     */
    public static void welcome() {
        System.out.println("Welcome! If you don't know the commands type 'help'!\n");
    }

    /**
     * Извежда съобщение, когато потребител се опита да използва команда без да е влязъл в профил.
     */
    public static void askForUser() {
        System.out.println("You need to be logged in to use this command!\n");
    }

    /**
     * Извежда съобщение, когато потребител се опита да използва администраторска команда без нужните права.
     */
    public static void askForAdmin() {
        System.out.println("You need to be an admin to use this command!\n");
    }

    /**
     * Извежда съобщение при въведена невалидна или неизвестна команда.
     */
    public static void unknownCommand() {
        System.out.println("Unknown command!\n");
    }

    /**
     * Извежда съобщение, когато потребител се опита да използва команда, изискваща отворен файл.
     */
    public static void askForFile() {
        System.out.println("You haven't opened a file!\n");
    }
}
