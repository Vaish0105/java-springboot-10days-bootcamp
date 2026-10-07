import controller.BookController;
import dto.BookRequest;
import dto.BookResponse;
import exception.ValidationException;
import repository.BookRepository;
import service.BookService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookRepository bookRepository =
                new BookRepository();

        BookService bookService =
                new BookService(bookRepository);

        BookController bookController =
                new BookController(bookService);

        System.out.println("===== VALIDATION TEST =====");

        try {

            // Intentionally using a blank title
            BookRequest request = new BookRequest(
                    5,
                    "",
                    "Test Author",
                    300
            );

            bookController.addBook(request);

        } catch (ValidationException e) {

            System.out.println(
                    "Validation Error: " + e.getMessage()
            );
        }

        System.out.println();
        System.out.println("===== ALL BOOKS =====");

        List<BookResponse> books =
                bookController.getAllBooks();

        for (BookResponse book : books) {

            System.out.println(
                    "ID: " + book.getId()
                            + ", Title: " + book.getTitle()
                            + ", Author: " + book.getAuthor()
                            + ", Price: " + book.getPrice()
                            + ", Available: " + book.isAvailable()
            );
        }
    }
}