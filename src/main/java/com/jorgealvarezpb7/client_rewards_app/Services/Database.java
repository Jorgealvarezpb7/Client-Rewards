package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private Connection conn;

    public Database() {
        try {
            System.out.println("SI VES ESTO HAY CONEXION [[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]");
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch(SQLException err) {
            System.out.println("SI VES ESTO ES QUE NO HAY CONEXION [[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]");
            err.printStackTrace(System.err);
        }
    }

    public void runMigrations() {
        try {
            System.out.println("APUNTO DE INICIAR LA BASE  [[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]");
            Statement st = conn.createStatement();
            st.execute("""
                CREATE TABLE IF NOT EXISTS clients (
                    name TEXT,
                    surname TEXT,
                    points INTEGER,
                    clientId TEXT,
                    phone TEXT,
                    email TEXT,
                    createdAt INTEGER
                )""");
            st.execute("""
                CREATE TABLE IF NOT EXISTS products (
                    name TEXT,
                    id TEXT,
                    quantity INTEGER,
                    price REAL, createdAt INTEGER
                )""");
            st.execute("""
                CREATE TABLE IF NOT EXISTS sales (
                    productId TEXT,
                    quantity INTEGER,
                    clientId TEXT,
                    totalAmount REAL,
                    points REAL,
                    createdAt INTEGER
                )""");
                System.out.println("SI ENTRA AQUI LA BASE CORRE [[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]");
        } catch (SQLException err) {
            System.out.println("SI ENTRA AQUI HAY ERROR DURO MANAO [[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]");
            System.out.println(err.toString());
        }
    }

    public Connection getConn() {
        return conn;
    }
}
