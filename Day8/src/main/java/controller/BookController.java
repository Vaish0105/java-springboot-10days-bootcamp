package controller;

import dto.BookRequest;
import dto.BookResponse;
import exception.ValidationException;
import service.BookService;

import java.util.List;

public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Add a book
    public void addBook(BookRequest request)
            throws ValidationException {

        bookService.addBook(request);
    }

    // Search a book
    public BookResponse searchBookByTitle(String title) {
        return bookService.searchBookByTitle(title);
    }

    // Update a book
    public void updateBook(BookRequest request)
            throws ValidationException {

        bookService.updateBook(request);
    }

    // Delete a book
    public void deleteBook(int bookId) {
        bookService.deleteBook(bookId);
    }
}