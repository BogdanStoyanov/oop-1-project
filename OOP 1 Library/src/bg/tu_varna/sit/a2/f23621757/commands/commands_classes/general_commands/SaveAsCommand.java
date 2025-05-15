package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.util.Scanner;

/**
 * Команда за записване на книгите в нов файл с различно име (Save As).
 * <p>
 * Изисква вече да е отворен файл, за да може да се изпълни успешно.
 * Позволява на потребителя да въведе ново име на файл, в който се записва списъкът с книги.
 * </p>
 */
public class SaveAsCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private BookList bookList;

    /**
     * Конструктор за инициализиране на командата Save As.
     *
     * @param scanner      скенер за четене на новото име на файл от потребителя
     * @param currentUser  текущо активният потребител
     * @param bookList     списък с книги, който ще се запише
     */
    public SaveAsCommand(Scanner scanner, CurrentUser currentUser, BookList bookList) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата Save As.
     * <p>
     * Ако не е отворен файл, показва съобщение. В противен случай
     * прочита новото име на файл от входа и записва книгите там.
     * </p>
     */
    @Override
    public void executeCommand() {
        String fileName;
        fileName = scanner.next();

        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }

        WriterToFile.writeBooksToFile(bookList, fileName);
        System.out.println("Successfully saved another " + fileName + "!\n");
    }
}
