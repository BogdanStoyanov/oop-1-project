package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

/**
 * Класът {@code CloseCommand} реализира интерфейса {@link Command}
 * и предоставя функционалност за затваряне на текущо отворения файл.
 * <p>
 * При изпълнение на командата се проверява дали има отворен файл,
 * извежда се съобщение за успешно затваряне и се нулира състоянието на текущия потребител.
 * </p>
 */
public class CloseCommand implements Command {
    private CurrentUser currentUser;
    private BookList bookList;

    /**
     * Конструктор с параметри за текущ потребител и списък с книги.
     *
     * @param currentUser обект, съдържащ информация за текущия потребител
     * @param bookList    списък с книги, асоцииран с текущия файл
     */
    public CloseCommand(CurrentUser currentUser, BookList bookList) {
        this.currentUser = currentUser;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за затваряне на файл.
     * <p>
     * Ако няма отворен файл, се извежда подходящо съобщение.
     * В противен случай се затваря файлът, изчистват се книгите от списъка
     * и се нулира информацията за текущия файл.
     * </p>
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }

        System.out.println("Successfully closed " + currentUser.getCurrentFileName() + "!\n");
        currentUser.setHasOpenedFile(false);
        currentUser.setCurrentFileName("");
        bookList.clear();
    }
}
