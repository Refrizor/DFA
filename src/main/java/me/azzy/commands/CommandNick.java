package me.azzy.commands;

import me.azzy.PlayerData;
import me.azzy.rank.Prefixes;
import me.azzy.rank.Tab;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;


public class CommandNick implements CommandExecutor {

    private static final HashMap<UUID, String> nicks = new HashMap<>();
    private static final HashMap<UUID, String> nickRank = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;

        if(length == 0){
            player.sendMessage(ChatColor.RED + "/nick <name>");
        }

        if(length == 1){
            nicks.remove(player.getUniqueId());
            nickRank.remove(player.getUniqueId());
            if(args[0].equalsIgnoreCase("reset")){
                player.setPlayerListName(PlayerData.getPrimaryRank(player, true) + ChatColor.AQUA + " " + player.getName());
                for(Player all : Bukkit.getOnlinePlayers()){
                    Tab.update(all);
                }
            }else {

                nicks.put(player.getUniqueId(), args[0]);
                player.setPlayerListName(PlayerData.getName(player));
                nickRank.put(player.getUniqueId(), "");

                for (Player all : Bukkit.getOnlinePlayers()) {
                    Tab.update(all);
                }
            }
        }

        if(length == 2) {

            nicks.remove(player.getUniqueId());
            nickRank.remove(player.getUniqueId());
            nicks.put(player.getUniqueId(), args[0]);

            String arg = args[1];
            switch (arg){
                case "overlord":
                    player.setPlayerListName(Prefixes.OVERLORD.getShortTag() + ChatColor.RESET + " " + PlayerData.getName(player));
                    nickRank.put(player.getUniqueId(), Prefixes.OVERLORD.getTag());
                    break;
                case "mythic":
                    player.setPlayerListName(Prefixes.MYTHIC.getShortTag() + ChatColor.RESET + " " + PlayerData.getName(player));
                    nickRank.put(player.getUniqueId(), Prefixes.MYTHIC.getTag());
                    break;
                case "emperor":
                    player.setPlayerListName(Prefixes.EMPEROR.getShortTag() + ChatColor.RESET + " " + PlayerData.getName(player));
                    nickRank.put(player.getUniqueId(), Prefixes.EMPEROR.getTag());
                    break;
                case "noble":
                    player.setPlayerListName(Prefixes.NOBLE.getShortTag() + ChatColor.RESET + " " + PlayerData.getName(player));
                    nickRank.put(player.getUniqueId(), Prefixes.NOBLE.getTag());
                    break;
                case "none":
                    player.setPlayerListName(PlayerData.getName(player));
                    nickRank.put(player.getUniqueId(), "");
            }
            for(Player all : Bukkit.getOnlinePlayers()){
                Tab.update(all);
            }
        }

        return true;
    }

    public static HashMap<UUID, String> getNicks() {
        return nicks;
    }

    public static HashMap<UUID, String> getNickRank() {
        return nickRank;
    }
}
