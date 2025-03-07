package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.jorgealvarezpb7.client_rewards_app.Models.Product;

public class ProductService {
    private Database db;
    
    public ProductService() {
        db = new Database();
    }

    public void createProduct(String name, String code, int quantity, int price) {
        //if (name.isEmpty()) { 
        String query = """
            INSERT INTO products (
                name,
                code,
                quantity,
                price,
                created_at
            ) VALUES (
                ?,
                ?,
                ?,
                ?,
                ? 
            );
        """;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try {
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, code);
            ps.setInt(3, quantity);
            ps.setInt(4, price);
            ps.setLong(5, timestamp.getTime());
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public ArrayList<Product> listProducts() {
        String query = "SELECT * FROM products";
        try {
            Statement st = db.getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Product> products = new ArrayList<>();
    
            while (rs.next()) {
                String name = rs.getString("name");
                String code = rs.getString("code");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                Product product = new Product (name, code, quantity, price);
                products.add(product);
            }
            
            return products;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    } 
}
