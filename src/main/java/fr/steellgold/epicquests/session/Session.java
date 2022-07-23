package fr.steellgold.epicquests.session;

import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Session {
    private final Player player;
    private final int wood;
    private final int money;
    private final int stone;

    public Session(Player player, ResultSet rs) throws SQLException {
        this.player = player;
        this.money = rs.getInt("money");
        this.wood = rs.getInt("wood");
        this.stone = rs.getInt("stone");
    }

    public Player getPlayer() {
        return player;
    }

    public int getMoney() {
        return money;
    }

    public int getStone() {
        return stone;
    }

    public int getWood() {
        return wood;
    }
}