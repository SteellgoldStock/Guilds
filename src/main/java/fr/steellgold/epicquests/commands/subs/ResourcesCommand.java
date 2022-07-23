package fr.steellgold.epicquests.commands.subs;

import fr.steellgold.epicquests.commands.SubCommand;
import fr.steellgold.epicquests.manager.PlayerManager;
import fr.steellgold.epicquests.session.Session;
import fr.steellgold.epicquests.utils.ColorUtil;
import org.bukkit.entity.Player;

import java.util.List;

public class ResourcesCommand extends SubCommand {
    @Override
    public String getName() {
        return "res";
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
        Session session = PlayerManager.getSession(player);

        ColorUtil.sendMessage(player,"Vous avez " + session.getWood() + " bois", ColorUtil.PREFIX);
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] args) {
        return null;
    }
}
