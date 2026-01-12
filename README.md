 Project Overview
This project is a Java console application that performs basic CRUD (Create, Read, Update, Delete) operations using JDBC with a MySQL database. It is designed for beginners to understand how Java interacts with databases using JDBC and SQL queries.

 🚀 Features
- Create student records
- Read / display all student records
- Update existing student information
- Delete student records using ID
- Uses PreparedStatement for secure SQL execution

---

 Technologies Used
- Java (JDK 17)
- JDBC (Java Database Connectivity)
- MySQL Database
- IntelliJ IDEA 
- MySQL Connector/J

 Database Details
**Database Name:** `test`  
**Table Name:** `students1`

 Table Structure
```sql
CREATE TABLE students1 (
    Id INT PRIMARY KEY,
    name VARCHAR(50),
    Course VARCHAR(100),
    age INT
);

Important Notes
Make sure MySQL server is running
Update database username and password in code if required
Uses PreparedStatement to prevent SQL Injection

📌 Learning Outcomes
Understand JDBC architecture
Learn database connectivity in Java
Practice SQL queries (INSERT, SELECT, UPDATE, DELETE)
Gain hands-on experience with MySQL and Java integration
