package fr.steellgold.epicquests.session;

import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Session {
    private final Player player;

    public Session(Player player, ResultSet rs) throws SQLException {
        this.player = player;
    }
}