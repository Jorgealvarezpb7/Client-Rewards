package com.jorgealvarezpb7.client_rewards_app.Services;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientService {
    private Database db;
    
    public ClientService() {
        db = new Database();
    }

    public void createClient(String name) {
        //if (name.isEmpty()) { 
        String query = "INSERT INTO\n" + //
                        "\tclients (name)\n" + //
                        "VALUES\n" + //
                        "\t(?)";
        try {
            PreparedStatement ps = db.getConn().prepareStatement(query);
        ps.setString(1, name);
        ps.execute();
        } catch (SQLException err) {
            System.err.println(err);
        }
    }
}
