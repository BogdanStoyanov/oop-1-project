package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_setter.BookCommandSetter;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;
import bg.tu_varna.sit.a2.f23621757.user.UserList;

import java.util.Map;
import java.util.Scanner;

/**
 * Команда, която служи като входна точка за командите свързани с книги.
 * <p>
 * Извиква се, когато потребителят въведе команда от типа <code>books</code>,
 * последвана от подкоманда (например add, remove, find и т.н.).
 * </p>
 */
public class BooksCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private BookList bookList;
    private UserList userList;
    private String userFile;

    /**
     * Конструктор за инициализиране на командата BooksCommand.
     *
     * @param scanner     входен поток за четене на команди
     * @param currentUser текущо логнатият потребител
     * @param bookList    списък с книги
     * @param userList    списък с потребители
     * @param userFile    файл, съдържащ потребителски данни
     */
    public BooksCommand(Scanner scanner, CurrentUser currentUser, BookList bookList, UserList userList, String userFile) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.bookList = bookList;
        this.userList = userList;
        this.userFile = userFile;
    }

    /**
     * Изпълнява командата, като извлича въведената подкоманда и я предава
     * на съответния обект {@link Command} чрез {@link BookCommandSetter}.
     */
    @Override
    public void executeCommand() {
        String currentCommand;
        currentCommand = scanner.next();

        Map<String, Command> bookCommands = BookCommandSetter.setBookCommands(scanner, currentUser, bookList, userList, userFile);

        if (bookCommands.containsKey(currentCommand)) {
            bookCommands.get(currentCommand).executeCommand();
        }
    }
}
