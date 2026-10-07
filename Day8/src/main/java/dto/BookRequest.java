package dto;

import exception.ValidationException;

public class BookRequest {

    private int id;
    private String title;
    private String author;
    private double price;

    public BookRequest(int id, String title, String author, double price)
            throws ValidationException {

        if (title == null || title.trim().isEmpty()) {
            throw new ValidationException("Title cannot be blank");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new ValidationException("Author cannot be blank");
        }

        if (price <= 0) {
            throw new ValidationException(
                    "Price must be greater than 0"
            );
        }

        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
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
}