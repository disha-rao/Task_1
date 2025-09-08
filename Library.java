package library_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for issue/return behavior (Borrowable)
interface Borrowable {
    boolean lendOut();
    boolean takeBack();
    boolean availableStatus();
}

// Fundamental Library class ( lesson Library)
public class Library {

    // Internal Book class ( course Book executes Borrowable)
    class Book implements Borrowable {
        private String title;
        private String writer;   // essayist
        private String code;     //  ISBN
        private boolean free;    // genuine

        // open Book(String title, String essayist, String code)
        public Book(String title, String writer, String code) {
            this.title = title;
            this.writer = writer;
            this.code = code;
            this.free = true; // book begins available ( genuine)
        }

        @Override
        public boolean lendOut() { //  open boolean lendOut()
            if (free) {
                free = false;
                return true;
            }
            return false;
        }

        @Override
        public boolean takeBack() { //  open boolean takeBack()
            if (!free) {
                free = true;
                return true;
            }
            return false;
        }

        @Override
        public boolean availableStatus() { //  open boolean availableStatus()
            return free;
        }

        public String getCode() { // open String getCode()
            return code;
        }

        public void showDetails() { //  open void showDetails()
            System.out.println("Title: " + title + ", Creator: " + writer
                    + ",ISBN: " + code + ", Accessible: " + free);
        }
    }

    //  Use ONE consistent list for books
    private final List<Book> shelf; // rack

    // humanized: open Library()
    public Library() {
        this.shelf = new ArrayList<>();
    }

    // Include book to library ( open Book addBook)
    public Book addBook(String t, String w, String c) {
        Book b = new Book(t, w, c);
        shelf.add(b);
        return b;
    }

    // Discover a book by ISBN ( open Book findBook)
    public Book findBook(String c) {
        for (Book b : shelf) {
            if (b.getCode().equals(c)) {
                return b;
            }
        }
        return null; // humanized: invalid
    }

    // Appear all books (open void displayAll)
    public void displayAll() {
        if (shelf.isEmpty()) {
            System.out.println("No books available  in the library.");
        } else {
            for (Book b : shelf) {
                b.showDetails();
            }
        }
    }

    //  Menu-driven fundamentals
    //  open inactive void main(String[] args)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(); // humanized: modern Library()
        boolean exit = false;

        //  whereas (!exit)
        while (!exit) {
            System.out.println("\n….Library Menu….");
            System.out.println("1. Add Book");
            System.out.println("2. Issue the Book");
            System.out.println("3. Return the Book");
            System.out.println("4. Show available Books");
            System.out.println("5. Exit");
            System.out.print("Choose your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // devour newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the Title: ");
                    String t = sc.nextLine();
                    System.out.print("Enter the Creator: ");
                    String w = sc.nextLine();
                    System.out.print("Enter the ISBN: ");
                    String c = sc.nextLine();
                    lib.addBook(t, w, c);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter ISBN to issue: ");
                    String issueCode = sc.nextLine();
                    Book issueBook = lib.findBook(issueCode);
                    if (issueBook != null && issueBook.lendOut()) {
                        System.out.println("Book issued successfully!!");
                    } else {
                        System.out.println("Book not available or as of now issued.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnCode = sc.nextLine();
                    Book returnBook = lib.findBook(returnCode);
                    if (returnBook != null && returnBook.takeBack()) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Book not available or as of now in library.");
                    }
                    break;

                case 4:
                    System.out.println("\n Books in Library:");
                    lib.displayAll();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting Library Framework!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
