package com.mcdiamondfire.rank;

import com.mcdiamondfire.DiamondFire;
import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.commands.CommandNick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

import static com.mcdiamondfire.rank.Rank.*;

public class Tab {

    static Scoreboard scoreboard = DiamondFire.getInstance().getServer().getScoreboardManager().getMainScoreboard();;
    public static Team ownerTeam = scoreboard.registerNewTeam("0-Owner");
    public static Team adminTeam = scoreboard.registerNewTeam("1-Admin");
    public static Team devTeam = scoreboard.registerNewTeam("2-Dev");
    public static Team srModTeam = scoreboard.registerNewTeam("3-SrMod");
    public static Team modTeam = scoreboard.registerNewTeam("4-Mod");
    public static Team jrModTeam = scoreboard.registerNewTeam("5-JrMod");
    public static Team expertTeam = scoreboard.registerNewTeam("6-SrHelper");
    public static Team helperTeam = scoreboard.registerNewTeam("7-Helper");
    public static Team jrHelperTeam = scoreboard.registerNewTeam("8-JrHelper");
    public static Team youtuberTeam = scoreboard.registerNewTeam("9-YouTuber");
    public static Team overlordTeam = scoreboard.registerNewTeam("10-Overlord");
    public static Team mythicTeam = scoreboard.registerNewTeam("11-Mythic");
    public static Team emperorTeam = scoreboard.registerNewTeam("12-Emperor");
    public static Team nobleTeam = scoreboard.registerNewTeam("13-Noble");
    public static Team noneTeam = scoreboard.registerNewTeam("14-None");
    public void removeEntries(Player player) {
        ownerTeam.removeEntry(player.getName());
        adminTeam.removeEntry(player.getName());
        devTeam.removeEntry(player.getName());
        srModTeam.removeEntry(player.getName());
        modTeam.removeEntry(player.getName());
        jrModTeam.removeEntry(player.getName());
        expertTeam.removeEntry(player.getName());
        helperTeam.removeEntry(player.getName());
        jrHelperTeam.removeEntry(player.getName());
        youtuberTeam.removeEntry(player.getName());
        overlordTeam.removeEntry(player.getName());
        mythicTeam.removeEntry(player.getName());
        emperorTeam.removeEntry(player.getName());
        nobleTeam.removeEntry(player.getName());
        noneTeam.removeEntry(player.getName());
    }

    public static void initTeams() {

        Team[] staffTeam = {jrHelperTeam, helperTeam, expertTeam, jrModTeam, modTeam, srModTeam, devTeam, adminTeam, ownerTeam};
        Team[] regularTeam = {noneTeam, youtuberTeam, nobleTeam, emperorTeam, mythicTeam, overlordTeam};

        for(Team team : staffTeam){
            team.setColor(ChatColor.AQUA);
        }
        for(Team team : regularTeam){
            team.setColor(ChatColor.WHITE);
        }

        ownerTeam.setPrefix(Prefixes.OWNER.getTag() + " ");
        adminTeam.setPrefix(Prefixes.ADMIN.getTag() + " ");
        devTeam.setPrefix(Prefixes.DEV.getTag() + " ");
        srModTeam.setPrefix(Prefixes.SRMOD.getTag() + " ");
        modTeam.setPrefix(Prefixes.MOD.getTag() + " ");
        jrModTeam.setPrefix(Prefixes.JRMOD.getTag() + " ");
        expertTeam.setPrefix(Prefixes.SRHELPER.getTag() + " ");
        helperTeam.setPrefix(Prefixes.HELPER.getTag() + " ");
        jrHelperTeam.setPrefix(Prefixes.JRHELPER.getTag() + " ");
        youtuberTeam.setPrefix(Prefixes.YOUTUBER.getShortTag() + " ");
        overlordTeam.setPrefix(Prefixes.OVERLORD.getShortTag() + " ");
        mythicTeam.setPrefix(Prefixes.MYTHIC.getShortTag() + " ");
        emperorTeam.setPrefix(Prefixes.EMPEROR.getShortTag() + " ");
        nobleTeam.setPrefix(Prefixes.NOBLE.getShortTag() + " ");
    }

    public static void update(Player player) {
        int events = PlayerData.getBranchID(Branch.EVENTS, player);
        int admin = PlayerData.getBranchID(Branch.ADMINISTRATION, player);
        int moderation = PlayerData.getBranchID(Branch.MODERATION, player);
        int support = PlayerData.getBranchID(Branch.SUPPORT, player);
        int donor = PlayerData.getBranchID(Branch.DONOR, player);
        int youtuber = PlayerData.getBranchID(Branch.YOUTUBER, player);

        //Scoreboard scoreboard = Tab.getScoreboards().get(player);

        switch (admin) {
            case 3:
                ownerTeam.addEntry(player.getName());
                break;
            case 2:
                adminTeam.addEntry(player.getName());
                break;
            case 1:
                devTeam.addEntry(player.getName());
                break;
        }

        switch (moderation) {
            case 3:
                if (admin == 0) {
                    srModTeam.addEntry(player.getName());
                }
                break;

            case 2:
                if (admin == 0) {
                    modTeam.addEntry(player.getName());
                }
                break;

            case 1:
                if (admin == 0) {
                    jrModTeam.addEntry(player.getName());
                }
                break;
        }

        switch (support) {
            case 3:
                if (admin == 0) {
                    if (moderation == 0) {
                        expertTeam.addEntry(player.getName());
                    }
                }

                break;

            case 2:
                if (admin == 0) {
                    if (moderation == 0) {
                        helperTeam.addEntry(player.getName());
                    }
                }

                break;

            case 1:
                if (admin == 0) {
                    if (moderation == 0) {
                        jrHelperTeam.addEntry(player.getName());
                    }
                }

                break;
        }

        switch (donor) {
            case 4:
                if (admin == 0 && moderation == 0 && support == 0 && youtuber == 0 || CommandNick.getNickRank().containsKey(player.getUniqueId()) && CommandNick.getNickRank().containsValue(Prefixes.OVERLORD.getTag())) {
                    overlordTeam.addEntry(player.getName());
                }
                break;

            case 3:
                if (admin == 0 && moderation == 0 && support == 0 && youtuber == 0 || CommandNick.getNickRank().containsKey(player.getUniqueId()) && CommandNick.getNickRank().containsValue(Prefixes.MYTHIC.getTag())) {
                    mythicTeam.addEntry(player.getName());
                }
                break;

            case 2:
                if (admin == 0 && moderation == 0 && support == 0 && youtuber == 0 || CommandNick.getNickRank().containsKey(player.getUniqueId()) && CommandNick.getNickRank().containsValue(Prefixes.EMPEROR.getTag())) {
                    emperorTeam.addEntry(player.getName());
                }
                break;

            case 1:
                if (admin == 0 && moderation == 0 && support == 0 && youtuber == 0 || CommandNick.getNickRank().containsKey(player.getUniqueId()) && CommandNick.getNickRank().containsValue(Prefixes.NOBLE.getTag())) {
                    nobleTeam.addEntry(player.getName());
                }
                break;

            case 0:
                if (admin == 0 && moderation == 0 && support == 0 && youtuber == 0 || CommandNick.getNickRank().containsKey(player.getUniqueId()) && CommandNick.getNickRank().containsValue("")) {
                    noneTeam.addEntry(player.getName());
                }
                break;
        }

        switch (youtuber) {
            case 1:
                if (admin == 0 && moderation == 0 && support == 0) {
                    youtuberTeam.addEntry(player.getName());
                }
                break;
        }
    }
}
