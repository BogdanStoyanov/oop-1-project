package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;

/**
 * Класът {@code HelpCommand} реализира интерфейса {@link Command}
 * и представя помощната команда в системата.
 * <p>
 * При извикване извежда в конзолата списък с всички налични команди
 * и тяхното предназначение.
 * </p>
 */
public class HelpCommand implements Command {

    /**
     * Изпълнява командата за помощ, като извежда информация за всички поддържани команди.
     * <p>
     * Това включва команди за работа с файлове, книги, потребители и общи действия.
     * </p>
     */
    @Override
    public void executeCommand() {
        System.out.println("open <file>                                                        opens a file");
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
    }
}
