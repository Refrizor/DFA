package me.azzy.commands;

import me.azzy.PlayerData;
import me.azzy.minigames.sb.SphereBattles;
import me.azzy.rank.Branch;
import me.azzy.rank.RankReceiver;
import me.azzy.utils.Messages;
import me.azzy.utils.WorldGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdmin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || PlayerData.getBranchID(Branch.ADMINISTRATION, player) >1) {
            int length = args.length;

            if (length == 0) {
                player.sendMessage(ChatColor.AQUA + "In-game admin panel section");
                player.sendMessage("");
                player.sendMessage(ChatColor.YELLOW + "Arguments:\n" + ChatColor.GRAY + "- reset");
            }else {

                if (args[0].equalsIgnoreCase("reset")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        new RankReceiver().receive((Player) all);
                    }
                }

                if(args[0].equalsIgnoreCase("sb")){
                    SphereBattles.getQueue().add(player.getUniqueId());
                }

                if(args[0].equalsIgnoreCase("gen")){
                    WorldGenerator.create(WorldType.FLAT, "lobby");
                }

                if(args[0].equalsIgnoreCase("load")){
                    WorldGenerator.load("lobby");
                }

                if(args[0].equalsIgnoreCase("tpworld")){
                    player.teleport(new Location(Bukkit.getWorld("lobby"), 1, 100, 1));
                }
            }
        }else{
            player.sendMessage(Messages.NO_PERM.getMessage());
        }
        return true;
    }
}
