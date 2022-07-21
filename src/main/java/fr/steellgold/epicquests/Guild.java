package fr.steellgold.epicquests;

import fr.steellgold.epicquests.commands.GuildCommand;
import fr.steellgold.epicquests.database.DatabaseManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Guild extends JavaPlugin {

    public static DatabaseManager manager;

    public static Guild instance;

    public void onEnable() {
        getLogger().info("Guild is enabled");
        manager = new DatabaseManager();
        instance = this;

        getCommand("guild").setExecutor(new GuildCommand());
    }

    public void onDisable() {
        getLogger().info("Guild is disabled");
    }

    public static DatabaseManager getDatabaseManager() {
        return manager;
    }

    public static Guild getInstance() {
        return instance;
    }
}
