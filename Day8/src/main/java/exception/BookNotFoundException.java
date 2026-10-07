package exception;

// Custom exception for when a book is not found
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}