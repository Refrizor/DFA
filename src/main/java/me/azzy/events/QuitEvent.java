package me.azzy.events;

import me.azzy.PlayerData;
import me.azzy.rank.Branch;
import me.azzy.rank.Rank;
import me.azzy.rank.Tab;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        PlayerData.getLobby().remove(player.getUniqueId());
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        new Tab().removeEntries(player);

        int events = PlayerData.getBranchID(Branch.EVENTS, player);
        int admin = PlayerData.getBranchID(Branch.ADMINISTRATION, player);
        int moderation = PlayerData.getBranchID(Branch.MODERATION, player);
        int support = PlayerData.getBranchID(Branch.SUPPORT, player);
        int donor = PlayerData.getBranchID(Branch.DONOR, player);
        int youtuber = PlayerData.getBranchID(Branch.YOUTUBER, player);

        event.setQuitMessage(PlayerData.getPrimaryRank(player, true) + ChatColor.GRAY + player.getName() + " left.");

        Rank.getDonorID().remove(player.getUniqueId());
        Rank.getSupportID().remove(player.getUniqueId());
        Rank.getModerationID().remove(player.getUniqueId());
        Rank.getAdminID().remove(player.getUniqueId());
        Rank.getYoutuberID().remove(player.getUniqueId());
        Rank.getEventID().remove(player.getUniqueId());

        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

    }
}