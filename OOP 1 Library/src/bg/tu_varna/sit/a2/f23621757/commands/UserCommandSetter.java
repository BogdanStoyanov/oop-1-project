package bg.tu_varna.sit.a2.f23621757.commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserCommandSetter {
    public static Map<String,Runnable> setUserCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                       UserList userList, String userFile){
        Map<String, Runnable> userCommands = new HashMap<>();

        userCommands.put("add", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            if(!currentUser.isAdmin()){
                ConsolePrinter.askForAdmin();
            }

            String username,password;
            username = scanner.next();
            password = scanner.next();
            userList.add(username,password,false);
            WriterToFile.writeUsersToFile(userList,userFile);
            System.out.println("Successfully added a user!");
        });

        userCommands.put("remove", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            if(!currentUser.isAdmin()){
                ConsolePrinter.askForAdmin();
            }

            String username;
            username = scanner.next();
            userList.remove(username);
            WriterToFile.writeUsersToFile(userList,userFile);
        });

        return userCommands;
    }
}
