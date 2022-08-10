package me.azzy.events;

import me.azzy.DiamondFire;
import me.azzy.PlayerData;
import me.azzy.rank.Branch;
import me.azzy.rank.Permission;
import me.azzy.rank.RankReceiver;
import me.azzy.server.Patch;
import me.azzy.lobby.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.azzy.utils.PlayerUtils.sendTitle;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        new RankReceiver().receive(player);
        Lobby.active(player, true);

        sendTitle(player, ChatColor.GOLD + "♦" + ChatColor.AQUA + " DiamondFire " + ChatColor.GOLD + "♦", ChatColor.GREEN + "Testsite");
        player.sendMessage(ChatColor.GREEN + "Current patch - " + Patch.HEADER_COLOR.getType() + Patch.LATEST.getType() + ChatColor.GREEN + ". For info: /patch");

        int donor = PlayerData.getBranchID(Branch.DONOR, player);

        new Permission().deployPermissions(player);

        for(Player all : Bukkit.getOnlinePlayers()){
            if(!all.isOp() && PlayerData.getVanished().contains(player.getName())){
                all.hidePlayer(DiamondFire.getInstance(), player);
            }
        }

        if(donor == 4){
            event.setJoinMessage(PlayerData.getPrimaryRank(player, true) + ChatColor.GRAY + player.getName() + " joined!");
        }else{
            event.setJoinMessage(PlayerData.getPrimaryRank(player, true) + ChatColor.GRAY + player.getName() + " joined.");
        }
    }
}