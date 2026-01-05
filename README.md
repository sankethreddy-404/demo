# 🚀 Java Spring Boot Backend – 30 Day Learning Project

This project is part of my **30-day Java Backend Development plan**.  
The goal is to build a **clean, production-ready REST API** using Spring Boot by following industry best practices step by step.

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git & GitHub

---

## 📁 Project Structure (MVC)
- **Controller** → Handles HTTP requests
- **Service** → Business logic
- **Repository** → Database interaction (JPA)
- **Model (Entity)** → Database tables
- **DTOs** → Request & Response objects
- **Exception** → Global exception handling

---

## ✅ Features Implemented (Day 1 – Day 11)

### 1️⃣ REST API Basics
- RESTful architecture
- Stateless communication
- Proper HTTP methods:
    - GET
    - POST
    - PUT
    - DELETE
- Proper HTTP status codes using `ResponseEntity`

---

### 2️⃣ Database Integration
- JPA Entity mapping using:
    - `@Entity`
    - `@Id`
    - `@GeneratedValue`
- Hibernate handles database operations (no manual SQL)
- MySQL integration

---

### 3️⃣ DTO Pattern
- `UserRequestDTO` → Handles incoming client data
- `UserResponseDTO` → Controls outgoing response data
- Prevents exposing entity directly to client
- Improves security and flexibility

---

### 4️⃣ Validation
- Annotations used:
    - `@NotBlank`
    - `@Email`
    - `@Valid`
- Centralized validation handling
- Clean error responses

---

### 5️⃣ Exception Handling
- Custom exceptions (e.g. UserNotFoundException)
- Global exception handling using:
    - `@RestControllerAdvice`

---

### 6️⃣ Pagination & Sorting (Day 10)
- Pagination using:
    - `page`
    - `size`
- Sorting using:
    - `sortBy`
    - `sortDir (asc / desc)`
- Pagination + Sorting together
- Clean API design using `@RequestParam`

---

### 7️⃣ Pagination Response DTO (Day 11)
- Generic `PageResponseDTO<T>`
- Includes:
    - Content list
    - Page number
    - Page size
    - Total elements
    - Total pages
    - Is last page
- Reusable for any entity

---

## 🧪 API Testing
- Tested all APIs using **Postman**
- Verified:
    - CRUD operations
    - Pagination
    - Sorting
    - Validation errors
    - Exception responses

---

## 📌 Current Status
✔ Completed up to **Day 11**  
🔜 Day 12 onwards in progress

---

## 🙌 Author
**Sanketh Reddy**  
Learning Java Backend Development step by step 🚀