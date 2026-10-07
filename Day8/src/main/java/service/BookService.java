package service;

import dto.BookRequest;
import dto.BookResponse;
import exception.ValidationException;
import model.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<BookResponse> getAllBooks() {

        List<Book> books = bookRepository.getAllBooks();

        List<BookResponse> responses = new ArrayList<>();

        for (Book book : books) {

            BookResponse response = new BookResponse(
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.isAvailable()
            );

            responses.add(response);
        }

        return responses;
    }

    // Add a book
    public void addBook(BookRequest request)
            throws ValidationException {

        validateBook(request);

        Book book = new Book(
                request.getId(),
                request.getTitle(),
                request.getAuthor(),
                request.getPrice()
        );

        bookRepository.addBook(book);
    }

    // Search a book
    public BookResponse searchBookByTitle(String title) {

        Book book = bookRepository.searchBookByTitle(title);

        if (book == null) {
            return null;
        }

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.isAvailable()
        );
    }

    // Update a book
    public void updateBook(BookRequest request)
            throws ValidationException {

        validateBook(request);

        Book book = new Book(
                request.getId(),
                request.getTitle(),
                request.getAuthor(),
                request.getPrice()
        );

        bookRepository.updateBook(book);
    }

    // Delete a book
    public void deleteBook(int bookId) {
        bookRepository.deleteBook(bookId);
    }

    // Validate book fields
    private void validateBook(BookRequest request)
            throws ValidationException {

        if (request == null) {
            throw new ValidationException(
                    "Book request cannot be null"
            );
        }

        if (request.getTitle() == null ||
                request.getTitle().trim().isEmpty()) {

            throw new ValidationException(
                    "Title cannot be blank"
            );
        }

        if (request.getAuthor() == null ||
                request.getAuthor().trim().isEmpty()) {

            throw new ValidationException(
                    "Author cannot be blank"
            );
        }

        if (request.getPrice() <= 0) {

            throw new ValidationException(
                    "Price must be greater than 0"
            );
        }
    }
}