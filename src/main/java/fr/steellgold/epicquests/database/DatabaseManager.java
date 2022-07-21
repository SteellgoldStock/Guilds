package fr.steellgold.epicquests.database;

import java.sql.SQLException;

public class DatabaseManager {

    private DatabaseConnection playerConnection;

    public DatabaseManager() {
        this.playerConnection = new DatabaseConnection(new DatabaseCredentials("127.0.0.1", "root", "", "skymoon"));
    }

    public DatabaseConnection getPlayersConnection() {
        return playerConnection;
    }

    public void close() {
        try {
            this.playerConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
    }
}
