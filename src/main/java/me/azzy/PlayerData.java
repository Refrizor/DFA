package me.azzy;

import me.azzy.rank.Branch;
import me.azzy.rank.Prefixes;
import me.azzy.rank.Rank;
import me.azzy.commands.CommandNick;
import me.azzy.utils.ColorHelper;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerData {

    private static final ArrayList<String> vanished = new ArrayList<>();

    public static int getBranchID(Branch branch, Player player){
        return branch.getBranch().get(player.getUniqueId());
    }

//    public static TextComponent getBadge(Player player){
//        int level = Rank.getEventID().get(player.getUniqueId());
//        switch (level){
//            case 2:
//                return PlayerUtils.hoverText(net.md_5.bungee.api.ChatColor.of("#ff0000") + "⛨", ChatColor.AQUA + "Server developer");
//            case 1:
//                return PlayerUtils.hoverText(ChatColor.GOLD + "⛨", ChatColor.AQUA + "Events staff member");
//        }
//        return null;
//    }

        public static String getBadge(Player player){
        int level = Rank.getEventID().get(player.getUniqueId());
        switch (level){
            case 3:
                return ColorHelper.translate("#69a1ff") + "\uD83D\uDDE1 Dev ";
            case 1:
                return ColorHelper.translate("#ffdf69") + "⛨ ";
            case 0:
                return "";
        }
        return null;
    }

    public static String getName(Player player){
        if(CommandNick.getNicks().containsKey(player.getUniqueId())){
            return CommandNick.getNicks().get(player.getUniqueId());
        }else{
            return player.getName();
        }
    }

    public static String getPrimaryRank(Player player, boolean longTag){
        int admin = getBranchID(Branch.ADMINISTRATION, player);
        int moderation = getBranchID(Branch.MODERATION, player);
        int support = getBranchID(Branch.SUPPORT, player);
        int youtuber = getBranchID(Branch.YOUTUBER, player);
        int donor = getBranchID(Branch.DONOR, player);

        switch(admin){
            case 3:
                return Prefixes.OWNER.getTag();
            case 2:
                return Prefixes.ADMIN.getTag();
            case 1:
                return Prefixes.DEV.getTag();
        }

        switch (moderation){
            case 3:
                if(admin == 0){
                    return Prefixes.SRMOD.getTag();
                }
            case 2:
                if(admin == 0){
                    return Prefixes.MOD.getTag();
                }
            case 1:
                if(admin == 0) {
                    return Prefixes.JRMOD.getTag();
                }
        }

        switch (support){
            case 3:
                if(admin == 0 && moderation == 0){
                    return Prefixes.SRHELPER.getTag();
                }
            case 2:
                if(admin == 0 && moderation == 0){
                    return Prefixes.HELPER.getTag();
                }
            case 1:
                if(admin == 0 && moderation == 0){
                    return Prefixes.JRHELPER.getTag();
                }
        }

        switch (donor) {
            case 4:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.OVERLORD.getTag();
                    } else return Prefixes.OVERLORD.getShortTag();
                }
            case 3:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.MYTHIC.getTag();
                    } else return Prefixes.MYTHIC.getShortTag();
                }
            case 2:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.EMPEROR.getTag();
                    } else return Prefixes.EMPEROR.getShortTag();
                }
            case 1:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.NOBLE.getTag();
                    } else return Prefixes.NOBLE.getShortTag();
                }
        }

        switch (youtuber){
            case 1:
                if(admin == 0 && moderation == 0){
                    if(longTag){
                        return Prefixes.YOUTUBER.getTag();
                    }else return Prefixes.YOUTUBER.getShortTag();
                }
        }

        if(admin == 0 && moderation == 0 && support == 0 && donor == 0 && youtuber == 0){
            return "";
        }

        return null;
    }

    public static String getShortRank(Player player, boolean longTag) {
        int donor = getBranchID(Branch.DONOR, player);


        switch (donor) {
            case 4:
                if (longTag) {
                    return Prefixes.OVERLORD.getTag();
                } else return Prefixes.OVERLORD.getShortTag();

            case 3:

                if (longTag) {
                    return Prefixes.MYTHIC.getTag();
                } else return Prefixes.MYTHIC.getShortTag();

            case 2:

                if (longTag) {
                    return Prefixes.EMPEROR.getTag();
                } else return Prefixes.EMPEROR.getShortTag();

            case 1:

                if (longTag) {
                    return Prefixes.NOBLE.getTag();
                } else return Prefixes.NOBLE.getShortTag();

            case 0:
                return "";
        }

        return null;
    }

    public static String getRanks(Player player, boolean longTag){
        int admin = getBranchID(Branch.ADMINISTRATION, player);
        int moderation = getBranchID(Branch.MODERATION, player);
        int support = getBranchID(Branch.SUPPORT, player);
        int youtuber = getBranchID(Branch.YOUTUBER, player);
        int donor = getBranchID(Branch.DONOR, player);

        switch(admin){
            case 3:
                return Prefixes.OWNER.getTag();
            case 2:
                return Prefixes.ADMIN.getTag();
            case 1:
                return Prefixes.DEV.getTag();
        }

        switch (moderation){
            case 3:
                if(admin == 0){
                    return Prefixes.SRMOD.getTag() + getShortRank(player, false);
                }
            case 2:
                if(admin == 0){
                    return Prefixes.MOD.getTag() + getShortRank(player, false);
                }
            case 1:
                if(admin == 0) {
                    return Prefixes.JRMOD.getTag() + getShortRank(player, false);
                }
        }

        switch (support){
            case 3:
                if(admin == 0 && moderation == 0){
                    return Prefixes.SRHELPER.getTag() + getShortRank(player, false);
                }
            case 2:
                if(admin == 0 && moderation == 0){
                    return Prefixes.HELPER.getTag() + getShortRank(player, false);
                }
            case 1:
                if(admin == 0 && moderation == 0){
                    return Prefixes.JRHELPER.getTag() + getShortRank(player, false);
                }
        }

        switch (donor) {
            case 4:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.OVERLORD.getTag();
                    } else return Prefixes.OVERLORD.getShortTag();
                }
            case 3:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.MYTHIC.getTag();
                    } else return Prefixes.MYTHIC.getShortTag();
                }
            case 2:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.EMPEROR.getTag();
                    } else return Prefixes.EMPEROR.getShortTag();
                }
            case 1:
                if (admin == 0 & moderation == 0 & support == 0) {
                    if (longTag) {
                        return Prefixes.NOBLE.getTag();
                    } else return Prefixes.NOBLE.getShortTag();
                }
        }

        switch (youtuber){
            case 1:
                if(admin == 0 && moderation == 0){
                    if(longTag){
                        return Prefixes.YOUTUBER.getTag();
                    }else return Prefixes.YOUTUBER.getShortTag();
                }
        }

        if(admin == 0 && moderation == 0 && support == 0 && donor == 0 && youtuber == 0){
            return "";
        }

        return null;
    }

    private final ArrayList<String> ranks = new ArrayList<>();
    public ArrayList<String> getRankArray(Player player) {
        int admin = getBranchID(Branch.ADMINISTRATION, player);
        int moderation = getBranchID(Branch.MODERATION, player);
        int support = getBranchID(Branch.SUPPORT, player);
        int youtuber = getBranchID(Branch.YOUTUBER, player);
        int donor = getBranchID(Branch.DONOR, player);

        switch (admin) {
            case 3:
                ranks.add(Prefixes.OWNER.getTag());
                break;
            case 2:
                ranks.add(Prefixes.ADMIN.getTag());
                break;
            case 1:
                ranks.add(Prefixes.DEV.getTag());
                break;
        }

        switch (moderation) {
            case 3:
                ranks.add(Prefixes.SRMOD.getTag());
                break;

            case 2:
                ranks.add(Prefixes.MOD.getTag());
                break;
            case 1:
                ranks.add(Prefixes.JRMOD.getTag());
        }

        switch (support) {
            case 3:
                ranks.add(Prefixes.SRHELPER.getTag());
                break;
            case 2:
                ranks.add(Prefixes.HELPER.getTag());
                break;
            case 1:
                ranks.add(Prefixes.JRHELPER.getTag());
                break;
        }

        switch (donor) {
            case 4:
                ranks.add(Prefixes.OVERLORD.getTag());
                break;
            case 3:
                ranks.add(Prefixes.MYTHIC.getTag());
                break;
            case 2:
                ranks.add(Prefixes.EMPEROR.getTag());
                break;
            case 1:
                ranks.add(Prefixes.NOBLE.getTag());
                break;
        }

        switch (youtuber) {
            case 1:
                ranks.add(Prefixes.YOUTUBER.getTag());
                break;
        }
        return ranks;
    }


    private static final List<UUID> lobby = new ArrayList<>();

    public static boolean inLobby(Player player){
        return getLobby().contains(player.getUniqueId());
    }

    public static List<UUID> getLobby() {
        return lobby;
    }

    public static ArrayList<String> getVanished() {
        return vanished;
    }
}
