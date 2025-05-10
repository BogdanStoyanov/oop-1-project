package bg.tu_varna.sit.a2.f23621757.book;

import java.util.Objects;


/**
 * Представя книга в библиотеката.
 * Съдържа информация като автор, заглавие, жанр, описание, ключови думи, рейтинг и уникален номер (ISBN).
 */
public class Book {
    private String author;
    private String title;
    private String genre;
    private String description;
    private int yearOfPublishing;
    private String tag;
    private double rating;
    private String isbn;

    /**
     * Създава нов празен обект от тип Book.
     */
    public Book() {

    }

    /**
     * Връща автора на книгата.
     *
     * @return автор на книгата
     */

    public String getAuthor() {
        return author;
    }

    /**
     * Задава автора на книгата.
     *
     * @param author автор на книгата
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Връща заглавието на книгата.
     *
     * @return заглавие на книгата
     */
    public String getTitle() {
        return title;
    }

    /**
     * Задава заглавието на книгата.
     *
     * @param title заглавие на книгата
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Връща жанра на книгата.
     *
     * @return жанр на книгата
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Задава жанра на книгата.
     *
     * @param genre жанр на книгата
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Връща краткото описание на книгата.
     *
     * @return описание на книгата
     */
    public String getDescription() {
        return description;
    }

    /**
     * Задава краткото описание на книгата.
     *
     * @param description описание на книгата
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Връща годината на издаване.
     *
     * @return година на издаване
     */
    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    /**
     * Задава годината на издаване.
     *
     * @param yearOfPublishing година на издаване
     */
    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    /**
     * Връща ключовите думи (т.нар. таг).
     *
     * @return ключови думи
     */
    public String getTag() {
        return tag;
    }

    /**
     * Задава ключови думи (таг).
     *
     * @param tag ключови думи
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Връща рейтинга на книгата.
     *
     * @return рейтинг (от 0.0 до 5.0)
     */
    public double getRating() {
        return rating;
    }

    /**
     * Задава рейтинга на книгата.
     *
     * @param rating рейтинг (от 0 до 5)
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Връща уникалния идентификатор (ISBN) на книгата.
     *
     * @return ISBN номер
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Задава уникалния идентификатор (ISBN) на книгата.
     *
     * @param isbn ISBN номер
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Проверява дали две книги са еднакви по съдържание.
     *
     * @param o другият обект
     * @return true, ако всички полета съвпадат
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing && Double.compare(rating, book.rating) == 0 && Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(genre, book.genre) && Objects.equals(description, book.description) && Objects.equals(tag, book.tag) && Objects.equals(isbn, book.isbn);
    }

    /**
     * Генерира хеш код за книгата.
     *
     * @return хеш стойност
     */
    @Override
    public int hashCode() {
        return Objects.hash(author, title, genre, description, yearOfPublishing, tag, rating, isbn);
    }

    /**
     * Връща текстово представяне на книгата.
     *
     * @return низ с информация за книгата
     */
    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", keyWords='" + tag + '\'' +
                ", rating=" + rating +
                ", libraryID='" + isbn + '\'' +
                '}';
    }
}
