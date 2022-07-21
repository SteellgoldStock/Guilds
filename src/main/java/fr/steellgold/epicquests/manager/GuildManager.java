package fr.steellgold.epicquests.manager;

import fr.steellgold.epicquests.Guild;
import fr.steellgold.epicquests.database.DatabaseConnection;
import fr.steellgold.epicquests.session.Session;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class GuildManager {

    public static HashMap<UUID, Session> guilds;

    public GuildManager() {
        guilds = new HashMap<>();
    }

    public static void newPlayer(Connection connection, Player player) {
        try {
            final PreparedStatement statement = connection.prepareStatement("INSERT INTO guilds (uuid, name) VALUES (?, ?)");
            statement.setString(1, player.getUniqueId().toString());
            statement.setString(2, player.getName());
            statement.executeUpdate();

            loadSession(connection, player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean loadSession(Connection connection, Player player) {
        try {
            final PreparedStatement statement = connection.prepareStatement("SELECT * FROM guilds WHERE uuid = ?");
            System.out.println(player.getUniqueId().toString());
            statement.setString(1, player.getUniqueId().toString());
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                final Session session = new Session(player, resultSet);
                GuildManager.guilds.put(player.getUniqueId(), session);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Session getSession(Player player) {
        return GuildManager.guilds.get(player.getUniqueId());
    }

    public static boolean isSessionOpen(Player player) {
        return GuildManager.guilds.containsKey(player.getUniqueId());
    }

    public static void closeSession(Player player) {
        // Envoyer les données de la session dans la base de données (Requete UPDATE)
        final Session session = GuildManager.guilds.get(player.getUniqueId());
        final DatabaseConnection playersConnection = Guild.getDatabaseManager().getPlayersConnection();
        Guild.getInstance().getServer().getScheduler().runTaskAsynchronously(Guild.getInstance(), () -> {
            try {
                final Connection connection = playersConnection.getConnection();
                final PreparedStatement statement = connection.prepareStatement("UPDATE players SET guild = ? WHERE uuid = ?");
                statement.setNull(1, Types.NULL);
                statement.executeUpdate();

                GuildManager.guilds.remove(player.getUniqueId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
