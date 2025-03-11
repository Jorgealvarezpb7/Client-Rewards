package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection conn;

    public Database() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch(SQLException err) {
            err.printStackTrace(System.err);
        }
    }

    public void runMigrations() {
        try {
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS clients (name TEXT, surname TEXT, surname2 TEXT, phone TEXT, email TEXT, createdAt INTEGER)");
            st.execute("CREATE TABLE IF NOT EXISTS products (name TEXT, id TEXT, quantity INTEGER, price REAL, createdAt INTEGER)");
            st.execute("CREATE TABLE IF NOT EXISTS sales (productId TEXT, quantity INTEGER, clientId TEXT, totalAmount REAL, createdAt INTEGER)");
        
        } catch (SQLException err) {
            System.err.println(err.toString());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
