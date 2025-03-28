package bg.tu_varna.sit.a2.f23621757.book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        System.out.println("Author: ");
        newBook.setAuthor(scanner.nextLine());
        System.out.println("Title: ");
        newBook.setTitle(scanner.nextLine());
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

    public void remove(String isbn)
    {
        for(Book book:bookList){
            if(book.getIsbn().equals(isbn)){
                bookList.remove(book);
                break;
            }
        }
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
        for (Book book : bookList) {
            switch (option) {
                case "title": {
                    if (book.getTitle().equalsIgnoreCase(search)) {
                        System.out.println(book.getTitle());
                        System.out.println(book.getAuthor());
                        System.out.println(book.getGenre());
                        System.out.println(book.getIsbn());
                        break;
                    }
                    break;
                }

                case "author": {
                    if (book.getAuthor().equalsIgnoreCase(search)) {
                        System.out.println(book.getTitle());
                        System.out.println(book.getAuthor());
                        System.out.println(book.getGenre());
                        System.out.println(book.getIsbn());
                        break;
                    }
                    break;
                }

                case "tag": {
                    if (book.getTag().equalsIgnoreCase(search)) {
                        System.out.println(book.getTitle());
                        System.out.println(book.getAuthor());
                        System.out.println(book.getGenre());
                        System.out.println(book.getIsbn());
                        break;
                    }
                    break;
                }
            }
        }
    }

    public void readFromFile(String fileName) {
        String filePath = System.getProperty("user.dir") + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = new Book();
                book.setAuthor(line = reader.readLine());
                book.setTitle(line = reader.readLine());
                book.setGenre(line = reader.readLine());
                book.setDescription(line = reader.readLine());
                book.setYearOfPublishing(Integer.parseInt(line = reader.readLine()));
                book.setTag(line = reader.readLine());
                book.setRating(Double.parseDouble(line = reader.readLine()));
                book.setIsbn(line = reader.readLine());
                line = reader.readLine();
                bookList.add(book);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void clear(){
        bookList.clear();
    }

}
