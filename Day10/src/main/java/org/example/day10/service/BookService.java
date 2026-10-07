package org.example.day10.service;

import org.example.day10.exception.ResourceNotFoundException;
import org.example.day10.model.Book;
import org.example.day10.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger =
            LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {

        logger.info("Creating book: {}", book.getTitle());

        return bookRepository.save(book);
    }

    public Book getBookById(int id) {

        logger.info("Searching for book with id: {}", id);

        Book book = bookRepository.findById(id);

        if (book == null) {

            logger.warn("Book not found with id: {}", id);

            throw new ResourceNotFoundException(
                    "Book not found with id: " + id
            );
        }

        logger.info("Book found with id: {}", id);

        return book;
    }

    public List<Book> getAllBooks() {

        logger.info("Getting all books");

        return bookRepository.findAll();
    }
}