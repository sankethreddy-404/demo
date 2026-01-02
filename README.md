# Spring Boot User Management API

A RESTful backend application built using **Spring Boot**, **Spring Data JPA**, and **MySQL** that demonstrates clean layered architecture, database integration, and proper exception handling.

---

## 🚀 Features

- CRUD operations for User entity
- MySQL database integration
- Spring Data JPA (Hibernate under the hood)
- Clean architecture (Controller → Service → Repository)
- Global exception handling
- REST API tested using Postman

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

---

## 📂 Project Structure
src/main/java/com/backend/demo │ ├── controller      # REST Controllers ├── service         # Business Logic ├── repository      # JPA Repositories ├── model           # JPA Entities ├── exception       # Custom & Global Exceptions └── DemoApplication # Main class


---

## 🧩 Entity

### User Entity
Represents the `users` table in the database.

Fields:
- `id` (Primary Key, Auto-generated)
- `name`
- `email`

---

## 🔄 API Endpoints

### Create Users
POST /users


### Get All Users
GET /users


### Get User by ID
GET /users/{id}

### Update User
PUT /users/{id}


### Delete User
DELETE /users/{id}


---

## ⚠️ Exception Handling

- Returns `404 NOT FOUND` when a user does not exist
- Centralized error handling using `@RestControllerAdvice`
- Clean error messages instead of generic 500 errors

---

## 🗄 Database Configuration

Configured using `application.properties`:

- MySQL database
- Hibernate auto DDL
- SQL logging enabled

---

## ✅ Testing

All APIs tested using **Postman**:
- Successful CRUD operations
- Proper error responses for invalid requests

---

## 📌 What I Learned

- How Spring Boot integrates with databases
- Using JPA repositories instead of manual logic
- Importance of layered architecture
- Proper exception handling in REST APIs

---

## 👨‍💻 Author

Built as part of a **30-Day Java Backend Learning Plan**