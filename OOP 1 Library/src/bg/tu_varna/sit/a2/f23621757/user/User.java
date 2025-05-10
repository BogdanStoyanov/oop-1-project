package bg.tu_varna.sit.a2.f23621757.user;

import java.util.Objects;

/**
 * Класът {@code User} представя потребител в системата.
 * Съдържа информация за потребителско име, парола и дали потребителят е администратор.
 */
public class User {
    private String username;
    private String password;
    private boolean isAdmin;

    /**
     * Конструктор с параметри за създаване на потребител.
     *
     * @param username потребителско име
     * @param password парола
     * @param isAdmin  дали потребителят е администратор
     */
    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * Конструктор по подразбиране.
     */
    public User() {

    }

    /**
     * Връща потребителското име.
     *
     * @return потребителско име
     */
    public String getUsername() {
        return username;
    }

    /**
     * Задава потребителско име.
     *
     * @param username новото потребителско име
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Връща паролата на потребителя.
     *
     * @return парола
     */
    public String getPassword() {
        return password;
    }

    /**
     * Задава нова парола на потребителя.
     *
     * @param password новата парола
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Проверява дали потребителят има администраторски права.
     *
     * @return {@code true} ако е администратор, {@code false} в противен случай
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Задава дали потребителят е администратор.
     *
     * @param admin {@code true} ако е администратор
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * Проверява дали два обекта от тип {@code User} са равни.
     *
     * @param o друг обект
     * @return {@code true} ако обектите са равни
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin == user.isAdmin && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    /**
     * Генерира хеш код за потребителя.
     *
     * @return хеш код
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password, isAdmin);
    }

    /**
     * Връща текстово представяне на обекта {@code User}.
     *
     * @return низ, представящ потребителя
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
