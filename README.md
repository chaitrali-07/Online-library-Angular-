## 👩‍💻 Developer Group

This project was developed by:

| Developer           | GitHub Profile |
|---------------------|----------------|
| Chaitrali Diwanji   | [chaitrali-07](https://github.com/chaitrali-07) |
| Priya Telange       | [priya-02](https://github.com/priya-02) |
| Siddhi Joshi        |[siddhijoshi-dotcom](https://github.com/siddhijoshi-dotcom) |

---

# 📚 Online Library System

An **Online Library Management System** built with:

- **Backend**: Spring Boot + REST API + JPA + Hibernate + PostgreSQL  
- **Frontend**: Angular (TypeScript, HTML, CSS)  
- **IDE**: Spring Tool Suite (STS) & VS Code  

This project allows users to:  
- View all books in the library  
- Borrow and return books  
- Add new books with quantity and genre  
- Manage book inventory in real-time  

---

## ✨ Features

- **Book List Display**  
  View all available books along with their title, author, quantity, and genre.  

- **Add New Books**  
  Add books via a simple form in the Angular frontend.  

- **Borrow Books**  
  Quantity decreases when a book is borrowed.  
  Borrow button is only active if the quantity is greater than 0.  

- **Return Books**  
  Return a borrowed book, increasing the quantity.  

- **Genre Categorization**  
  Books are displayed based on genre for easier browsing.  

---

## 🛠 Tech Stack

**Backend**
- Spring Boot  
- Spring Data JPA (Hibernate)  
- REST API  
- PostgreSQL (configurable)  

**Frontend**
- Angular (TypeScript)  
- HTML5  
- CSS3  

**Tools**
- Spring Tool Suite (STS)  
- VS Code  
- Git & GitHub  

---

## ⚙️ Configure Database

Add the following properties in your `application.properties` (Spring Boot):

```properties
spring.application.name=VirtualLibrary
spring.datasource.url=jdbc:postgresql://localhost:5432/Library_DB
spring.datasource.username=postgres
spring.datasource.password=12345
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
---
## Snapshot
   <img width="1366" height="768" alt="Screenshot (189)" src="https://github.com/user-attachments/assets/d3f1099a-52e4-44af-b36e-00256b30cec8" />
   <img width="1366" height="768" alt="Screenshot (190)" src="https://github.com/user-attachments/assets/274a9205-a43a-4bd9-9536-3af0bf0ef31a" />

<img width="1366" height="768" alt="Screenshot (191)" src="https://github.com/user-attachments/assets/3e95db58-25b8-4d14-887d-80eb50afd6af" />

