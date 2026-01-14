# 🚀 Java Spring Boot Backend Project

This project is part of my **30-Day Java Spring Boot Backend Learning Journey**, where I am building a **real-world REST API** step by step using industry best practices.

The focus is on **clean architecture**, **scalable API design**, and **hands-on debugging**, not just tutorials.

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Postman
- Maven

---

## 🧩 Project Architecture

The application follows a clean **layered architecture**:
Controller → DTO → Validation → Service → Mapper → Repository → Database


### Layers Explained

- **Controller**  
  Handles HTTP requests and responses

- **DTOs (Request & Response)**  
  Acts as API contract and hides internal entity structure

- **Validation**  
  Input validation using annotations like `@Valid`

- **Service**  
  Contains business logic and decision making

- **Mapper**  
  Converts Entity ↔ DTO (separation of concerns)

- **Repository**  
  Handles database interaction using Spring Data JPA

- **Global Exception Handler**  
  Centralized error handling using `@ControllerAdvice`

---

## ✨ Features Implemented (Up to Day 19)

### ✅ User Management
- Create, read, update, delete users
- Input validation using `@Valid`
- Proper HTTP status codes using `ResponseEntity`

### ✅ Order Management
- Create orders for a user
- Fetch orders by user
- User–Order relationship using `@ManyToOne`

### ✅ Pagination & Sorting
- Pagination using `Page` and `Pageable`
- Sorting using `Sort`
- Supports:
    - `page`
    - `size`
    - `sortBy`
    - `sortDir`
- Pagination metadata included:
    - `totalElements`
    - `totalPages`
    - `pageNumber`
    - `pageSize`
    - `lastPage`

### ✅ API Response Standardization
- Custom API response wrapper
- Consistent success and error responses
- Fields:
    - status
    - message
    - data

### ✅ Exception Handling
- Centralized exception handling using `@ControllerAdvice`
- Custom exceptions for:
    - User not found
    - Validation errors

### ✅ DTO & Mapper Layer
- Entities are **never exposed** directly to clients
- Separate Request & Response DTOs
- Dedicated Mapper classes for conversions

### ✅ Real-World Debugging Experience
- Fixed pagination & sorting runtime issues
- Learned Spring Data JPA method naming rules
- Debugged and resolved `500 Internal Server Error`
- Understood Lazy vs Eager fetching behavior

---

## 🔍 Sample API Endpoints

### Create Order
POST /orders/users/{userId}


### Get Orders with Pagination & Sorting
GET /orders/users/{userId}?page=0&size=5&sortBy=id&sortDir=asc


---

## 🎯 Learning Outcomes

Through this project, I learned:

- Why entities should not be exposed directly to clients
- How to design clean service and controller layers
- How pagination should be handled at the database level
- How to debug real Spring Boot runtime issues
- How to write maintainable and scalable backend code

---

## 📌 Progress Status

- ✅ Completed up to **Day 19** of my 30-day backend plan
- 🔜 Upcoming topics:
    - Search & filter APIs
    - Swagger API documentation
    - Spring Security & JWT
    - Docker & deployment

---

## 🤝 Connect

I’m sharing my backend learning journey publicly to stay consistent and accountable.

Feel free to check the code, suggest improvements, or connect!