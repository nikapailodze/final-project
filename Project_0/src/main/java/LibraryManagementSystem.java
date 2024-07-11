import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        prepareLibrary(library);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Find book by title");
            System.out.println("3. Find book by author");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Display all books
                    System.out.println("All Books:");
                    Library.displayBooks(library.getAllBooks());
                    break;
                case 2:
                    // Find book by title
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    Library.displayBooks(library.getBooksByTitle(title));
                    break;
                case 3:
                    // Find book by author
                    System.out.print("Enter author name (Ex. Lisa Darwin): ");
                    String author = scanner.nextLine();
                    Library.displayBooks(library.getBooksByAuthor(author));
                    break;
                case 4:
                    // Borrow a book
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    if(library.isBorrower(email) || (!library.isBorrower(email) && acceptRegisterRequest(scanner, library, email))){
                            System.out.print("Enter book title to borrow: ");
                            title = scanner.nextLine();
                            System.out.print("Enter author of this book: ");
                            author = scanner.nextLine();
                            if(library.bookExists(title, author)){
                                Book book = library.getBook(title, author);
                                if(library.isBookAvailable(book)) {
                                    library.borrowBook(email, book);
                                    System.out.println(email + " successfully borrowed the book: " + title);
                                }else {
                                    System.out.println("Unfortunately, the book is not available at this moment.");
                                }
                            }else {
                                System.out.println("Unfortunately, this book could not be found.");
                            }
                    }
                    break;
                case 5:
                    // Return a book
                    System.out.print("Enter your email: ");
                    email = scanner.nextLine();
                    if(!library.isBorrower(email)){
                        System.out.print("No book with this email was borrowed.");
                        break;
                    }
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter book author to return: ");
                    author = scanner.nextLine();
                    if(library.bookExists(title, author)) {
                        Book book = library.getBook(title, author);
                        library.returnBook(book);
                        System.out.print(email+" returned book: " + title);
                    } else {
                        System.out.print("No book with this title was lent.");
                    }
                    break;
                case 6:
                    // Exit
                    System.out.print("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean acceptRegisterRequest(Scanner scanner, Library lib, String email) {
        System.out.println("Looks like, it's your first time borrowing a book here. " +
                "I need to ask you to register first.");
        System.out.println("1.Register");
        System.out.println("2.Exit");
        int registerChoice = scanner.nextInt();
        if(registerChoice ==1) {
            System.out.print("Enter you name: ");
            String name = scanner.nextLine();
            scanner.nextLine();
            lib.registerBorrower(new Borrower(name, email));
            return true;
        }
        return false;
    }

    public static void prepareLibrary(Library library) {
        library.addBook(new Book("A", "Lisa Darwin", "ISBN1"));
        library.addBook(new Book("B", "George Harden", "ISBN2"));
        library.addBook(new Book("C", "Martin Eden", "ISBN3"));
        library.addBook(new Book("D", "Martin Eden", "ISBN4"));

        library.registerBorrower(new Borrower("Marry", "marry@gmail.com"));
    }
}
