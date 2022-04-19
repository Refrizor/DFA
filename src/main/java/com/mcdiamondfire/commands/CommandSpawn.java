package com.mcdiamondfire.commands;

import com.mcdiamondfire.DiamondFire;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        List<Float> list = new ArrayList<>();
        list.add(DiamondFire.getInstance().getConfig().getFloatList("spawn_location").get(0));
        list.add(DiamondFire.getInstance().getConfig().getFloatList("spawn_location").get(1));
        list.add(DiamondFire.getInstance().getConfig().getFloatList("spawn_location").get(2));

        player.teleport(new Location(Bukkit.getWorld("lobby"), list.get(0), list.get(1), list.get(2)));
        return true;
    }
}
