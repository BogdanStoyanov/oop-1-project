package bg.tu_varna.sit.a2.f23621757.book;

import java.util.List;
import java.util.Objects;

public class Book {
    private String author;
    private String title;
    private String genre;
    private String description;
    private int yearOfPublishing;
    private String keyWords;
    private double rating;
    private String libraryID;

    public Book(String author, String title, String genre, String description, int yearOfPublishing, String keyWords, double rating, String libraryID) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.yearOfPublishing = yearOfPublishing;
        this.keyWords = keyWords;
        this.rating = rating;
        this.libraryID = libraryID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublishing == book.yearOfPublishing && Double.compare(rating, book.rating) == 0 && Objects.equals(author, book.author) && Objects.equals(title, book.title) && Objects.equals(genre, book.genre) && Objects.equals(description, book.description) && Objects.equals(keyWords, book.keyWords) && Objects.equals(libraryID, book.libraryID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, genre, description, yearOfPublishing, keyWords, rating, libraryID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", keyWords='" + keyWords + '\'' +
                ", rating=" + rating +
                ", libraryID='" + libraryID + '\'' +
                '}';
    }
}
