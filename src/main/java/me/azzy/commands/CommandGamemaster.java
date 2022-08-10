package me.azzy.commands;

import me.azzy.DiamondFire;
import me.azzy.minigames.sb.SphereBattles;
import me.azzy.lobby.Lobby;
import me.azzy.utils.WorldGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class CommandGamemaster implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;

        if(length == 2){
            if(args[0].equalsIgnoreCase("start") && args[1].equalsIgnoreCase("sb")){
                SphereBattles.startCountdown(player);
            }
            if(args[0].equalsIgnoreCase("end") && args[1].equalsIgnoreCase("sb")){
                for(Player all : Bukkit.getServer().getOnlinePlayers()){
                    if(SphereBattles.getQueue().contains(all.getUniqueId()) || SphereBattles.getIngame().contains(all.getUniqueId())){
                        SphereBattles.getQueue().clear();
                        SphereBattles.getIngame().clear();
                        SphereBattles.getBowLimits().clear();
                        Lobby.active(all, true);
                        all.sendMessage(ChatColor.RED + "An admin reset the game.");

                        BukkitScheduler scheduler = Bukkit.getScheduler();
                        scheduler.scheduleSyncDelayedTask(DiamondFire.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                WorldGenerator.delete("spherebattles");
                            }
                        }, 20L);
                    }
                }
            }
        }
        return true;
    }
}
