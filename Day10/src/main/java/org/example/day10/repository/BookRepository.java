package org.example.day10.repository;

import org.example.day10.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1, "Advanced Java", "James Gosling", 599));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 699));
        books.add(new Book(3, "Python Basics", "Guido van Rossum", 499));
        books.add(new Book(4, "Spring Boot", "Craig Walls", 799));
        books.add(new Book(5, "Java Fundamentals", "Herbert Schildt", 550));
        books.add(new Book(6, "Effective Java", "Joshua Bloch", 850));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Book findById(int id) {

        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}