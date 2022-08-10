package me.azzy.utils;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerUtils {

    public static void sendSidebar(Player player) {
        String emote = ChatColor.DARK_RED + "♦";

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Test", "", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(emote + ChatColor.AQUA + " DiamondFire " + emote);
        Score score = objective.getScore("     ");
        Score score1 = objective.getScore(ChatColor.GREEN + "Testsite");
        Score score2 = objective.getScore(ChatColor.RESET + " ");
        Score score3 = objective.getScore(ChatColor.GOLD + "mcdiamondfire.com");

        score.setScore(4);
        score1.setScore(3);
        score2.setScore(2);
        score3.setScore(1);

        player.setScoreboard(scoreboard);
    }

    public static void fullStats(Player player) {
        player.setHealth(20D);
        player.setFoodLevel(20);
        player.setExp(0F);
    }

    public static TextComponent hoverText(String message, String hover) {
        TextComponent tc = new TextComponent(message);
        HoverEvent he = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hover));
        tc.setHoverEvent(he);
        return tc;
    }

    public static boolean interactWith(PlayerInteractEvent event, ItemStack itemStack) {
        if (event.getHand() == EquipmentSlot.HAND) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                return event.getItem().getType() == itemStack.getType() && event.getItem().getItemMeta().equals(itemStack.getItemMeta());
            }
        }
        return false;
    }

    public static boolean clicked(InventoryClickEvent event, InventoryView inventoryView, String title, ItemStack itemStack) {
        if (inventoryView.getTitle().equalsIgnoreCase(title)) {
            return event.getCurrentItem().equals(itemStack);
        }
        return false;
    }

    public static BossBar bossBar;

    public static void setBossBar(Player player, String title, BarColor barColor, BarStyle barStyle, Float progress, boolean bossMusic, boolean fog, boolean sky) {
        bossBar = Bukkit.createBossBar(title, barColor, barStyle);
        bossBar.addPlayer(player);
        bossBar.setProgress(progress);

        if (bossMusic) {
            bossBar.addFlag(BarFlag.PLAY_BOSS_MUSIC);
        }
        if(fog) {
            bossBar.addFlag(BarFlag.CREATE_FOG);
        }
        if(sky) {
            bossBar.addFlag(BarFlag.DARKEN_SKY);
        }
    }

    public static void sendTitle(Player player, String title, String subtitle){
        player.sendTitle(title, subtitle, 20, 60, 20);
    }

    public static void playSound(Player player, Sound sound, Float pitch){
        player.playSound(player.getLocation(), sound, 10F, pitch);
    }

    public static void sendGlobalMessage(String message){

    }

    public static String getColor(AsyncPlayerChatEvent event){
        return null;
    }
}