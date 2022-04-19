package com.mcdiamondfire.chat;

import com.mcdiamondfire.DiamondFire;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Filter {

    private static final List<UUID> chatLock = new ArrayList<>();

    public static void setChatLock(Player player) {

        if(!player.isOp()){
            if (!getChatLock().contains(player.getUniqueId())) {
                getChatLock().add(player.getUniqueId());


                BukkitScheduler scheduler = Bukkit.getScheduler();
                scheduler.scheduleSyncDelayedTask(DiamondFire.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        chatLock.remove(player.getUniqueId());
                    }
                }, 20L);
            }
        }
    }

    public static List<UUID> getChatLock() {
        return chatLock;
    }

    public static boolean isChatLocked(Player player){
        return getChatLock().contains(player.getUniqueId());
    }
}
