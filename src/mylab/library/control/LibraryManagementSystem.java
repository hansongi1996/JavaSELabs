package mylab.library.control;

import java.util.List;
import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("�߾� ������");
        addSampleBooks(library);

        System.out.println("===== " + library.getName() + " =====");
        printStats(library);

        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");
        System.out.println("�������� �˻� ���:");
        System.out.println(library.findByTitle("�ڹ��� ����") + "\n");

        System.out.println("���ڷ� �˻� ���:");
        List<Book> byAuthor = library.findByAuthor("Robert C. Martin");
        if (!byAuthor.isEmpty()) System.out.println(byAuthor.get(0) + "\n");

        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        if (library.checkOutBook("978-89-01-14077-4")) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findByISBN("978-89-01-14077-4"));
        }

        System.out.println("\n������ ���� ����:"); printStats(library);

        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        if (library.returnBook("978-89-01-14077-4")) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findByISBN("978-89-01-14077-4"));
        }

        System.out.println("\n������ ���� ����:"); printStats(library);

        System.out.println("===== ���� ������ ���� ��� =====");
        for (Book b : library.getAvailableBooks()) {
            System.out.println(b);
            System.out.println("------------------------");
        }
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void printStats(Library l) {
        System.out.println("��ü ���� ��: " + l.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + l.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + l.getBorrowedBooksCount());
    }
}
