package mylab.book.entity;

public class Novel extends Publication {
    private String author; // 저자
    private String genre;  // 장르

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
        // 부모 toString()은 제목만 반환
        return super.toString() + " [소설] 저자:" + author
                + ", 장르:" + genre
                + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}