package com.mcdiamondfire.commands;

import com.mcdiamondfire.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandRanks implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        PlayerData playerData = new PlayerData();
        final ArrayList<String> newRanks = playerData.getRankArray(player);

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : newRanks) {
            stringBuilder.append(string + " ");
        }

        player.sendMessage("Your ranks:\n" + stringBuilder.toString());
        return true;
    }
}