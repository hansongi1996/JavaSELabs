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

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    // 검색
    public Book findByTitle(String title) {
        for (Book b : books) if (b.getTitle().equals(title)) return b;
        return null;
    }
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) if (b.getAuthor().equals(author)) result.add(b);
        return result;
    }
    public Book findByISBN(String isbn) {
        for (Book b : books) if (b.getIsbn().equals(isbn)) return b;
        return null;
    }

    // 대출/반납
    public boolean checkOutBook(String isbn) {
        Book b = findByISBN(isbn);
        return b != null && b.checkOut();
    }
    public boolean returnBook(String isbn) {
        Book b = findByISBN(isbn);
        if (b == null) return false;
        b.returnBook(); return true;
    }

    // 목록/통계
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book b : books) if (b.isAvailable()) result.add(b);
        return result;
    }
    public List<Book> getAllBooks() { return Collections.unmodifiableList(books); }
    public int getTotalBooks() { return books.size(); }
    public int getAvailableBooksCount() { return getAvailableBooks().size(); }
    public int getBorrowedBooksCount() { return getTotalBooks() - getAvailableBooksCount(); }
}