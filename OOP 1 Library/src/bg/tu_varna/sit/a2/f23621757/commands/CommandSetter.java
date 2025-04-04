package bg.tu_varna.sit.a2.f23621757.commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.file.FileCreator;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandSetter {
    public static Map<String,Runnable> setCommands(Scanner scanner, CurrentUser currentUser, BookList bookList, UserList userList){
        Map<String, Runnable> commands = new HashMap<>();

        commands.put("open", () -> {
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
            System.out.println("Successfully opened " + fileName);
        });

        commands.put("close", () -> {
            System.out.println("Successfully closed " + currentUser.getCurrentFileName());
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
            System.out.println("Successfully saved " + fileName);
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
            System.out.println("books remove                                               removes a book");
            System.out.println("users add <user> <password>                                adds a user");
            System.out.println("users remove <user>                                        removes a user");
        });

        commands.put("login",()->{
 
        });

        return commands;
    }
}
