import java.util.Scanner;

class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    // Constructor
    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method
    void printEntry() {
        System.out.println(
                title + " by " + author + " - "
                + copiesAvailable + " copies available"
        );
    }
}

public class LibraryInventoryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookInventory[] books = new BookInventory[4];

        for (int i = 0; i < books.length; i++) {

            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter author: ");
            String author = sc.nextLine();

            System.out.print("Enter copies available: ");
            int copiesAvailable = sc.nextInt();
            sc.nextLine();

            books[i] = new BookInventory(
                    title,
                    author,
                    copiesAvailable
            );
        }

        System.out.println("\nLibrary Inventory:");

        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }

        sc.close();
    }
}