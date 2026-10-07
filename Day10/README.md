# Day 10 - Spring Boot Final Project

## Overview

This project is the final project of the 10-day Java and Spring Boot training.

The project demonstrates a simple Book Management REST API using Spring Boot. It includes layered architecture, exception handling, unit testing, controller testing, Swagger/OpenAPI documentation, and Maven packaging.

## Technologies Used

* Java 17
* Spring Boot 3.5.6
* Maven
* Spring Web
* JUnit 5
* Mockito
* Swagger / OpenAPI
* MySQL Connector

## Project Structure

```text
Day10
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── org.example.day10
    │   │       ├── Day10Application.java
    │   │       ├── controller
    │   │       │   └── BookController.java
    │   │       ├── service
    │   │       │   └── BookService.java
    │   │       ├── repository
    │   │       │   └── BookRepository.java
    │   │       ├── model
    │   │       │   └── Book.java
    │   │       └── exception
    │   │           ├── ResourceNotFoundException.java
    │   │           └── GlobalExceptionHandler.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── org.example.day10
                ├── service
                │   └── BookServiceTest.java
                └── controller
                    └── BookControllerTest.java
```

## Features

* REST API for books
* Layered architecture
* Constructor-based dependency injection
* Service and repository layers
* Global exception handling
* Mockito unit tests
* Spring MVC controller testing
* Swagger/OpenAPI documentation
* Maven build and packaging
* Executable Spring Boot JAR

## How to Run

### 1. Open the Project

Open the `Day10` folder in IntelliJ IDEA or open it from PowerShell.

### 2. Run Tests

```bash
mvn clean test
```

Expected result:

```text
Tests run: 4
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

### 3. Build the Project

```bash
mvn clean package
```

The executable JAR will be created at:

```text
target/day10-1.0.0.jar
```

### 4. Run the JAR

```bash
java -jar target/day10-1.0.0.jar
```

The application runs on:

```text
http://localhost:8082
```

## API Endpoints

| Method | Endpoint          | Description       |
| ------ | ----------------- | ----------------- |
| GET    | `/api/books`      | Get all books     |
| GET    | `/api/books/{id}` | Get a book by ID  |
| POST   | `/api/books`      | Create a new book |

## Sample Requests

### Get All Books

```http
GET http://localhost:8082/api/books
```

### Get Book by ID

```http
GET http://localhost:8082/api/books/1
```

### Create a Book

```http
POST http://localhost:8082/api/books
Content-Type: application/json
```

Request body:

```json
{
  "id": 7,
  "title": "Java Testing",
  "author": "Test Author",
  "price": 500
}
```

## Swagger / OpenAPI

Swagger UI:

```text
http://localhost:8082/swagger-ui.html
```

OpenAPI definition:

```text
http://localhost:8082/v3/api-docs
```

Swagger provides an interactive interface to view and test all available API endpoints.

## Exception Handling

The project uses `@RestControllerAdvice` for global exception handling.

When a requested book is not found, the API returns a `404 Not Found` response with an error message.

Example:

```json
{
  "error": "Resource Not Found",
  "message": "Book not found with id: 99",
  "status": "404"
}
```

## Testing

The project contains four tests:

### BookService Tests

1. Create book
2. Find book
3. Book not found

### BookController Test

4. Get book by ID

All tests passed successfully during the final Maven test run.

## Final Build Status

```text
BUILD SUCCESS
Tests run: 4
Failures: 0
Errors: 0
Skipped: 0
```

## Final Verification

The application was successfully:

* Tested using Maven
* Packaged into an executable JAR
* Run outside IntelliJ IDEA
* Tested through Swagger UI
* Verified using all available API endpoints
