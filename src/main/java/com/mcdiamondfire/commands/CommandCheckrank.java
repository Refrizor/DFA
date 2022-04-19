package com.mcdiamondfire.commands;

import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.rank.Branch;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCheckrank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int admin = PlayerData.getBranchID(Branch.ADMINISTRATION, player);

        player.sendMessage("" + + admin);
        return true;
    }
}
