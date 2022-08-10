package me.azzy.server;

import me.azzy.DiamondFire;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Sidebar {

    static Scoreboard scoreboard = DiamondFire.getInstance().getServer().getScoreboardManager().getMainScoreboard();
    static Objective objective;

    public static void init(){
        objective = scoreboard.registerNewObjective("Test", "", "dummy");
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
    }

    public static void unload(){
        objective.unregister();
    }
}
