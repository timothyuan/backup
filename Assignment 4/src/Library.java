
import java.util.ArrayList;

public class Library {
	// Add the missing implementation to this class
	ArrayList<Book> books = new ArrayList<Book>();
	String address;

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

	public Library(String address) {
		this.address = address;
	}

	public void addBook(Book b) {
		books.add(b);
	}

	private Book findBook(String bookTitle) {
		for (Book b : books) {
			if (b.getTitle().equals(bookTitle)) {
				return b;
			}
		}
		return null;
	}

	public static void printOpeningHours() {
		System.out.println("9 am to 5 pm");
	}

	public void printAddress() {
		System.out.println(address);
	}

	public void borrowBook(String bookTitle) {
		Book book = findBook(bookTitle);
		if (book != null) {
			if (!book.isBorrowed()) {
				book.borrowed();
				System.out.println("You have borrowed "+bookTitle);
			} else {
				System.out.println("The book has already been borrowed");
			}
		} else {
			System.out.println("This book does not exist in the library catalog");
		}
	}

	public void printAvailableBooks() {
		if (!books.isEmpty()) {
			for (Book b : books) {
				if (!b.isBorrowed()) {
					System.out.println(b.getTitle());
				}
			}
		} else
			System.out.println("No books in the catalog");
	}

	public void returnBook(String bookTitle) {
		Book book = findBook(bookTitle);
		if (book != null) {
			if (book.isBorrowed()) {
				book.returned();
				System.out.println("You have returned "+bookTitle);
			} else {
				System.out.println("This book has already been returned");
			}
		} else {
			System.out.println("This book does not exist in the library catalog");
		}
	}
}