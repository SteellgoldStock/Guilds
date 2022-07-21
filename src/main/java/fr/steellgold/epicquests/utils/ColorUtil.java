package fr.steellgold.epicquests.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    public static String PREFIX = "&#c3ad16&l[&#c6b520&lG&#c9bd2a&lu&#cdc535&li&#d0cd3f&ll&#d3d549&ld&#d6dd53&l]§r";

    public static String colorize(String message) {
        message = matchHexaReplace("&#", message);
        message = matchHexaReplace("#", message);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private static String matchHexaReplace(String match, String message) {
        final Pattern hexPattern = Pattern.compile(match + "([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(message);
        StringBuilder buffer = new StringBuilder(message.length() + 4 * 8);
        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
        }
        return matcher.appendTail(buffer).toString();
    }

    public static void sendMessage(Player player, String message, String prefix) {
        player.sendMessage(colorize(prefix + "§7 " + message));
    }

    public static void sendMessage(Player player, String message, String prefix, Boolean isError) {
        player.sendMessage(colorize(prefix + (isError ? "§c " : "§7 ") + message));
    }
}