package me.azzy.minigames.sb;

import me.azzy.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class Teams {

    private static final Map<UUID, Types> teams = new HashMap<>();
    private static final List<UUID> redTeam = new ArrayList<>();
    private static final List<UUID> blueTeam = new ArrayList<>();

    public static void addAll(Player player){
        SphereBattles.getIngame().add(player.getUniqueId());
        PlayerData.getLobby().remove(player.getUniqueId());
        Collections.shuffle(SphereBattles.getIngame());
    }

    public static void sort(){
        int i = 0;
        for(Player all : Bukkit.getOnlinePlayers()) {
            if(SphereBattles.getIngame().contains(all.getUniqueId())) {
                if (i < SphereBattles.getIngame().size() / 2) {
                    addToTeam(Types.RED, all);
                } else {
                    addToTeam(Types.BLUE, all);
                }
                i++;
            }
        }
    }

    public static void addToTeam(Types type, Player player) {

        switch (type) {
            case RED:
                teams.put(player.getUniqueId(), Types.RED);
                break;
            case BLUE:
                teams.put(player.getUniqueId(), Types.BLUE);
                break;
        }
    }

    public static Types inTeam(Player player){
        return teams.get(player.getUniqueId());
    }

    public static List<UUID> getBlue() {
        return blueTeam;
    }

    public static List<UUID> getRed() {
        return redTeam;
    }

    public static Map<UUID, Types> getTeams() {
        return teams;
    }

    enum Types{
        BLUE,
        RED;
    }
}