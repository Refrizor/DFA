package com.mcdiamondfire.commands;

import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.rank.Branch;
import com.mcdiamondfire.rank.Permissions;
import com.mcdiamondfire.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFlight implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.hasPermission(Permissions.FLIGHT.getPermission()) || PlayerData.getBranchID(Branch.MODERATION, player) >=1 || PlayerData.getBranchID(Branch.ADMINISTRATION, player) >=1){

            if(player.getAllowFlight()){
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.AQUA + "Flight disabled");
            }else{
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.AQUA + "Flight enabled");
            }
        }else{
            player.sendMessage(Messages.NO_PERM.getMessage());
        }
        return true;
    }
}
