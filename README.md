# 📚 Document Management and Basic Q&A Application
<br>
A backend system built using Spring Boot for document management, user authentication, ingestion, and basic Q&A retrieval functionality. The system supports user roles such as **Admin**, **Editor**, and **Viewer**, and is designed with modularity, security, and performance in mind.
<br>
---

## ✅ Features Implemented So Far

### 🔐 Authentication & Authorization
- User Registration and Login<br>
- JWT-based stateless authentication<br>
- Role-based authorization for:
    - `ADMIN`: Full access to all APIs
    - `EDITOR`: Document ingest and query access
    - `VIEWER`: Query-only access

### 📄 User Management APIs
- Register user with role (ADMIN, EDITOR, VIEWER)
- Secure login to generate JWT token
- Update user details (Admin only)
- Get paginated list of users

### 📦 Technology Stack
| Layer            | Technology                         |
|------------------|-------------------------------------|
| Language         | Java 17                             |
| Framework        | Spring Boot                         |
| Auth             | Spring Security, JWT                |
| Database         | MySQL                               |
| ORM              | Spring Data JPA                     |
| API Docs         | Swagger (planned)                   |
| Testing          | JUnit, Mockito (planned)            |
| DevOps Ready     | Docker, Docker Compose (planned)    |

---

## 📁 Project Structure

src/

├── controller --> Role-specific REST APIs

├── model --> Entity classes

├── repository --> Spring JPA interfaces

├── service --> Business logic layer

├── security --> Filters, JWT utils

├── dto --> Data Transfer Objects

└── utils --> Utility classes (JWT, validators, etc.)


---

## 🔐 User Roles & Permissions

| Role     | Register/Login | Ingest Docs | View Docs | Manage Users |
|----------|----------------|-------------|-----------|--------------|
| Admin    | ✅              | ✅           | ✅         | ✅            |
| Editor   | ✅              | ✅           | ✅         | ❌            |
| Viewer   | ✅              | ❌           | ✅         | ❌            |

---

## 🏃‍♂️ How to Run Locally

### 1. Clone the repository
git clone https://github.com/vijaym2211/DocumentQnAApp.git
cd DocumentQnAApp

### 2. Configure MySQL Database
Update your application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/doc_qna
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

### 3. Build and Run the application
mvn clean install
mvn spring-boot:run

### 4. Access APIs
Swagger UI (Planned): http://localhost:8088/swagger-ui/

Login and get JWT, then access protected APIs with Authorization: Bearer <token>


## 🔧 Future Enhancements

- ✅ Document Ingestion APIs (PDF, DOCX, Text)
- 🔍 Basic Q&A Keyword Search
- 🗂️ Metadata Filter APIs (author, type, date)
- 🧪 Unit Testing for Services & Controllers
- 📘 Swagger API Documentation
- 🧵 Asynchronous Document Processing (Spring Async/Spring Batch)
- 📊 Redis Caching for popular queries
- 🪝 Message Queue Integration (Kafka/RabbitMQ)
- 🐳 Docker Compose Setup
- 🚀 CI/CD pipeline with GitHub Actions
- ☁️ Cloud Deployment: AWS EC2 + RDS

---

## 🧪 Testing Plan (Coming Soon)

- JUnit + Mockito-based unit tests
- Test coverage ≥ 70%
- Functional tests for all workflows
- Performance testing on large documents

---

## 📄 API Endpoints Summary

| Method | Endpoint            | Access               |
|--------|---------------------|----------------------|
| POST   | /admin/register     | Public (Admin only)  |
| POST   | /admin/login        | Public               |
| GET    | /admin/getAllUsers  | Admin only           |
| PUT    | /admin/updateUser   | Admin only           |
| POST   | /viewer/register    | Public               |
| POST   | /viewer/login       | Public               |
| GET    | /viewer/**          | Viewer/Admin/Editor  |

> 🔐 All protected routes require `Authorization: Bearer <JWT>` header.

---

## 🤝 Contribution & Contact

Feel free to raise issues or pull requests on GitHub.  
For queries, connect with **Vijay Mohite**  
📧 Email: [vijaym2211@gmail.com](mailto:vijaym2211@gmail.com)
#   D o c u m e n t Q n A A p p 
 
 
