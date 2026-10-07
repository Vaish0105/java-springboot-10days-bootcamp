package repository;

import config.DatabaseConnection;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    // Get all books from MySQL
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                boolean available = resultSet.getBoolean("available");

                Book book = new Book(
                        id,
                        title,
                        author,
                        price
                );

                book.setAvailable(available);

                books.add(book);
            }

        } catch (Exception e) {

            System.out.println("Error while fetching books!");
            System.out.println("Error: " + e.getMessage());
        }

        return books;
    }

    // Add a new book
    public void addBook(Book book) {

        String sql =
                "INSERT INTO books (id, title, author, price, available) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());
            statement.setBoolean(5, book.isAvailable());

            statement.executeUpdate();

            System.out.println("Book added to MySQL successfully!");

        } catch (Exception e) {

            System.out.println("Error while adding book!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete a book
    public void deleteBook(int bookId) {

        String sql = "DELETE FROM books WHERE id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, bookId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Book deleted from MySQL successfully!");
            } else {
                System.out.println(
                        "Book with ID " + bookId + " was not found!"
                );
            }

        } catch (Exception e) {

            System.out.println("Error while deleting book!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update a book
    public void updateBook(Book book) {

        String sql =
                "UPDATE books SET title = ?, author = ?, price = ? " +
                        "WHERE id = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getId());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println(
                        "Book updated in MySQL successfully!"
                );
            } else {
                System.out.println(
                        "Book with ID " + book.getId() + " was not found!"
                );
            }

        } catch (Exception e) {

            System.out.println("Error while updating book!");
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search book by title
    public Book searchBookByTitle(String title) {

        String sql =
                "SELECT * FROM books WHERE title = ?";

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, title);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String bookTitle =
                            resultSet.getString("title");
                    String author =
                            resultSet.getString("author");
                    double price =
                            resultSet.getDouble("price");
                    boolean available =
                            resultSet.getBoolean("available");

                    Book book = new Book(
                            id,
                            bookTitle,
                            author,
                            price
                    );

                    book.setAvailable(available);

                    return book;
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error while searching for book!"
            );
            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        return null;
    }
}