public class Book {
    private String title;
    private String authorName;
    private String ISBN;

    public Book(String title, String authorName, String isbn) {
        this.title = title;
        this.authorName = authorName;
        this.ISBN = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public static void print (Book book) {
        String displayStr = "Book: [name: ";
        displayStr += book.getTitle() + ", by: ";
        displayStr += book.getAuthorName();
        displayStr += "]";
        System.out.println(displayStr);
    }


}
