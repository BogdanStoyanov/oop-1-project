package bg.tu_varna.sit.a2.f23621757.application;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.CommandSetter;
import bg.tu_varna.sit.a2.f23621757.file.FileCreator;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ApplicationLibrary {
    public static void main(String[] args) {
        ConsolePrinter.welcome();
        Scanner scanner = new Scanner(System.in);
        CurrentUser currentUser = new CurrentUser(false, "", false, false);
        BookList bookList = new BookList();
        UserList userList = new UserList();
        userList.add("admin","i<2Java",true);
        String userFile="user.txt";
        WriterToFile.writeUsersToFile(userList,userFile);

        Map<String, Runnable> commands = CommandSetter.setCommands(scanner, currentUser, bookList, userList,userFile);
        String currentCommand;
        do {
            currentCommand = scanner.next();
            if (commands.containsKey(currentCommand)) {
                commands.get(currentCommand).run();
            } else {
                System.out.println("Unknown command.");
            }
        } while (!currentCommand.equals("exit"));
    }

}
