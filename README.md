# Blog Management System – Backend

A secure and scalable Blog Management System backend built using Spring Boot and MySQL, featuring JWT-based authentication and complete CRUD operations for blogs. This application allows users to manage their own blog posts and read all blogs. API documentation is provided using Swagger (OpenAPI).

## 🚀 Features

- User registration and login with JWT authentication
- JWT token generation on both signup and login
- Secure APIs using Spring Security
- Users can:
  - Create their own blog posts
  - Read their own blog posts
  - Update their own blog posts
  - Delete their own blog posts
- View all blogs
- Swagger (OpenAPI) documentation for easy API testing
- MySQL database integration with JPA/Hibernate
- Proper exception handling and validation

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- MySQL
- Swagger / OpenAPI
- Maven

 ## 🔐 Authentication & Security
 
- JWT is generated:
  - After successful user signup
  - After successful user login
- JWT contains the user identifier
- Token is validated on every secured request using a custom JWT filter
- Authorization logic ensures:
  - Users can only modify or delete their own blogs

## 📂 API Modules

**Auth APIs**
  - User Signup
  - User Login

**Blog APIs**
  - Create Blog (Authenticated user only)
  - Get Own Blogs (Authenticated user only)
  - Update Own Blog (Authenticated user only)
  - Delete Own Blog (Authenticated user only)
  - Get All Blogs (Authenticated user only)

## 📄 Swagger Documentation

Swagger UI is integrated to visualize and test APIs easily.
Access it locally after running the application.
