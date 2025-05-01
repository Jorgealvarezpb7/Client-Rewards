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
            System.out.println("Failed to get database connection: " + err.getMessage());
        }
    }

    public void runMigrations() {
        try {
            Statement st = conn.createStatement();
            st.execute("""
                CREATE TABLE IF NOT EXISTS clients (
                    id TEXT PRIMARY KEY,
                    name TEXT,
                    surname TEXT,
                    points INTEGER,
                    phone TEXT,
                    email TEXT,
                    createdAt INTEGER
                )""");
            st.execute("""
                CREATE TABLE IF NOT EXISTS products (
                    id TEXT PRIMARY KEY,
                    name TEXT,
                    quantity INTEGER,
                    price REAL,
                    createdAt INTEGER
                )""");
            st.execute("""
                CREATE TABLE IF NOT EXISTS sales (
	                quantity INTEGER,
	                totalAmount REAL,
	                points REAL,
	                createdAt INTEGER,
	                productId TEXT,
	                clientId TEXT,
	                FOREIGN KEY (clientId) REFERENCES clients(id),
	                FOREIGN KEY (productId) REFERENCES products(id)
                )""");
            st.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL
                )""");
            st.close();
        } catch (SQLException err) {
            System.out.println(err.toString());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
