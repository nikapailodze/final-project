import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;
    private Map<String, String> borrowedList;

    public Library() {
        books = new ArrayList<>();
        borrowers = new ArrayList<>();
        borrowedList = new HashMap<>();
    }

    public void addBook(Book book) {
        if (!bookExists(book.getTitle(), book.getAuthorName())) {
            books.add(book);
        }
    }

    public void registerBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public ArrayList<Book> getAllBooks() {
        return this.books;
    }

    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> list = new ArrayList<>();
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> list = new ArrayList<>();
        for(Book book: books) {
            if(book.getAuthorName().equalsIgnoreCase(author)) {
                list.add(book);
            }
        }
        return list;
    }

    public void borrowBook(String email, Book book) {
        borrowedList.put(book.getISBN(), email);
    }

    public void returnBook(Book book) {
        borrowedList.remove(book.getISBN());
    }

    public static void displayBooks(ArrayList<Book> list) {
        if(list.isEmpty()) {
            System.out.println("Unfortunately, could not find any books.");
            return;
        }
        for(Book book: list) {
            Book.print(book);
        }
    }

    public boolean isBorrower(String email) {
        for (Borrower b : borrowers) {
            if (b.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Borrower getBorrower(String email) {
        for(Borrower b: borrowers) {
            if(b.getEmail().equalsIgnoreCase(email)) {
                return b;
            }
        }
        return null;
    }

    public Book getBook(String title, String author) {
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(title) && book.getAuthorName().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    public boolean bookExists(String title, String author) {
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(title) && book.getAuthorName().equalsIgnoreCase(author)) return true;
        }
        return false;
    }

    public boolean isBookAvailable(Book book) {
        return !borrowedList.containsKey(book.getISBN());
    }

}
