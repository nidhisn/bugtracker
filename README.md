# 🐞 Bug Tracker Backend

Backend service for a Bug Tracker application built using **Spring Boot**.  
Provides REST APIs to create, update, assign, and filter bugs.

---

## 🚀 Features

- Create bugs  
- Retrieve all bugs  
- Get bug by ID  
- Update bug status  
- Assign bugs to users  
- Filter bugs by:
  - Status  
  - Priority  

---

## 🛠️ Tech Stack

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Hibernate  
- PostgreSQL  

---

## 📁 Project Structure
```
src/main/java/com/nidhisn/bugtracker/

├── controller/ # REST Controllers
├── service/ # Business logic
├── repository/ # Database access (JPA)
├── entity/ # Entities & Enums
└── config/ # Configuration (CORS, etc.)
```

---

##  🔗 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /api/bugs | Create bug |
| GET    | /api/bugs | Get all bugs |
| GET    | /api/bugs/{id} | Get bug by ID |
| PUT    | /api/bugs/{id}/status?status=OPEN | Update status |
| PUT    | /api/bugs/{id}/assign?assignedTo=User | Assign bug |
| GET    | /api/bugs/status?status=OPEN | Filter by status |
| GET    | /api/bugs/priority?priority=HIGH | Filter by priority |

---

## Example Request

```json
{
  "title": "Login issue",
  "priority": "HIGH",
  "status": "OPEN"
}
```
---

## ⚙️ Setup

### 1. Clone the repository

```bash
git clone <your-repo-url>
cd bug-tracker-backend
```

### 2. Configure database

Update application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/bugtracker
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Run the application
```
mvn spring-boot:run
```
