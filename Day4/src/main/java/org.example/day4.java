package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class day4 {

    public static void main(String[] args) {

        // ==================================================
        // TASK 1 - ARRAYLIST AND STREAMS
        // ==================================================

        ArrayList<LibraryBook> books = new ArrayList<>();

        // Add 5 books
        books.add(new LibraryBook(1, "Python Basics"));
        books.add(new LibraryBook(2, "Java Programming"));
        books.add(new LibraryBook(3, "Artificial Intelligence"));
        books.add(new LibraryBook(4, "Data Structures"));
        books.add(new LibraryBook(5, "Machine Learning"));

        System.out.println("Book titles in sorted order:");

        // Sort book titles using Stream
        books.stream()
                .map(LibraryBook::getTitle)
                .sorted()
                .forEach(System.out::println);


        // ==================================================
        // TASK 2 - HASHMAP AND OPTIONAL
        // ==================================================

        HashMap<Integer, LibraryBook> bookMap = new HashMap<>();

        // Store books in HashMap using ID
        for (LibraryBook book : books) {
            bookMap.put(book.getId(), book);
        }

        System.out.println("\nBook Search:");

        // Search for an existing book
        int searchId = 3;

        Optional<LibraryBook> result =
                Optional.ofNullable(bookMap.get(searchId));

        if (result.isPresent()) {
            System.out.println("Book found: " + result.get().getTitle());
        } else {
            System.out.println("Book not found.");
        }

        // Search for a missing book
        int missingId = 10;

        Optional<LibraryBook> missingResult =
                Optional.ofNullable(bookMap.get(missingId));

        if (missingResult.isPresent()) {
            System.out.println("Book found: " + missingResult.get().getTitle());
        } else {
            System.out.println("Book ID " + missingId + " not found.");
        }


        // ==================================================
        // TASK 3 - CUSTOM EXCEPTION
        // ==================================================

        System.out.println("\nCustom Exception:");

        try {
            findBook(bookMap, 20);
        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }


        // ==================================================
        // TASK 4 - CONSOLE MENU APPLICATION
        // ==================================================

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BOOK MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {

                // Add a book
                System.out.print("Enter book ID: ");
                int id = scanner.nextInt();

                scanner.nextLine();

                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                LibraryBook newBook = new LibraryBook(id, title);

                books.add(newBook);
                bookMap.put(id, newBook);

                System.out.println("Book added successfully.");

            } else if (choice == 2) {

                // List all books
                System.out.println("\nBooks:");

                if (books.isEmpty()) {
                    System.out.println("No books available.");
                } else {
                    for (LibraryBook book : books) {
                        System.out.println(
                                book.getId() + " - " + book.getTitle()
                        );
                    }
                }

            } else if (choice == 3) {

                // Delete a book
                System.out.print("Enter book ID to delete: ");
                int id = scanner.nextInt();

                LibraryBook book = bookMap.remove(id);

                if (book != null) {
                    books.remove(book);
                    System.out.println("Book deleted successfully.");
                } else {
                    System.out.println("Book ID not found.");
                }

            } else if (choice == 4) {

                // Exit
                System.out.println("Exiting program...");
                break;

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }


    // ==================================================
    // TASK 3 - FIND BOOK METHOD
    // ==================================================

    static LibraryBook findBook(
            HashMap<Integer, LibraryBook> bookMap,
            int id) throws BookNotFoundException {

        LibraryBook book = bookMap.get(id);

        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " was not found.");
        }

        return book;
    }
}


// ==================================================
// LIBRARY BOOK CLASS
// ==================================================

class LibraryBook {

    private int id;
    private String title;

    // Constructor
    LibraryBook(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }
}


// ==================================================
// CUSTOM EXCEPTION CLASS
// ==================================================

class BookNotFoundException extends Exception {

    BookNotFoundException(String message) {
        super(message);
    }
}