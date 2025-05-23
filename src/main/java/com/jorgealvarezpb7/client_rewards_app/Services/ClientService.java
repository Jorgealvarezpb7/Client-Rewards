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
import com.jorgealvarezpb7.client_rewards_app.Models.Points;

public class ClientService {
    private Database db;

    public ClientService() {
        db = new Database();
    }

    public void createClient(String name, String surname, String id, String phone, String email) {
        String query = """
                    INSERT INTO clients (
                        name,
                        surname,
                        id,
                        points,
                        phone,
                        email,
                        createdAt
                    ) VALUES (
                        ?,
                        ?,
                        ?,
                        0,
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
            ps.setString(3, id);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setLong(6, timestamp.getTime());
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
                String id = rs.getString("id");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Double pointsDouble = rs.getDouble("points");
                Points points = Points.fromDouble(pointsDouble);
                Long createdAt = rs.getLong("createdAt");
                Date date = new Date(createdAt);
                Client client = new Client(name, surname, id, points, phone, email, date);
                clients.add(client);
            }

            return clients;
        } catch (SQLException err) {
            System.err.println(err);
            return null;
        }
    }

    public Optional<Client> findClientById(String clientId) {
        ArrayList<Client> clients = this.listClients();
        Optional<Client> maybeClient = clients.stream()
                                              .filter((c) -> c.getId().equals(clientId))
                                              .findFirst();
        return maybeClient;
    }
}
