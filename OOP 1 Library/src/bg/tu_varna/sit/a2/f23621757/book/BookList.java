package bg.tu_varna.sit.a2.f23621757.book;

import java.io.*;
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

    public void add() {
        Book newBook = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Author: ");
        newBook.setAuthor(scanner.nextLine());
        System.out.print("Title: ");
        newBook.setTitle(scanner.nextLine());
        System.out.print("Genre: ");
        newBook.setGenre(scanner.nextLine());
        System.out.print("Description: ");
        newBook.setDescription(scanner.nextLine());
        System.out.print("Year of publishing: ");
        newBook.setYearOfPublishing(Integer.parseInt(scanner.nextLine()));
        System.out.print("Tag: ");
        newBook.setTag(scanner.nextLine());
        System.out.print("Rating: ");
        newBook.setRating(Double.parseDouble(scanner.nextLine()));
        System.out.print("ISBN: ");
        newBook.setIsbn(scanner.nextLine());
        bookList.add(newBook);
        System.out.println("Successfully added a book!\n");
    }

    public void remove(String isbn) {
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                bookList.remove(book);
                System.out.println("Successfully removed a book!\n");
                return;
            }
        }
        System.out.println("Book with isbn: " + isbn + " not found!\n");
    }

    public void all() {
        for (Book item : bookList) {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor());
            System.out.println("Genre: " + item.getGenre());
            System.out.println("ISBN: " +item.getIsbn());
            System.out.println("***********************************************************");
        }
        System.out.println();
    }

    public void info(String isbn) {
        for (Book item : bookList) {
            if (item.getIsbn().equals(isbn)) {
                System.out.println("Title: " + item.getTitle());
                System.out.println("Author: " + item.getAuthor());
                System.out.println("Genre: " + item.getGenre());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Year: " + item.getYearOfPublishing());
                System.out.println("Tag: "+ item.getTag());
                System.out.println("Rating: " + item.getRating());
                System.out.println("ISBN: " + item.getIsbn());
                System.out.println();
                return;
            }
        }

        System.out.println("Book with isbn: " + isbn + " not found!\n");
    }

    public void find(String option, String search) {
        for (Book book : bookList) {
            switch (option) {
                case "title": {
                    if (book.getTitle().equalsIgnoreCase(search)) {
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("***********************************************************");
                        System.out.println();
                    }
                    break;
                }
                case "author": {
                    if (book.getAuthor().equalsIgnoreCase(search)) {
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("***********************************************************");
                        System.out.println();
                    }
                    break;
                }
                case "tag": {
                    if (book.getTag().equalsIgnoreCase(search)) {
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Genre: " + book.getGenre());
                        System.out.println("ISBN: " + book.getIsbn());
                        System.out.println("***********************************************************");
                        System.out.println();
                    }
                    break;
                }
            }
        }
    }

    public void readFromFile(String fileName) {
        String projectRoot = System.getProperty("user.dir");
        File file = new File(projectRoot, "myFiles/" + fileName);

        if (!file.exists()) {
            System.out.println("User file doesn't exist");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = new Book();
                book.setAuthor(line);
                book.setTitle(line = reader.readLine());
                book.setGenre(line = reader.readLine());
                book.setDescription(line = reader.readLine());
                book.setYearOfPublishing(Integer.parseInt(line = reader.readLine()));
                book.setTag(line = reader.readLine());
                book.setRating(Double.parseDouble(line = reader.readLine()));
                book.setIsbn(line = reader.readLine());
                bookList.add(book);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void clear() {
        bookList.clear();
    }

    //https://www.geeksforgeeks.org/insertion-sort-algorithm/
    public void insertionSort(String criteria, String order) {
        boolean reverse = false;
        if (order.equals("asc")) {
            reverse = false;
        } else if (order.equals("desc")) {
            reverse = true;
        }

        for (int i = 1; i < bookList.size(); i++) {
            Book key = bookList.get(i);
            int j = i - 1;

            switch (criteria) {
                case "title": {
                    while (j >= 0 && ((bookList.get(j).getTitle().compareToIgnoreCase(key.getTitle()) > 0) ^ reverse)) {
                        bookList.set(j + 1, bookList.get(j));
                        j--;
                    }
                    break;
                }
                case "author": {
                    while (j >= 0 && (bookList.get(j).getAuthor().compareToIgnoreCase(key.getAuthor()) > 0) ^ reverse) {
                        bookList.set(j + 1, bookList.get(j));
                        j--;
                    }
                    break;
                }
                case "year": {
                    while (j >= 0 && (bookList.get(j).getYearOfPublishing() > key.getYearOfPublishing()) ^ reverse) {
                        bookList.set(j + 1, bookList.get(j));
                        j--;
                    }
                    break;
                }
                case "rating": {
                    while (j >= 0 && (bookList.get(j).getRating() > key.getRating() ^ reverse)) {
                        bookList.set(j + 1, bookList.get(j));
                        j--;
                    }
                    break;
                }
            }
            bookList.set(j + 1, key);
        }
    }

}
