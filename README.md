# Java Spring Boot Backend – Day 6 Progress 🚀

## 📁 Project Structure
dto/ ├─ UserRequestDTO └─ UserResponseDTO
exception/ ├─ GlobalExceptionHandler └─ UserNotFoundException
model/ └─ User
Copy code

---

## 🔹 Create Users (Bulk API)

### 📌 Endpoint
POST /users
Copy code

### 📥 Request Body
```json
[
  { "name": "Divya", "email": "divya@gmail.com" },
  { "name": "Pavan", "email": "pavan@gmail.com" }
]
✅ Success Response (201 Created)
Copy code
Json
[
  { "id": 1, "name": "Divya", "email": "divya@gmail.com" },
  { "id": 2, "name": "Pavan", "email": "pavan@gmail.com" }
]
❌ Validation Error Example
Request
Copy code
Json
[
  { "name": "", "email": "test@gmail.com" }
]
Response (400 Bad Request)
Copy code
Json
{
  "status": 400,
  "error": "Bad Request",
  "path": "/users"
}
🧠 Concepts Learned
DTO Pattern (Request & Response)
@Valid & Jakarta Validation
Global Exception Handling using @RestControllerAdvice
Service Layer Abstraction
HTTP Status Codes with ResponseEntity
RESTful API Design
🛠 Tech Stack
Java 17
Spring Boot
Maven
Postman
✅ Status
Day 6 completed as part of the 30-Day Java Spring Boot Backend Plan
🔜 Next Steps
Improve validation error messages
Implement PUT & DELETE APIs
Integrate database using Spring Data JPA