package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Models.Product;

public class ProductService {
    private Database db;
    
    public ProductService() {
        db = new Database();
    }

    public void createProduct(String name, String id, int quantity, Double price) {
        //if (name.isEmpty()) { 
        String query = """
            INSERT INTO products (
                name,
                id,
                quantity,
                price,
                createdAt
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
            ps.setString(2, id);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
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
                String id = rs.getString("id");
                int quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                Long createdAt = rs.getLong("createdAt");
                Date date = new Date(createdAt);
                Product product = new Product (name, id, quantity, price, date);
                products.add(product);
            }
            
            return products;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    }
    
     public Optional<Product> findProductById(String productId) {
        ArrayList<Product> products = this.listProducts();
        Optional<Product> maybeProducts = products.stream()
                                              .filter((c) -> c.getId().equals(productId))
                                              .findFirst();
        return maybeProducts;
    }
}
