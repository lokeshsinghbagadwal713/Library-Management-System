package service;

import dao.UserDAO;
import model.User;

public class AuthService {
    private UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String username, String password) {
        try {
            User user = userDAO.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

    public boolean register(User user) {
        try {
            userDAO.addUser(user);
            return true;
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }
}
