package com.mcdiamondfire.commands;

import com.mcdiamondfire.DatabaseHandler;
import com.mcdiamondfire.rank.RankReceiver;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommandBadge implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;

        if(player.isOp()){

            if (length == 0 || length > 3) {
                player.sendMessage(ChatColor.RED + "Usage: /setbadge <player> <badge> <ID>");
                return false;
            }

            OfflinePlayer offlinePlayer = Bukkit.getPlayerExact(args[0]);
            String branch = args[1];
            int id = Integer.parseInt(args[2]);

            try{
                Connection connection = DatabaseHandler.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `badges` WHERE `uuid` = '" + offlinePlayer.getUniqueId() + "'");
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `badges` SET `" + branch + "` = " + id + " WHERE `uuid` = '" + offlinePlayer.getUniqueId() + "'");
                    preparedStatement1.execute();
                }

                player.sendMessage(ChatColor.GREEN + "Badge set!");
                new RankReceiver().receive(offlinePlayer);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }
}
