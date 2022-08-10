package me.azzy.rank;

import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.UUID;

public class Rank {

    private static HashMap<UUID, Integer> donorID = new HashMap<>();
    private static HashMap<UUID, Integer> supportID = new HashMap<>();
    private static HashMap<UUID, Integer> moderationID = new HashMap<>();
    private static HashMap<UUID, Integer> adminID = new HashMap<>();
    private static HashMap<UUID, Integer> youtuberID = new HashMap<>();
    private static HashMap<UUID, Integer> eventID = new HashMap<>();

    public static HashMap<UUID, Integer> getDonorID() {
        return donorID;
    }

    public static HashMap<UUID, Integer> getSupportID() {
        return supportID;
    }

    public static HashMap<UUID, Integer> getModerationID() {
        return moderationID;
    }

    public static HashMap<UUID, Integer> getAdminID() {
        return adminID;
    }

    public static HashMap<UUID, Integer> getYoutuberID() {
        return youtuberID;
    }

    public static HashMap<UUID, Integer> getEventID() {
        return eventID;
    }
}