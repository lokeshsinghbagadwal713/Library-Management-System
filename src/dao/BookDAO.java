package dao;

import model.Book;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public void addBook(Book book) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setBoolean(3, book.isAvailable());
        stmt.executeUpdate();
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM books";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            books.add(new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getBoolean("available")
            ));
        }
        return books;
    }

    public void updateAvailability(int bookId, boolean available) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE books SET available = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setBoolean(1, available);
        stmt.setInt(2, bookId);
        stmt.executeUpdate();
    }
}
