package com.mcdiamondfire.rank;

import com.mcdiamondfire.DatabaseHandler;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RankReceiver {

    int donor;
    int support;
    int moderation;
    int admin;
    int youtuber;

    int events;

    public void receive(OfflinePlayer player) {
        try {
            Connection connection = DatabaseHandler.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT donor,support,moderation,administration,youtuber FROM `ranks` WHERE `uuid` = '" + player.getUniqueId() + "'");
            PreparedStatement badges = connection.prepareStatement("SELECT badge FROM `badges` WHERE `uuid` = '" + player.getUniqueId() + "'");
            ResultSet checkRanks = preparedStatement.executeQuery();
            ResultSet checkBadges = badges.executeQuery();

            if (checkRanks.next()) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    donor = resultSet.getInt(1);
                    support = resultSet.getInt(2);
                    moderation = resultSet.getInt(3);
                    admin = resultSet.getInt(4);
                    youtuber = resultSet.getInt(5);
                }

            } else {
                PreparedStatement insert = connection.prepareStatement("INSERT INTO `ranks`(`uuid`, `donor`, `support`, `moderation`, `administration`, `retirement`, `youtuber`, `builder`) VALUES ('" + player.getUniqueId() + "', 0, 0, 0, 0, 0, 0, 0)");
                PreparedStatement insert1 = connection.prepareStatement("INSERT INTO `badges`(`uuid`, `badge`) VALUES ('" + player.getUniqueId() + "', 0)");
                insert.execute();
                insert1.execute();

                donor = 0;
                support = 0;
                moderation = 0;
                admin = 0;
                youtuber = 0;
            }

            if (checkBadges.next()) {
                events = checkBadges.getInt(1);
            }

            Rank.getDonorID().put(player.getUniqueId(), donor);
            Rank.getSupportID().put(player.getUniqueId(), support);
            Rank.getModerationID().put(player.getUniqueId(), moderation);
            Rank.getAdminID().put(player.getUniqueId(), admin);
            Rank.getYoutuberID().put(player.getUniqueId(), youtuber);
            Rank.getEventID().put(player.getUniqueId(), events);

            Tab.update((Player) player);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}