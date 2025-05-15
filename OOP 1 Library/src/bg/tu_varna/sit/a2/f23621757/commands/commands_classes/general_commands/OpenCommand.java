package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.FileCreator;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

import java.io.File;
import java.util.Scanner;
/**
 * Команда за отваряне на файл с книги. Ако файлът съществува, данните се зареждат.
 * Ако файлът не съществува, се създава нов.
 */
public class OpenCommand implements Command {
    private Scanner scanner;
    private CurrentUser currentUser;
    private BookList bookList;

    /**
     * Конструктор за инициализиране на командата за отваряне.
     *
     * @param scanner      скенер за вход от потребителя
     * @param currentUser  текущият потребител, използван за проверка на състоянието
     * @param bookList     списък с книги, който ще се зарежда от файл
     */
    public OpenCommand(Scanner scanner, CurrentUser currentUser, BookList bookList) {
        this.scanner = scanner;
        this.currentUser = currentUser;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата по отваряне на файл.
     * Зарежда съдържанието му, ако съществува, или създава нов файл, ако не съществува.
     * Също така обновява състоянието на {@link CurrentUser}.
     */
    @Override
    public void executeCommand() {
        String fileName;
        String projectRoot = System.getProperty("user.dir");
        fileName = scanner.next();

        if (currentUser.isHasOpenedFile()) {
            System.out.println("You have already opened a new file!\n");
            return;
        }

        File file = new File(projectRoot, "myFiles/" + fileName);
        if (file.exists()) {
            bookList.readFromFile(fileName);
            System.out.println("Successfully opened " + file.getName() + "\n");
        } else {
            FileCreator.createFile(file);
        }
        currentUser.setHasOpenedFile(true);
        currentUser.setCurrentFileName(fileName);
    }
}
