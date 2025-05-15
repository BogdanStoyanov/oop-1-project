package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.general_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.file.WriterToFile;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

/**
 * Команда за запазване на текущо отворения файл с книги.
 * <p>
 * Ако няма отворен файл, показва съобщение чрез {@link ConsolePrinter#askForFile()}.
 * В противен случай записва книгите във файла чрез {@link WriterToFile#writeBooksToFile(BookList, String)}.
 * </p>
 */
public class SaveCommand implements Command {
    private CurrentUser currentUser;
    private BookList bookList;

    /**
     * Създава нова инстанция на командата за запис на файл.
     *
     * @param currentUser текущият потребител, използва се за проверка и име на файл
     * @param bookList списък с книги, който ще бъде записан
     */
    public SaveCommand(CurrentUser currentUser, BookList bookList) {
        this.currentUser = currentUser;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за запис на файла.
     * Ако не е отворен файл, показва съобщение.
     * Ако е отворен файл, записва съдържанието на {@code bookList} в него.
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }

        WriterToFile.writeBooksToFile(bookList, currentUser.getCurrentFileName());
        System.out.println("Successfully saved " + currentUser.getCurrentFileName() + "\n");
    }
}
