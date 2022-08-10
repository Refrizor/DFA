package me.azzy.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandShout implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        String msg = "";
        for(int i = 0; i < length; i++){
            msg = msg + args[i] + " ";
        }

        if(length > 0){
            for(Player all : Bukkit.getServer().getOnlinePlayers()){
                all.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
        }
        return true;
    }
}
