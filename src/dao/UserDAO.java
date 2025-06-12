package dao;

import model.User;
import util.DBConnection;

import java.sql.*;

public class UserDAO {
    public User getUserByUsername(String username) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password")
            );
        }
        return null;
    }

    public void addUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO users (name, username, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getPassword());
        stmt.executeUpdate();
    }
}
