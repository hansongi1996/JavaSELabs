package mylab.book.entity;

public class Novel extends Publication {
    private String author; // ����
    private String genre;  // �帣

    public Novel(String title, String publishDate, int page, int price,
                 String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() { return author; }
    public String getGenre()  { return genre;  }

    @Override
    public String toString() {
        // �θ� toString()�� ���� ��ȯ
        return super.toString() + " [�Ҽ�] ����:" + author
                + ", �帣:" + genre
                + ", " + getPage() + "��, " + getPrice() + "��, ������:" + getPublishDate();
    }
}