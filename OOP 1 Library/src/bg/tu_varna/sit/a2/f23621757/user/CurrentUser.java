package bg.tu_varna.sit.a2.f23621757.user;

/**
 * Класът {@code CurrentUser} представя състоянието на текущо активния потребител в системата.
 * Съдържа информация дали потребителят е влязъл в профил, дали е администратор,
 * дали е отворен файл и името на текущо отворения файл.
 */
public class CurrentUser {
    private boolean hasOpenedFile;
    private String currentFileName;
    private boolean hasLoggedIn;
    private boolean isAdmin;

    /**
     * Конструктор за създаване на обект от типа {@code CurrentUser}.
     *
     * @param hasOpenedFile   дали е отворен файл
     * @param currentFileName име на текущо отворения файл
     * @param hasLoggedIn     дали потребителят е влязъл в профил
     * @param isAdmin         дали потребителят има администраторски права
     */
    public CurrentUser(boolean hasOpenedFile, String currentFileName, boolean hasLoggedIn, boolean isAdmin) {
        this.hasOpenedFile = hasOpenedFile;
        this.currentFileName = currentFileName;
        this.hasLoggedIn = hasLoggedIn;
        this.isAdmin = isAdmin;
    }

    /**
     * Проверява дали е отворен файл.
     *
     * @return {@code true} ако има отворен файл, в противен случай {@code false}
     */
    public boolean isHasOpenedFile() {
        return hasOpenedFile;
    }

    /**
     * Задава състоянието за отворен файл.
     *
     * @param hasOpenedFile {@code true}, ако е отворен файл
     */
    public void setHasOpenedFile(boolean hasOpenedFile) {
        this.hasOpenedFile = hasOpenedFile;
    }

    /**
     * Проверява дали потребителят е влязъл в профил.
     *
     * @return {@code true}, ако е влязъл, иначе {@code false}
     */
    public boolean isHasLoggedIn() {
        return hasLoggedIn;
    }

    /**
     * Задава състоянието за логнат потребител.
     *
     * @param hasLoggedIn {@code true}, ако потребителят е логнат
     */
    public void setHasLoggedIn(boolean hasLoggedIn) {
        this.hasLoggedIn = hasLoggedIn;
    }

    /**
     * Връща името на текущо отворения файл.
     *
     * @return име на файла
     */
    public String getCurrentFileName() {
        return currentFileName;
    }

    /**
     * Задава името на текущо отворения файл.
     *
     * @param currentFileName име на файла
     */
    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
    }

    /**
     * Проверява дали потребителят има администраторски права.
     *
     * @return {@code true}, ако е администратор
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Задава дали потребителят е администратор.
     *
     * @param admin {@code true}, ако е администратор
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
