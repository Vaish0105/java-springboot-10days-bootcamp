package org.example.day6springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    // In-memory list of books
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Java Basics", "James Gosling", 499.99));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 699.00));
        books.add(new Book(3, "Atomic Habits", "James Clear", 599.00));
    }

    // Get all books
    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by ID
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // Add a new book
    @PostMapping("/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        books.add(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // Update an existing book
    @PutMapping("/api/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int id,
            @RequestBody Book updatedBook) {

        for (Book book : books) {

            if (book.getId() == id) {

                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());

                return ResponseEntity.ok(book);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // Delete a book
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                books.remove(book);

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}