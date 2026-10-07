package dto;

public class BookResponse {

    private int id;
    private String title;
    private String author;
    private double price;
    private boolean available;

    public BookResponse(int id, String title, String author,
                        double price, boolean available) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}