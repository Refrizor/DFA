package me.azzy.rank;

import me.azzy.DatabaseHandler;
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

            PreparedStatement ranks = connection.prepareStatement("SELECT donor,support,moderation,administration,youtuber FROM `ranks` WHERE `uuid` = '" + player.getUniqueId() + "'");
            PreparedStatement badges = connection.prepareStatement("SELECT badge FROM `badges` WHERE `uuid` = '" + player.getUniqueId() + "'");
            PreparedStatement username = connection.prepareStatement("SELECT `username` FROM `players` WHERE `uuid` = '" + player.getUniqueId() + "'");
            ResultSet checkRanks = ranks.executeQuery();
            ResultSet checkBadges = badges.executeQuery();
            ResultSet checkUsername = username.executeQuery();

            if (checkRanks.next()) {
                ResultSet resultSet = ranks.executeQuery();

                while (resultSet.next()) {
                    donor = resultSet.getInt(1);
                    support = resultSet.getInt(2);
                    moderation = resultSet.getInt(3);
                    admin = resultSet.getInt(4);
                    youtuber = resultSet.getInt(5);
                }

                if(checkUsername.next()){
                    String usernameString = checkUsername.getString(1);
                    if(!(player.getName().equalsIgnoreCase(usernameString))){
                        PreparedStatement changeName = connection.prepareStatement("UPDATE `players` SET `username` = '" + player.getName() + "' WHERE `uuid` = '" + player.getUniqueId() + "'");
                        changeName.execute();
                    }
                }

            } else {
                PreparedStatement insertRanks = connection.prepareStatement("INSERT INTO `ranks`(`uuid`, `donor`, `support`, `moderation`, `administration`, `retirement`, `youtuber`, `builder`) VALUES ('" + player.getUniqueId() + "', 0, 0, 0, 0, 0, 0, 0)");
                PreparedStatement insertBadges = connection.prepareStatement("INSERT INTO `badges`(`uuid`, `badge`) VALUES ('" + player.getUniqueId() + "', 0)");
                PreparedStatement insertPlayers = connection.prepareStatement("INSERT INTO `players`(`username`, `uuid`, `shards`) VALUES ('" + player.getName() + "', '" + player.getUniqueId() + "', 50)");
                insertRanks.execute();
                insertBadges.execute();
                insertPlayers.execute();

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