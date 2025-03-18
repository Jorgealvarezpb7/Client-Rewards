package com.jorgealvarezpb7.client_rewards_app.Services.SaleService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.jorgealvarezpb7.client_rewards_app.Models.Sale;
import com.jorgealvarezpb7.client_rewards_app.Services.Database;

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
                points,
                createdAt
            ) VALUES (
                ?,
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

        String query2 = """
                UPDATE clients
                    SET points = (
                    SELECT CAST(SUM(totalAmount) * ? AS INTEGER)
                    FROM sales
                    WHERE sales.clientId = clients.clientId
                )
                WHERE clientId IN (SELECT DISTINCT clientId FROM sales);
                """;

        try {
            Double garcaLvl = 0.10;
            PreparedStatement ps  = db.getConn().prepareStatement(query2);
            ps.setDouble(1, garcaLvl);
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public ArrayList<Sale> listSales() {
        String query = """
                SELECT
                    sales.*,
                    SUM(c.points) AS points
                FROM
                    sales
                    RIGHT JOIN clients c ON c.clientId = sales.clientId
                WHERE
                    sales.totalAmount > 0
                GROUP BY
                    sales.clientId
                """;
        try {
            Statement st = db.getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Sale> sales = new ArrayList<>();
    
            while (rs.next()) {
                String productId = rs.getString("productId");
                int quantity = rs.getInt("quantity");
                String clientId = rs.getString("clientId");
                Double totalAmount = rs.getDouble("totalAmount");
                Double points = rs.getDouble("points");
                Long createdAt = rs.getLong("createdAt");
                Date date = new Date(createdAt);
               
                Sale sale = new Sale (productId, quantity, clientId, totalAmount, points, date);
                sales.add(sale);
            }
            
            return sales;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    }

    public SaleSummary dailySummary() {
        return new SaleSummary(10.0, 101, 0.01);
    }
}
