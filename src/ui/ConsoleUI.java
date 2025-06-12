package ui;

import dao.BookDAO;
import dao.BorrowDAO;
import dao.UserDAO;
import model.User;
import service.AuthService;
import service.LibraryService;
import util.InputHelper;

public class ConsoleUI {
    private AuthService authService;
    private LibraryService libraryService;

    public ConsoleUI() {
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        BorrowDAO borrowDAO = new BorrowDAO();
        this.authService = new AuthService(userDAO);
        this.libraryService = new LibraryService(bookDAO, borrowDAO);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = InputHelper.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    private void login() {
        String username = InputHelper.getString("Username: ");
        String password = InputHelper.getString("Password: ");
        User user = authService.login(username, password);
        if (user != null) {
            System.out.println("Login successful! Welcome " + user.getName());
            dashboard(user);
        } else {
            System.out.println("Login failed!");
        }
    }

    private void register() {
        String name = InputHelper.getString("Name: ");
        String username = InputHelper.getString("Username: ");
        String password = InputHelper.getString("Password: ");
        boolean success = authService.register(new User(0, name, username, password));
        System.out.println(success ? "Registration successful!" : "Failed to register.");
    }

    private void dashboard(User user) {
        while (true) {
            System.out.println("\n--- Dashboard ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");

            int choice = InputHelper.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> libraryService.displayBooks();
                case 2 -> {
                    int bookId = InputHelper.getInt("Enter Book ID: ");
                    libraryService.borrowBook(user.getId(), bookId);
                }
                case 3 -> {
                    int bookId = InputHelper.getInt("Enter Book ID: ");
                    libraryService.returnBook(user.getId(), bookId);
                }
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
