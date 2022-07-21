package fr.steellgold.epicquests.commands.subs;

import fr.steellgold.epicquests.commands.SubCommand;
import fr.steellgold.epicquests.utils.ColorUtil;
import org.bukkit.entity.Player;

import java.util.List;

public class CreateCommand extends SubCommand {
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSyntax() {
        return null;
    }

    @Override
    public void perform(Player player, String[] args) {
        ColorUtil.sendMessage(player, "Cette commande n'est pas encore disponible", ColorUtil.PREFIX);
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
