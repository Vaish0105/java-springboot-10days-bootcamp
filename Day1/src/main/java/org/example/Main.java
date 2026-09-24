package org.example;

public class Main {

    public static void main(String[] args) {

        // ==================================================
        // 1. BASICS OF JAVA
        // ==================================================

        // Example: Printing text in Java
        System.out.println("Hello World");

        // Example: Printing numbers
        System.out.println(10);
        System.out.println(25 + 5);

        // Example: Declaring and using variables
        int age = 20;
        String name = "Vaishnavi";

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);


        // ==================================================
        // 2. DATA TYPES IN JAVA
        // ==================================================

        // Example: byte data type
        byte b = 10;

        // Example: short data type
        short s = 1000;

        // Example: int data type
        int number = 100000;

        // Example: long data type
        long population = 10000000000L;

        // Example: float data type
        float price = 10.5f;

        // Example: double data type
        double salary = 25000.75;

        // Example: char data type
        char grade = 'A';

        // Example: boolean data type
        boolean passed = true;

        // Example: String data type
        String language = "Java";

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + number);
        System.out.println("long: " + population);
        System.out.println("float: " + price);
        System.out.println("double: " + salary);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + passed);
        System.out.println("String: " + language);


        // ==================================================
        // 3. METHODS IN JAVA
        // ==================================================

        // Example: Calling a method
        greet();

        // Example: Method with parameters
        addNumbers(10, 20);

        // Example: Method with return value
        int result = multiply(5, 4);

        System.out.println("Multiplication: " + result);


        // ==================================================
        // 4. ARRAYS IN JAVA
        // ==================================================

        // Example: Creating an integer array
        int[] numbers = {10, 20, 30, 40, 50};

        // Example: Accessing an array element
        System.out.println("First element: " + numbers[0]);
        System.out.println("Third element: " + numbers[2]);

        // Example: Finding the length of an array
        System.out.println("Array length: " + numbers.length);

        // Example: Printing all array elements using a for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }


        // ==================================================
        // 5. STRINGS IN JAVA
        // ==================================================

        // Example: Creating a String
        String text = "Hello Java";

        // Example: Finding String length
        System.out.println("String length: " + text.length());

        // Example: Accessing a character using charAt()
        System.out.println("First character: " + text.charAt(0));

        // Example: Converting String to uppercase
        System.out.println("Uppercase: " + text.toUpperCase());

        // Example: Converting String to lowercase
        System.out.println("Lowercase: " + text.toLowerCase());

        // Example: Checking whether String contains a word
        System.out.println("Contains Java: " + text.contains("Java"));

        // Example: Comparing two Strings
        String a = "Hello";
        String c = "Hello";

        System.out.println("Strings are equal: " + a.equals(c));


        // ==================================================
        // 6. FIZZBUZZ + EVEN OR ODD
        // ==================================================

        // Print numbers from 1 to 50
        for (int i = 1; i <= 50; i++) {

            // FizzBuzz rules
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.print("Buzz");
            }
            else {
                System.out.print(i);
            }

            // Check whether the number is even or odd
            if (i % 2 == 0) {
                System.out.println(" - Even");
            }
            else {
                System.out.println(" - Odd");
            }
        }
    }


    // ==================================================
    // METHODS
    // ==================================================

    // Example: Method without parameters and without return value
    static void greet() {
        System.out.println("Hello from the method!");
    }


    // Example: Method with parameters
    static void addNumbers(int a, int b) {
        System.out.println("Addition: " + (a + b));
    }


    // Example: Method with parameters and return value
    static int multiply(int a, int b) {
        return a * b;
    }
}