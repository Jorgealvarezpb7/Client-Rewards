package com.jorgealvarezpb7.client_rewards_app.Services.SaleService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
            ps.setDouble(5, totalAmount * 0.10);
            ps.setLong(6, timestamp.getTime());
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }

        String query2 = """
                UPDATE clients
                    SET points = (
                    SELECT CAST(SUM(totalAmount) * 10 AS INTEGER)
                    FROM sales
                    WHERE sales.clientId = clients.clientId
                )
                WHERE clientId IN (SELECT DISTINCT clientId FROM sales);
                """;

        try {
            PreparedStatement ps  = db.getConn().prepareStatement(query2);
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public ArrayList<Sale> listSales() {
        String query = """
                SELECT
                    sales.*,
                    SUM(c.points) AS clientPoints
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
                Double points = rs.getDouble("clientPoints");
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
        String query = """
            SELECT * FROM sales
            WHERE sales.createdAt 
            BETWEEN ? AND ? 
        """;

        try {
            PreparedStatement ps = db.getConn().prepareStatement(query);
            LocalDate now = LocalDate.now();
            
            LocalDateTime startOfDay = now.atStartOfDay();
            ZonedDateTime startOfDayZoned = startOfDay.atZone(ZoneId.systemDefault());
            Date startTimestamp = Date.from(startOfDayZoned.toInstant());

            LocalDateTime endOfDay = now.atTime(23, 59, 59, 999_999_999);
            ZonedDateTime endOfDayZoned = endOfDay.atZone(ZoneId.systemDefault());
            Date endTimestamp = Date.from(endOfDayZoned.toInstant());

            ps.setLong(1, startTimestamp.getTime());
            ps.setLong(2, endTimestamp.getTime());

            ResultSet rs = ps.executeQuery();
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
            
            // almacenar en un variable "income" de tipo double el acumulado/sumatoria de
            // ventas
            Double income = 0.0;
            int salesNumber = 0;
            Double average = 0.0;

            for (Sale sale : sales) {
                income += sale.getTotalAmount();
            }
            salesNumber = sales.size();
            if (salesNumber > 0) {
            average = income/salesNumber;
            } else {
            average = 0.0;
            }

            return new SaleSummary (income, salesNumber, average);
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    }
}
