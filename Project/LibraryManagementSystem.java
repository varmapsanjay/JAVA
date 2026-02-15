import java.util.ArrayList;
import java.util.Scanner;
class Book 
{
    int id;
    String title;
    String author;
    boolean isBorrowed;
    public Book(int id, String title, String author) 
	{
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
}
class Library 
{
    private ArrayList<Book> books = new ArrayList<>();
    private int bookIdCounter = 1;
    public void addBook(String title, String author) 
	{
        books.add(new Book(bookIdCounter++, title, author));
        System.out.println("Book added successfully!");
    }
    public void viewBooks() 
	{
        if (books.isEmpty()) 
		{
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) 
		{
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Borrowed: " + book.isBorrowed);
        }
    }
    public void borrowBook(int id) 
	{
        for (Book book : books) 
		{
            if (book.id == id && !book.isBorrowed) 
			{
                book.isBorrowed = true;
                System.out.println("You have borrowed: " + book.title);
                return;
            }
        }
        System.out.println("Book not available or already borrowed.");
    }
    public void returnBook(int id) 
	{
        for (Book book : books) 
		{
            if (book.id == id && book.isBorrowed) 
			{
                book.isBorrowed = false;
                System.out.println("Book returned: " + book.title);
                return;
            }
        }
        System.out.println("Invalid book ID or book was not borrowed.");
    }
}
public class LibraryManagementSystem 
{
    public static void main(String[] args) 
	{
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do 
		{
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) 
			{
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } 
		while (choice != 5);
        scanner.close();
    }
}