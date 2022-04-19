package com.mcdiamondfire.lobby;

import com.mcdiamondfire.DiamondFire;
import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.rank.Tab;
import com.mcdiamondfire.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Lobby {

    public static void active(Player player, boolean isActive) {
        if (isActive) {
            if (!PlayerData.inLobby(player)) {
                PlayerData.getLobby().add(player.getUniqueId());
                player.teleport(new Location(Bukkit.getWorld("lobby"), -0.497, -14.00000, 10.466));
                player.getInventory().clear();
                player.setGameMode(GameMode.ADVENTURE);

                Inventory inventory = player.getInventory();
                inventory.setItem(4, Itemdata.getGames());
                inventory.setItem(8, Itemdata.getInfo());
                inventory.setItem(0, Itemdata.getProfile(player));

                PlayerUtils.fullStats(player);
                PlayerUtils.setBossBar(player, ChatColor.AQUA + "Activities server", BarColor.RED, BarStyle.SOLID, 1F, false, false, false);
            }
        } else {
            PlayerData.getLobby().remove(player.getUniqueId());
        }
    }

    private static void setTarget(Player player, Location location) {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(DiamondFire.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.setCompassTarget(location);
            }
        }, 20L);
    }
}

/*
                Scoreboard scoreboard = Tab.getScoreboards().get(player);
                Objective objective = scoreboard.registerNewObjective("Test", "", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                String emote = ChatColor.DARK_RED + "◆";
                objective.setDisplayName(emote + ChatColor.AQUA + " DiamondFire " + emote);
                Score spacer = objective.getScore("     ");
                Score activities = objective.getScore(ChatColor.GREEN + "Activities");
                Score spacer2 = objective.getScore("");
                Score domain = objective.getScore(ChatColor.GOLD + "mcdiamondfire.com");

                spacer.setScore(4);
                activities.setScore(3);
                spacer2.setScore(2);
                domain.setScore(1);
 */
