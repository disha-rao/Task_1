# Task_1

📚 Library Management System (Java)
A simple console-based library management system written in Java. It allows users to add, issue, return, and view books in a library. It also includes JUnit tests to verify core book borrowing functionality.

🧾 Features
📥 Add new books to the library
📤 Issue books to users (mark as not available)
📥 Return books to the library (mark as available)
📃 Display all books with their availability status
✅ Unit tests using JUnit 4 for borrowing and returning logic

📁 Project Structure
library_management/
│
├── Library.java        # Core application logic and menu
├── LibraryTest.java    # JUnit test class for Borrowable functionality
└── README.md           # Project documentation (this file)

🔧 How It Works
Library.java
Main class: Library
Inner class: Book – represents individual books and implements the Borrowable interface.
Interface: Borrowable – defines standard methods like:
lendOut() – for issuing a book
takeBack() – for returning a book
availableStatus() – to check availability

Console Menu Options
1. Add Book
2. Issue the Book
3. Return the Book
4. Show available Books
5. Exit
