Design Choices
The Library Management System is built using Java, encapsulating core functionalities in classes such as Book, Author, Borrower, and Library. Each class is designed with specific responsibilities:

Author: Manages author details.
Book: Handles book information, including title, author, and ISBN.
Borrower: Stores borrower details.
Library: Manages collections of books and borrowers, and includes methods to add books, register borrowers, borrow and return books.
Functionality
The main operations of the system are:

Adding and registering books and borrowers.
Searching for books by title or author.
Borrowing and returning books.
Displaying all available books.
A command-line interface (CLI) facilitates user interaction with options to perform the above operations. The CLI ensures a user-friendly experience and prompts users through each step.

Challenges
One challenge was ensuring data integrity when borrowing and returning books. The system checks if a book is already borrowed or if a user is registered before allowing borrowing operations. Additionally, handling user input robustly to prevent crashes from invalid data entries was crucial.

Implementing the file I/O functionality (bonus) would save and load library data to and from a file, ensuring data persistence across sessions. This would involve serializing objects to a file and deserializing them upon startup.
