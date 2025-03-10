package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.jorgealvarezpb7.client_rewards_app.Models.Sale;

public class SaleService {
    private Database db;
    
    public SaleService() {
        db = new Database();
    }

    public void createSale(String productId, int quantity, String clientId, Double totalAmount) {
        //if (name.isEmpty()) { 
        String query = """
            INSERT INTO sales (
                productId,
                quantity,
                clientId,
                totalAmount,
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
            ps.setString(1, productId);
            ps.setInt(2, quantity);
            ps.setString(3, clientId);
            ps.setDouble(4, totalAmount);
            ps.setLong(5, timestamp.getTime());
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public ArrayList<Sale> listSales() {
        String query = "SELECT * FROM sales";
        try {
            Statement st = db.getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Sale> sales = new ArrayList<>();
    
            while (rs.next()) {
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                String clientId = rs.getString("clientId");
                Double totalAmount = rs.getDouble("totalAmount");
                Sale sale = new Sale (productId, quantity, clientId, totalAmount);
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    } 
}
