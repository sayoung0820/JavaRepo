public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Create Constructor
    public Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Create method to borrow book
    public void borrowBook() {
        isAvailable = false;
    }

    // Create method to print book data
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author + " (Available: " + isAvailable + ")");
    }
}
