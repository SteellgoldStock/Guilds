package fr.steellgold.epicquests;

import org.bukkit.plugin.java.JavaPlugin;

public class Guild extends JavaPlugin {
    public void onEnable() {
        getLogger().info("Guild is enabled");
    }

    public void onDisable() {
        getLogger().info("Guild is disabled");
    }
}
