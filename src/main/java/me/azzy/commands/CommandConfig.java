package me.azzy.commands;

import me.azzy.DiamondFire;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CommandConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    DiamondFire.getInstance().reloadConfig();
                    commandSender.sendMessage(ChatColor.AQUA + "Configuration reloaded");
                    try {
                        DiamondFire.getMessagesConfig().load(DiamondFire.getInstance().getFile());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
}