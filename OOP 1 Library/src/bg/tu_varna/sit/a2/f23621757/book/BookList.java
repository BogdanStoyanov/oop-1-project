package bg.tu_varna.sit.a2.f23621757.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
    private List<Book> bookList;

    public BookList() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void add(){
        Book newBook = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        newBook.setTitle(scanner.nextLine());
        System.out.println("Author: ");
        newBook.setAuthor(scanner.nextLine());
        System.out.println("Genre: ");
        newBook.setGenre(scanner.nextLine());
        System.out.println("Description: ");
        newBook.setDescription(scanner.nextLine());
        System.out.println("Year of publishing: ");
        newBook.setYearOfPublishing(Integer.parseInt(scanner.nextLine()));
        System.out.println("Tag: ");
        newBook.setTag(scanner.nextLine());
        System.out.println("Rating: ");
        newBook.setRating(Double.parseDouble(scanner.nextLine()));
        System.out.println("ISBN: ");
        newBook.setIsbn(scanner.nextLine());

        bookList.add(newBook);
    }

    public void all() {
        for (Book item : bookList) {
            System.out.println(item.getTitle());
            System.out.println(item.getAuthor());
            System.out.println(item.getGenre());
            System.out.println(item.getIsbn());
        }
    }

    public void info(String isbn) {
        for (Book item : bookList) {
            if (item.getTitle().equals(isbn)) {
                System.out.println(item.getTitle());
                System.out.println(item.getAuthor());
                System.out.println(item.getGenre());
                System.out.println(item.getDescription());
                System.out.println(item.getYearOfPublishing());
                System.out.println(item.getTag());
                System.out.println(item.getRating());
                System.out.println(item.getIsbn());
                break;
            }
        }
    }

    public void find(String option, String search) {
        switch (option) {
            case "title":
                for (Book item : bookList) {
                    if (item.getTitle().equalsIgnoreCase(search)) {
                        System.out.println(item.getTitle());
                        System.out.println(item.getAuthor());
                        System.out.println(item.getGenre());
                        System.out.println(item.getIsbn());
                        break;
                    }
                }
                break;

            case "author":
                for (Book item : bookList) {
                    if (item.getAuthor().equalsIgnoreCase(search)) {
                        System.out.println(item.getTitle());
                        System.out.println(item.getAuthor());
                        System.out.println(item.getGenre());
                        System.out.println(item.getIsbn());
                        break;
                    }
                }
                break;

            case "tag":
                for (Book item : bookList) {
                    if (item.getTag().equalsIgnoreCase(search)) {
                        System.out.println(item.getTitle());
                        System.out.println(item.getAuthor());
                        System.out.println(item.getGenre());
                        System.out.println(item.getIsbn());
                        break;
                    }
                }
                break;
        }
    }

    //public void view Нямам идея какво се иска

    
}
