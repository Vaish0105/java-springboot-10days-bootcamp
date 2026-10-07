package org.example.day9.repository;

import org.example.day9.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {

        books.add(new Book(1, "Advanced Java", "James Gosling", 599.0));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 699.0));
        books.add(new Book(3, "Python Basics", "Guido van Rossum", 499.0));
        books.add(new Book(4, "Spring Boot", "Craig Walls", 799.0));
        books.add(new Book(5, "Java Fundamentals", "Herbert Schildt", 550.0));
        books.add(new Book(6, "Effective Java", "Joshua Bloch", 850.0));
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
}