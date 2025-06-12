package dao;

import model.BorrowRecord;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {
    public void borrowBook(BorrowRecord record) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO borrow_records (book_id, user_id, borrow_date) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, record.getBookId());
        stmt.setInt(2, record.getUserId());
        stmt.setDate(3, record.getBorrowDate());
        stmt.executeUpdate();
    }

    public void returnBook(int bookId, int userId, Date returnDate) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE borrow_records SET return_date = ? WHERE book_id = ? AND user_id = ? AND return_date IS NULL";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDate(1, returnDate);
        stmt.setInt(2, bookId);
        stmt.setInt(3, userId);
        stmt.executeUpdate();
    }

    public List<BorrowRecord> getUserBorrowRecords(int userId) throws SQLException {
        List<BorrowRecord> records = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM borrow_records WHERE user_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            records.add(new BorrowRecord(
                rs.getInt("id"),
                rs.getInt("book_id"),
                rs.getInt("user_id"),
                rs.getDate("borrow_date"),
                rs.getDate("return_date")
            ));
        }
        return records;
    }
}
