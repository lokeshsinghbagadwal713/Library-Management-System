package service;

import dao.BookDAO;
import dao.BorrowDAO;
import model.Book;
import model.BorrowRecord;

import java.sql.Date;
import java.util.List;

public class LibraryService {
    private BookDAO bookDAO;
    private BorrowDAO borrowDAO;

    public LibraryService(BookDAO bookDAO, BorrowDAO borrowDAO) {
        this.bookDAO = bookDAO;
        this.borrowDAO = borrowDAO;
    }

    public void displayBooks() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            books.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error displaying books: " + e.getMessage());
        }
    }

    public void borrowBook(int userId, int bookId) {
        try {
            borrowDAO.borrowBook(new BorrowRecord(0, bookId, userId, new Date(System.currentTimeMillis()), null));
            bookDAO.updateAvailability(bookId, false);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.out.println("Borrowing failed: " + e.getMessage());
        }
    }

    public void returnBook(int userId, int bookId) {
        try {
            borrowDAO.returnBook(bookId, userId, new Date(System.currentTimeMillis()));
            bookDAO.updateAvailability(bookId, true);
            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            System.out.println("Return failed: " + e.getMessage());
        }
    }
}
