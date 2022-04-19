package com.mcdiamondfire.commands;

import com.mcdiamondfire.DiamondFire;
import com.mcdiamondfire.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdminv implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;

        if(length == 0){
            player.sendMessage(ChatColor.RED + "Usage: /adminv <off:on>");
        }

        if(length == 1){
            if(args[0].equalsIgnoreCase("on")){
                player.sendMessage(ChatColor.GREEN + "You are now vanished");
                if(!PlayerData.getVanished().contains(player.getName())){
                    PlayerData.getVanished().add(player.getName());

                    for(Player all : Bukkit.getOnlinePlayers()){
                        if(!all.isOp() && all.canSee(player)){
                            all.hidePlayer(DiamondFire.getInstance(), player);
                        }
                    }
                }
            }
            if(args[0].equalsIgnoreCase("off")){
                player.sendMessage(ChatColor.GREEN + "You are no longer vanished");
                if(PlayerData.getVanished().contains(player.getName())){
                    PlayerData.getVanished().remove(player.getName());

                    for(Player all : Bukkit.getOnlinePlayers()){
                        all.showPlayer(DiamondFire.getInstance(), player);
                    }
                }
            }
        }
        return true;
    }
}
