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

    public void createSale(String product, int quantity, String client, int totalAmount) {
        //if (name.isEmpty()) { 
        String query = """
            INSERT INTO sales (
                product,
                quantity,
                client,
                total_Amount,
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
            ps.setString(1, product);
            ps.setInt(2, quantity);
            ps.setString(3, client);
            ps.setInt(4, totalAmount);
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
                String product = rs.getString("product");
                int quantity = rs.getInt("quantity");
                String client = rs.getString("client");
                int total_Amount = rs.getInt("total_Amount");
                Sale sale = new Sale (product, quantity, client, total_Amount);
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    } 
}
