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
            if(currentUser.isHasOpenedFile()){
                System.out.println("You have already opened a file!");
                return;
            }

            String fileName;
            fileName = scanner.next();
            String filePath = System.getProperty("user.dir") + File.separator + fileName;

            File file = new File(filePath);
            if (file.exists()) {
                bookList.readFromFile(fileName);
            } else {
                FileCreator.createFile(file);
            }
            currentUser.setHasOpenedFile(true);
            currentUser.setCurrentFileName(fileName);
        });

        commands.put("close", () -> {
            System.out.println("Successfully closed " + currentUser.getCurrentFileName()+"!");
            currentUser.setHasOpenedFile(false);
            currentUser.setCurrentFileName("");
            bookList.clear();
        });

        commands.put("save", () -> {
            WriterToFile.writeBooksToFile(bookList, currentUser.getCurrentFileName());
            System.out.println("Successfully saved " + currentUser.getCurrentFileName());
        });

        commands.put("saveas", () -> {
            String fileName;
            fileName = scanner.next();
            WriterToFile.writeBooksToFile(bookList, fileName);
            System.out.println("Successfully saved another" + fileName+"!");
        });

        commands.put("help",()->{
            System.out.println("open <file>                                                opens а file");
            System.out.println("close                                                      closes currently opened file");
            System.out.println("save                                                       saves the currently open file");
            System.out.println("saveas <file>                                              saves the currently open file in <file>");
            System.out.println("help                                                       prints this information");
            System.out.println("login                                                      log into an account");
            System.out.println("logout                                                     log out of an account");
            System.out.println("exit                                                       exists the program");
            System.out.println("books all                                                  prints all books");
            System.out.println("books info <isbn_value>                                    prints detailed information of a book with <isbn_value>");
            System.out.println("books find [title, author, tag] <search>                   finds a book by: title, author or tag");
            System.out.println("books sort [title, author, year, rating] [asc | desc]      sorts by a criteria in ascending or descending order");
            System.out.println("books add                                                  adds a book");
            System.out.println("books remove <isbn>                                        removes a book");
            System.out.println("users add <user> <password>                                adds a user");
            System.out.println("users remove <user>                                        removes a user");
        });

        commands.put("login", () -> {
            if (currentUser.isHasLoggedIn()) {
                System.out.println("You are already logged in.");
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
                System.out.println("You are not logged in.");
                return;
            }

            currentUser.setHasLoggedIn(false);
            currentUser.setAdmin(false);
            System.out.println("You successfully logged out.");
        });

        commands.put("exit",()->{
            System.out.println("Exiting the program...");
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
