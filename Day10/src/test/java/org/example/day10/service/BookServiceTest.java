package org.example.day10.service;

import org.example.day10.exception.ResourceNotFoundException;
import org.example.day10.model.Book;
import org.example.day10.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void createBook_shouldCreateBook() {

        Book book = new Book(
                7,
                "Java Testing",
                "Test Author",
                500
        );

        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.createBook(book);

        assertNotNull(result);
        assertEquals("Java Testing", result.getTitle());

        verify(bookRepository).save(book);
    }

    @Test
    void getBookById_shouldFindBook() {

        Book book = new Book(
                1,
                "Advanced Java",
                "James Gosling",
                599
        );

        when(bookRepository.findById(1)).thenReturn(book);

        Book result = bookService.getBookById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Advanced Java", result.getTitle());

        verify(bookRepository).findById(1);
    }

    @Test
    void getBookById_shouldThrowExceptionWhenNotFound() {

        when(bookRepository.findById(99)).thenReturn(null);

        ResourceNotFoundException exception =
                assertThrows(
                        ResourceNotFoundException.class,
                        () -> bookService.getBookById(99)
                );

        assertEquals(
                "Book not found with id: 99",
                exception.getMessage()
        );

        verify(bookRepository).findById(99);
    }
}