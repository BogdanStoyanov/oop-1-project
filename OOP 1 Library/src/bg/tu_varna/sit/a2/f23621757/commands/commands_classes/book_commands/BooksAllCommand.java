package bg.tu_varna.sit.a2.f23621757.commands.commands_classes.book_commands;

import bg.tu_varna.sit.a2.f23621757.book.BookList;
import bg.tu_varna.sit.a2.f23621757.commands.commands_interface.Command;
import bg.tu_varna.sit.a2.f23621757.printer.ConsolePrinter;
import bg.tu_varna.sit.a2.f23621757.user.CurrentUser;

/**
 * Класът {@code BooksAllCommand} предоставя
 * функционалност за извеждане на всички книги от текущия списък.
 * <p>
 * Командата проверява дали текущият потребител е влязъл в системата и дали има отворен файл.
 * При успешно изпълнение извежда всички книги чрез метода {@link BookList#all()}.
 * </p>
 */
public class BooksAllCommand implements Command {
    private CurrentUser currentUser;
    private BookList bookList;

    /**
     * Конструктор за създаване на BooksAllCommand.
     *
     * @param currentUser текущият потребител
     * @param bookList    списък с книги, който ще бъде изведен
     */
    public BooksAllCommand(CurrentUser currentUser, BookList bookList) {
        this.currentUser = currentUser;
        this.bookList = bookList;
    }

    /**
     * Изпълнява командата за извеждане на всички книги.
     * <p>
     * Проверява дали потребителят е влязъл в системата и дали има отворен файл.
     * Ако проверките са успешни, извиква метода {@code all()} на {@link BookList}.
     * Ако не, принтира подходящо съобщение чрез {@link ConsolePrinter}.
     * </p>
     */
    @Override
    public void executeCommand() {
        if (!currentUser.isHasLoggedIn()) {
            ConsolePrinter.askForUser();
            return;
        }
        if (!currentUser.isHasOpenedFile()) {
            ConsolePrinter.askForFile();
            return;
        }
        bookList.all();
    }
}
