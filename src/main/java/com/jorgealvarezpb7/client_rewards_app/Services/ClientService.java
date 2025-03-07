package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.jorgealvarezpb7.client_rewards_app.Models.Client;

public class ClientService {
    private Database db;
    
    public ClientService() {
        db = new Database();
    }

    public void createClient(String name, String surname, String phone, String email) {
        //if (name.isEmpty()) { 
        String query = """
            INSERT INTO clients (
                name,
                surname,
                phone,
                email,
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
            ps.setString(2, surname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setLong(5, timestamp.getTime());
            ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public ArrayList<Client> listClients() {
        String query = "SELECT * FROM clients";
        try {
            Statement st = db.getConn().createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Client> clients = new ArrayList<>();
    
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Client client = new Client(name, surname, phone, email);
                clients.add(client);
            }
            
            return clients;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    } 
}
