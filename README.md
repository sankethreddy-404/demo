# User Management REST API

A Spring Boot REST API for managing users with a clean layered architecture.  
This project demonstrates real-world backend practices such as DTO-based design,
validation, global exception handling, pagination, search, bulk operations, and
standardized API responses.

---

## 🚀 Features

- Create user (single)
- Create users in bulk
- Get user by ID
- Get all users with pagination
- Search users by name or email
- Update user details
- Delete user
- Input validation using annotations
- Global exception handling
- Consistent API response structure

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

---

## 🧱 Project Architecture

The application follows a clean layered architecture:

- **Controller** – Handles HTTP requests and responses
- **Service** – Contains business logic
- **Repository** – Handles database interactions
- **DTOs** – Used for request and response payloads
- **Entity** – Represents database tables
- **Global Exception Handler** – Handles errors centrally

Flow:
Client → Controller → Service → Repository → Database ← Controller ← Service ← Repository


---

## 📦 API Endpoints

| Method | Endpoint    | Description                       |
|--------|-------------|-----------------------------------|
| POST   | /users      | Create a single user              |
| POST   | /users/bulk | Create users in bulk              |
| GET    | /users      | Get all users (pagination/search) |
| GET    | /users/{id} | Get user by ID                    |
| PUT    | /users/{id} | Update user                       |
| DELETE | /users/{id} | Delete user                       |

---

## 📄 Standard API Response Structure

All APIs return a consistent response format:

```json
{
  "timestamp": "2026-01-08T10:30:00",
  "status": 200,
  "message": "Success message",
  "data": {}
}

✅ Validation & Error Handling

Request data is validated using annotations like @NotBlank, @Email, and @Valid
Validation and runtime errors are handled globally using @RestControllerAdvice
Proper HTTP status codes are returned (400, 404, 200, 201)

📚 What I Learned

Designing clean REST APIs with Spring Boot
Controller–Service–Repository separation
DTO-based API design
Pagination, sorting, and search with Spring Data JPA
Bulk API design
Global exception handling
Standardizing API responses
Testing APIs using Postman

▶️ How to Run the Project

Clone the repository
Configure MySQL database in application.properties
Run the application
Test APIs using Postman

👤 Author
Built as part of a 30-day Java Backend (Spring Boot) learning journey.


---