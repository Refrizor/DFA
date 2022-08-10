package me.azzy.rank;

import java.util.HashMap;
import java.util.UUID;

public enum Branch {
    EVENTS(Rank.getEventID()),
    ADMINISTRATION(Rank.getAdminID()),
    MODERATION(Rank.getModerationID()),
    SUPPORT(Rank.getSupportID()),
    DONOR(Rank.getDonorID()),
    YOUTUBER(Rank.getYoutuberID());

    private final HashMap<UUID,Integer> branch;

    Branch(HashMap<UUID,Integer> branch){
        this.branch = branch;
    }

    public HashMap<UUID,Integer> getBranch() {
        return branch;
    }
}
