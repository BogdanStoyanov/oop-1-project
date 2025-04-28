package bg.tu_varna.sit.a2.f23621757.commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.file.FileCreator;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandSetter {
    public static Map<String,Runnable> setCommands(Scanner scanner, CurrentUser currentUser, BookList bookList,
                                                   UserList userList,String userFile){
        Map<String, Runnable> commands = new HashMap<>();

        commands.put("open", () -> {
            String fileName;
            String projectRoot = System.getProperty("user.dir");
            fileName = scanner.next();

            if(currentUser.isHasOpenedFile()){
                System.out.println("You have already opened a new file!\n");
                return;
            }

            File file = new File(projectRoot,"myFiles/"+fileName);
            if (file.exists()) {
                bookList.readFromFile(fileName);
                System.out.println("Successfully opened " + file.getName()+"\n");
            } else {
                FileCreator.createFile(file);
            }
            currentUser.setHasOpenedFile(true);
            currentUser.setCurrentFileName(fileName);
        });

        commands.put("close", () -> {
            if(!currentUser.isHasOpenedFile()){
                ConsolePrinter.askForFile();
                return;
            }

            System.out.println("Successfully closed " + currentUser.getCurrentFileName()+"!\n");
            currentUser.setHasOpenedFile(false);
            currentUser.setCurrentFileName("");
            bookList.clear();
        });

        commands.put("save", () -> {
            if(!currentUser.isHasOpenedFile()){
                ConsolePrinter.askForFile();
                return;
            }

            WriterToFile.writeBooksToFile(bookList, currentUser.getCurrentFileName());
            System.out.println("Successfully saved " + currentUser.getCurrentFileName()+"\n");
        });

        commands.put("saveas", () -> {
            String fileName;
            fileName = scanner.next();

            if(!currentUser.isHasOpenedFile()){
                ConsolePrinter.askForFile();
                return;
            }

            WriterToFile.writeBooksToFile(bookList, fileName);
            System.out.println("Successfully saved another " + fileName+"!\n");
        });

        commands.put("help",()->{
            System.out.println("open <file>                                                        opens а file");
            System.out.println("close                                                              closes currently opened file");
            System.out.println("save                                                               saves the currently open file");
            System.out.println("saveas <file>                                                      saves the currently open file in <file>");
            System.out.println("help                                                               prints this information");
            System.out.println("login                                                              log into an account");
            System.out.println("logout (account)                                                   log out of an account");
            System.out.println("exit                                                               exists the program");
            System.out.println("books all (account)                                                prints all books");
            System.out.println("books info <isbn_value> (account)                                  prints detailed information of a book with <isbn_value>");
            System.out.println("books find [title, author, tag] <search> (account)                 finds a book by: title, author or tag");
            System.out.println("books sort [title, author, year, rating] [asc | desc] (account)    sorts by a criteria in ascending or descending order");
            System.out.println("books add (account, admin)                                         adds a book");
            System.out.println("books remove <isbn> (account, admin)                               removes a book");
            System.out.println("users add <user> <password> (account, admin)                       adds a user");
            System.out.println("users remove <user> (account, admin)                               removes a user");
            System.out.println();
        });

        commands.put("login", () -> {
            if (currentUser.isHasLoggedIn()) {
                System.out.println("You are already logged in.\n");
                return;
            }

            System.out.println("Please enter a username: ");
            String username = scanner.next();
            System.out.println("Please enter a password: ");
            String password = scanner.next();

            userList.logIn(username,password,currentUser);
        });

        commands.put("logout",()->{
            if (!currentUser.isHasLoggedIn()) {
                System.out.println("You are not logged in.\n");
                return;
            }

            currentUser.setHasLoggedIn(false);
            currentUser.setAdmin(false);
            System.out.println("You successfully logged out.\n");
        });

        commands.put("exit",()->{
            System.out.println("Exiting the program...\n");
        });

        commands.put("books",()->{
            String currentCommand;
            currentCommand = scanner.next();

            Map<String,Runnable> bookCommands = BookCommandSetter.setBookCommands(scanner,currentUser,bookList,userList,userFile);
            if (bookCommands.containsKey(currentCommand)) {
                bookCommands.get(currentCommand).run();
            } else {
                ConsolePrinter.unknownCommand();
            }
        });

        commands.put("users",()->{
            String currentCommand;
            currentCommand = scanner.next();

            Map<String,Runnable> userCommands = UserCommandSetter.setUserCommands(scanner,currentUser,bookList,userList,userFile);
            if (userCommands.containsKey(currentCommand)) {
                userCommands.get(currentCommand).run();
            } else {
                ConsolePrinter.unknownCommand();
            }
        });

        return commands;
    }
}
