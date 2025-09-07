# 📚 Library Management System

A console-based Java application to manage a library's operations including book tracking, user management, borrowing, and returning books using a MySQL database.

---

## 🚀 Features

- 📘 View Available Books
- ➕ Add New Books
- 👥 User Registration & Login
- 🔄 Borrow and Return Books
- ⏰ Fine Calculation (after 14 days)
- 🛡️ Admin Controls (optional)
- 💾 Persistent storage using MySQL via JDBC

---

## 🛠️ Tech Stack

- **Java** (OOP + Modular Architecture)
- **MySQL** for data storage
- **JDBC** for database connectivity
- **MVC Pattern**

---

## 📁 Project Structure

LibraryManagementSystem/
├── src/
│ ├── model/ # Data classes (Book, User, etc.)
│ ├── dao/ # Data Access Objects
│ ├── service/ # Business logic
│ ├── util/ # Utility classes (DB connection, etc.)
│ ├── ui/ # Console interaction (menus)
│ └── Main.java # Entry point
├── database/
│ └── schema.sql # SQL schema for MySQL
├── out/ # Compiled .class files
├── .gitignore
├── manifest.txt
├── LibraryManagementSystem.jar
└── README.md


---

## ⚙️ How to Run

### 1. Compile & Create JAR

```bash
javac -d out -cp src src\**\*.java
Create manifest.txt with:

css
Copy code
Main-Class: ui.Main
Then build:

bash
Copy code
jar cfm LibraryManagementSystem.jar manifest.txt -C out .
2. Run the JAR
bash
Copy code
java -jar LibraryManagementSystem.jar
🗃️ MySQL Database Setup
Open MySQL CLI or GUI tool (like phpMyAdmin or MySQL Workbench)

Create a new database:

sql
Copy code
CREATE DATABASE library_db;
Import the schema:

bash
Copy code
mysql -u root -p library_db < database/schema.sql
Update your DBConnection.java file with your MySQL credentials if needed.

✍️ Author
Lokesh Singh Bagadwal
📍 Dehradun, India

📄 License
This project is licensed under the MIT License. Feel free to use and modify.
=======
# Library-Management-System

