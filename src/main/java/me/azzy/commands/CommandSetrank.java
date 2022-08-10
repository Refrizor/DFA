package me.azzy.commands;

import me.azzy.DatabaseHandler;
import me.azzy.rank.Permission;
import me.azzy.rank.Rank;
import me.azzy.rank.RankReceiver;
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

public class CommandSetrank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;
        if (player.isOp()) {

            if (length == 0 || length > 3) {
                player.sendMessage(ChatColor.RED + "Usage: /setrank <player> <branch> <ID>");
                return false;
            }

            OfflinePlayer offlinePlayer = Bukkit.getPlayerExact(args[0]);
            String branch = args[1];
            int id = Integer.parseInt(args[2]);

            try {
                Connection connection = DatabaseHandler.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `ranks` WHERE `uuid` = '" + offlinePlayer.getUniqueId() + "'");
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE `ranks` SET `" + branch + "` = " + id + " WHERE `uuid` = '" + offlinePlayer.getUniqueId() + "'");
                    preparedStatement1.execute();

                    Rank.getEventID().remove(offlinePlayer.getUniqueId());
                    Rank.getAdminID().remove(offlinePlayer.getUniqueId());
                    Rank.getModerationID().remove(offlinePlayer.getUniqueId());
                    Rank.getSupportID().remove(offlinePlayer.getUniqueId());
                    Rank.getDonorID().remove(offlinePlayer.getUniqueId());
                    Rank.getYoutuberID().remove(offlinePlayer.getUniqueId());

                    //new Tab().removeEntries(player);
                    new RankReceiver().receive(offlinePlayer);

                    new Permission().deployPermissions((Player) offlinePlayer);
                    player.sendMessage(ChatColor.GREEN + "Rank set!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}