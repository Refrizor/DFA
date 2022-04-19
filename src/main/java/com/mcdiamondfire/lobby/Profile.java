package com.mcdiamondfire.lobby;

import com.mcdiamondfire.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Profile {

    public void deploy(Player player) {
        PlayerData playerData = new PlayerData();
        final ArrayList<String> newRanks = playerData.getRankArray(player);

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : newRanks) {
            stringBuilder.append(string + " ");
        }
        player.sendMessage(ChatColor.YELLOW + "Profile\n \n" + ChatColor.WHITE + "Ranks: " + stringBuilder.toString() + "\n");
    }
}
