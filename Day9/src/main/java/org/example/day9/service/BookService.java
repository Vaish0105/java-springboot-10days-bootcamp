package org.example.day9.service;

import org.example.day9.exception.ResourceNotFoundException;
import org.example.day9.model.Book;
import org.example.day9.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger =
            LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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

    public List<Book> getBooks(int page, int size, String sort) {

        logger.info(
                "Getting books - page: {}, size: {}, sort: {}",
                page, size, sort
        );

        List<Book> books = bookRepository.findAll();

        // Sorting
        if ("title".equalsIgnoreCase(sort)) {

            books.sort(
                    Comparator.comparing(Book::getTitle)
            );

        } else if ("price".equalsIgnoreCase(sort)) {

            books.sort(
                    Comparator.comparing(Book::getPrice)
            );

        } else {

            books.sort(
                    Comparator.comparing(Book::getId)
            );
        }

        // Prevent invalid pagination values
        if (page < 0) {
            page = 0;
        }

        if (size <= 0) {
            size = 5;
        }

        // Pagination
        int start = page * size;

        if (start >= books.size()) {
            logger.info("No books available for requested page");
            return List.of();
        }

        int end = Math.min(start + size, books.size());

        List<Book> result = books.subList(start, end);

        logger.info("Returning {} books", result.size());

        return result;
    }
}