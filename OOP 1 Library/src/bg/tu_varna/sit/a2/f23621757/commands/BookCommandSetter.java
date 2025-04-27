package bg.tu_varna.sit.a2.f23621757.commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookCommandSetter {
    public static Map<String,Runnable> setBookCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                   UserList userList, String userFile){
        Map<String, Runnable> bookCommands = new HashMap<>();

        bookCommands.put("all", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            if(!currentUser.isHasOpenedFile()){
                ConsolePrinter.askForFile();
                return;
            }
            bookList.all();
        });

        bookCommands.put("find", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            String option, search;
            option = scanner.next();
            search = scanner.next();
            bookList.find(option, search);
        });

        bookCommands.put("sort", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }

            //Да се направи
        });

        bookCommands.put("info", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }

            String isbn;
            isbn = scanner.next();
            bookList.info(isbn);
        });

        bookCommands.put("add", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            if(!currentUser.isAdmin()){
                ConsolePrinter.askForAdmin();
            }
            bookList.add();
        });

        bookCommands.put("remove", () -> {
            if(!currentUser.isHasLoggedIn()){
                ConsolePrinter.askForUser();
                return;
            }
            if(!currentUser.isAdmin()){
                ConsolePrinter.askForAdmin();
            }
            String isbn;
            isbn = scanner.next();
            bookList.remove(isbn);
        });

        return bookCommands;
    }
}
