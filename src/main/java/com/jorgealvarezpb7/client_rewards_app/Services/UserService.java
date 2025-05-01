package com.jorgealvarezpb7.client_rewards_app.Services;

import com.jorgealvarezpb7.client_rewards_app.Models.User;

import java.sql.*;

public class UserService {
    private final Connection conn;

    public UserService(Database db) {
        this.conn = db.getConn();
    }

    public boolean registerUser(String username, String password, String role) {
        try {
            String checkQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                rs.close();
                return false;
            }

            rs.close();

            String insertQuery = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, role);
            insertStmt.executeUpdate();
            insertStmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findUser(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                rs.close();
                return new User(username, password, role);
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
