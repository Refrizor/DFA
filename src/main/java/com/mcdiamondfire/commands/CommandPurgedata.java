package com.mcdiamondfire.commands;

import com.mcdiamondfire.DatabaseHandler;
import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.rank.Branch;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommandPurgedata implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(PlayerData.getBranchID(Branch.ADMINISTRATION, player) >= 2 && player.isOp()){
            int length = args.length;
            if(length == 0){
                try{
                    Connection connection = DatabaseHandler.getConnection();
                    PreparedStatement purgeRanks = connection.prepareStatement("DELETE FROM `ranks` WHERE `uuid` = '" + player.getUniqueId() + "'");
                    PreparedStatement purgeBadges = connection.prepareStatement("DELETE FROM `badges` WHERE `uuid` = '" + player.getUniqueId() + "'");
                    PreparedStatement purgePlayers = connection.prepareStatement("DELETE FROM `players` WHERE `uuid` = '" + player.getUniqueId() + "'");

                    purgeRanks.execute();
                    purgeBadges.execute();
                    purgePlayers.execute();

                    player.sendMessage(ChatColor.GREEN + "Purged!");
                    player.kickPlayer(ChatColor.RED + "Purged data");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
