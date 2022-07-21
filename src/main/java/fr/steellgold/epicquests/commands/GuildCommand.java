package fr.steellgold.epicquests.commands;

import fr.steellgold.epicquests.commands.subs.CreateCommand;
import fr.steellgold.epicquests.utils.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GuildCommand implements TabExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public GuildCommand() {
        subcommands.add(new CreateCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 0) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    getSubCommands().get(i).perform(player, args);
                    return true;
                }
            }
        }

        ColorUtil.sendMessage(player, "Executer la commande §f/guild help §7si vous avez besoins d'aide sur les commandes disponibles sur le serveur", ColorUtil.PREFIX);
        return true;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subcommands;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1) { // command <subcommand> <args>
            ArrayList<String> subcommandsArguments = new ArrayList<>();

            for (int i = 0; i < getSubCommands().size(); i++) {
                subcommandsArguments.add(getSubCommands().get(i).getName());
            }

            return subcommandsArguments;
        } else if (args.length >= 2) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    return getSubCommands().get(i).getSubcommandArguments((Player) sender, args);
                }
            }
        } else {
            System.out.println("Aucune sous-commande n'a été demandé");
        }

        return null;
    }
}
