package bg.tu_varna.sit.a2.f23621757.application;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.CommandSetter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.Map;
import java.util.Scanner;

/**
 * Входна точка на програмата.
 * Инициализират се основни обекти нужни за нейното изпълнение.
 */
public class ApplicationLibrary {
    /**
     * Основна входна точка на приложението, която инициализира и стартира всички нужни компоненти.
     * Това включва зареждане на данни за потребители и книги, инициализиране на команди
     * и стартиране на основния цикъл за изпълнение на командите.
     *
     * @param args параметри подадени от командния ред
     */
    public static void main(String[] args) {
        ConsolePrinter.welcome();
        Scanner scanner = new Scanner(System.in);
        CurrentUser currentUser = new CurrentUser(false, "", false, false);
        BookList bookList = new BookList();
        UserList userList = new UserList();
        final String userFile = "users.txt";
        userList.readFromFile(userFile);

        Map<String, Runnable> commands = CommandSetter.setCommands(scanner, currentUser, bookList, userList, userFile);
        String currentCommand;
        do {
            currentCommand = scanner.next();
            if (commands.containsKey(currentCommand)) {
                commands.get(currentCommand).run();
            }
        } while (!currentCommand.equals("exit"));
    }
}
