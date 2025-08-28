package mylab.book.entity;

public class Publication {
    private String title;         // 제목
    private String publishDate;   // 출간일 (yyyy-MM-dd)
    private int page;             // 페이지 수
    private int price;            // 가격(원)

    // 기본 생성자
    public Publication() {}

    // 모든 필드를 받는 생성자
    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // getter/setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    // 요구사항: toString()은 제목만
    @Override
    public String toString() {
        return title;
    }
}