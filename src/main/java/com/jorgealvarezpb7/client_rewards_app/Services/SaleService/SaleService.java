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
import java.util.Optional;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;
import com.jorgealvarezpb7.client_rewards_app.Models.Product;
import com.jorgealvarezpb7.client_rewards_app.Models.Sale;
import com.jorgealvarezpb7.client_rewards_app.Services.Authenticated;
import com.jorgealvarezpb7.client_rewards_app.Services.ClientService;
import com.jorgealvarezpb7.client_rewards_app.Services.Database;
import com.jorgealvarezpb7.client_rewards_app.Services.ProductService;

public class SaleService {
    private Database db;
    private ClientService clientService;
    private ProductService productService;

    public SaleService(ClientService clientService, ProductService productService) {
        db = new Database();
        this.clientService = clientService;
        this.productService = productService;
    }

    public void createSale(String productId, int quantity, String clientId, Double totalAmount) throws Exception {
        Optional<Client> maybeClient = this.clientService.findClientById(clientId);
        Optional<Product> maybeProduct = this.productService.findProductById(productId);

        if (maybeClient.isEmpty()) {
            throw new Exception("Cliente no existe");
        }
        if (maybeProduct.isEmpty()) {
            throw new Exception("Producto no existe");
        }
    
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
                    WHERE sales.clientId = clients.id
                )
                WHERE clients.id IN (SELECT DISTINCT clientId FROM sales);
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
	                sales.*
                FROM
	                sales
	            RIGHT JOIN clients c ON c.id = sales.clientId
                WHERE
	                sales.totalAmount > 0
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

    public ArrayList<RecurrentPurchase> customerTop3Purchases(String clientId) {
        String query = """
            SELECT
	            SUM(sales.quantity) AS totalQ,
	            products."name"
            FROM
	            sales
	            LEFT JOIN products ON products.id = sales.productId
            WHERE
	            sales.clientId = ?
            GROUP BY
	            sales.productId
            ORDER BY
	            totalQ DESC
        """;

        try {
            PreparedStatement ps = db.getConn().prepareStatement(query);
            ps.setString(1, clientId);

            ResultSet rs = ps.executeQuery();
            ArrayList<RecurrentPurchase> purchases = new ArrayList<>();
    
            while (rs.next()) {
                String name = rs.getString("name");
                int totalQ = rs.getInt("totalQ");
               
                RecurrentPurchase recurrentPurchase = new RecurrentPurchase (name, totalQ);
                purchases.add(recurrentPurchase);
            }
            return purchases;            

        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    }
}
