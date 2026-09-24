package org.example;

public class main {

    public static void main(String[] args) {

        // ==================================================
        // 1. PRIME NUMBER AND FACTORIAL
        // ==================================================

        System.out.println("Prime Number Tests:");

        System.out.println("5 is prime: " + isPrime(5));
        System.out.println("10 is prime: " + isPrime(10));
        System.out.println("7 is prime: " + isPrime(7));
        System.out.println("12 is prime: " + isPrime(12));
        System.out.println("13 is prime: " + isPrime(13));


        System.out.println("\nFactorial Tests:");

        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 3: " + factorial(3));
        System.out.println("Factorial of 6: " + factorial(6));
        System.out.println("Factorial of 4: " + factorial(4));
        System.out.println("Factorial of 7: " + factorial(7));


        // ==================================================
        // 2. ARRAY - MAX, MIN AND AVERAGE
        // ==================================================

        int[] numbers = {10, 25, 5, 40, 15, 30, 8, 50, 20, 12};

        int max = numbers[0];
        int min = numbers[0];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > max) {
                max = numbers[i];
            }

            if (numbers[i] < min) {
                min = numbers[i];
            }

            sum = sum + numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.println("\nArray Results:");
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Average: " + average);


        // ==================================================
        // 3. REVERSE STRING AND PALINDROME
        // ==================================================

        String word = "madam";

        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse = reverse + word.charAt(i);
        }

        System.out.println("\nString Results:");
        System.out.println("Original String: " + word);
        System.out.println("Reversed String: " + reverse);

        if (word.equals(reverse)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }


    // ==================================================
    // METHODS
    // ==================================================

    // Check whether a number is prime
    static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }


    // Find factorial of a number
    static int factorial(int number) {

        int result = 1;

        for (int i = 1; i <= number; i++) {
            result = result * i;
        }

        return result;
    }
}
