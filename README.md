# Java Spring Boot Backend – User Management API 🚀

This project is part of my **30-Day Java Spring Boot Backend Learning Plan**.  
It demonstrates how to build clean, validated, and production-style REST APIs using Spring Boot.

---

## 📌 Features Implemented (Up to Day 7)

- Bulk User Creation API
- DTO-based Request & Response handling
- Input validation using Jakarta Validation
- Validation for List of DTOs
- Global Exception Handling
- Proper HTTP Status Codes
- Clean Controller–Service Architecture
- Dependency Injection
- Tested using Postman

---

## 🏗 Project Architecture
controller/ └── UserController.java
service/ ├── UserService.java └── UserServiceImpl.java
dto/ ├── UserRequestDTO.java └── UserResponseDTO.java
exception/ └── GlobalExceptionHandler.java
model/ └── User.java
Copy code

---

## 🔹 API: Create Users (Bulk)

### Endpoint
POST /users
Copy code

### Request Body
```json
[
  {
    "name": "Divya",
    "email": "divya@gmail.com"
  },
  {
    "name": "Pavan",
    "email": "pavan@gmail.com"
  }
]
Success Response (201 Created)
Copy code
Json
[
  {
    "id": 1,
    "name": "Divya",
    "email": "divya@gmail.com"
  },
  {
    "id": 2,
    "name": "Pavan",
    "email": "pavan@gmail.com"
  }
]
❌ Validation Error Example
Invalid Request
Copy code
Json
[
  {
    "name": "",
    "email": "wrong-email"
  }
]
Response (400 Bad Request)
Copy code
Json
{
  "errors": [
    "Name cannot be empty",
    "Invalid email format"
  ]
}
🧠 Concepts Covered
REST API Design
DTO Pattern
Validation with @Valid and @Validated
Global Exception Handling
Dependency Injection
HTTP Status Codes with ResponseEntity
Backend debugging & testing
🛠 Tech Stack
Java 17
Spring Boot
Maven
Postman
📅 Status
✅ Completed up to Day 7 of the 30-Day Backend Plan
➡ Next: Database integration using Spring Data JPA (Day 8)