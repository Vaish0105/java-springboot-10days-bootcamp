package org.example;

public class day3 {

    public static void main(String[] args) {

        // ==================================================
        // 1. BOOK CLASS
        // ==================================================

        // Creating a Book object using the constructor
        Book book = new Book(1, "Java Basics", "James Gosling", 499.99);

        // Using getters
        System.out.println("Book ID: " + book.getId());
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
        System.out.println("Book Price: " + book.getPrice());

        // Using setter to change the price
        book.setPrice(450.00);

        // toString() prints the object in readable form
        System.out.println("\nBook Details:");
        System.out.println(book);


        // ==================================================
        // 2. INHERITANCE AND POLYMORPHISM
        // ==================================================

        // Person reference pointing to Student object
        Person person1 = new Student();

        // Person reference pointing to Teacher object
        Person person2 = new Teacher();

        System.out.println("\nPerson Details:");

        // Calling overridden methods
        person1.showRole();
        person2.showRole();
    }
}


// ==================================================
// BOOK CLASS
// ==================================================

class Book {

    private int id;
    private String title;
    private String author;
    private double price;


    // Constructor
    Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }


    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }


    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }


    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }


    // toString() method
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}


// ==================================================
// ABSTRACT PERSON CLASS
// ==================================================

abstract class Person {

    // Method that subclasses will override
    abstract void showRole();
}


// ==================================================
// STUDENT CLASS
// ==================================================

class Student extends Person {

    @Override
    void showRole() {
        System.out.println("Student: I am a student.");
    }
}


// ==================================================
// TEACHER CLASS
// ==================================================

class Teacher extends Person {

    @Override
    void showRole() {
        System.out.println("Teacher: I am a teacher.");
    }
}