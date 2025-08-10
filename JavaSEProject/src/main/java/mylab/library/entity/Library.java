package mylab.library.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private String name;
    private final List<Book> books = new ArrayList<>();

    public Library(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addBook(Book book) {
        if (book == null) return;
        if (findBookByISBN(book.getIsbn()) != null) return; 
        books.add(book);
    }

    public Book findBookByTitle(String title) {
        if (title == null) return null;
        for (Book b : books) if (title.equals(b.getTitle())) return b;
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        if (author == null) return result;
        for (Book b : books) if (author.equals(b.getAuthor())) result.add(b);
        return result;
    }

    public Book findBookByISBN(String isbn) {
        if (isbn == null) return null;
        for (Book b : books) if (isbn.equals(b.getIsbn())) return b;
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b == null) return false;
        return b.checkOut();
    }

    public boolean returnBook(String isbn) {
        Book b = findBookByISBN(isbn);
        if (b == null) return false;
        if (b.isAvailable()) return false;
        b.returnBook();
        return true;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book b : books) if (b.isAvailable()) result.add(b);
        return Collections.unmodifiableList(result);
    }

    public List<Book> getAllBooks() { return Collections.unmodifiableList(books); }
    public int getTotalBooks() { return books.size(); }
    public int getAvailableBooksCount() { return getAvailableBooks().size(); }
    public int getBorrowedBooksCount() { return getTotalBooks() - getAvailableBooksCount(); }
}
