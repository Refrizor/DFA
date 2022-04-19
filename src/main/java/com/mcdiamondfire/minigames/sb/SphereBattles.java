package com.mcdiamondfire.minigames.sb;

import com.mcdiamondfire.DiamondFire;
import com.mcdiamondfire.utils.Messages;
import com.mcdiamondfire.utils.PlayerUtils;
import com.mcdiamondfire.utils.WorldGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SphereBattles {

    private static final String name = "spherebattles";
    private static final List<UUID> queue = new ArrayList<>();
    private static final List<UUID> ingame = new ArrayList<>();
    private static final HashMap<UUID, Integer> bowLimits = new HashMap<>();
    static int timer = 10;
    static int id;

    public static void startCountdown(Player player) {
        WorldGenerator.duplicateWorld("sb_unloaded", name);
        WorldGenerator.load(name);

        BukkitScheduler scheduler = Bukkit.getScheduler();
        if (getQueue().size() >= 1)
            id = scheduler.scheduleSyncRepeatingTask(DiamondFire.getInstance(), new Runnable() {
                @Override
                public void run() {

                    //PlayerUtils.setBossBar(player, ChatColor.GREEN + String.valueOf(timer), BarColor.BLUE, BarStyle.SOLID, 1F, false, false, false);

                    if(timer == 1) {
                        alertSound(ChatColor.AQUA + "Sphere Battles is starting in " + ChatColor.RED + timer + ChatColor.AQUA + " second", Sound.BLOCK_TRIPWIRE_ATTACH);
                        timer--;
                    }

                    if(timer >= 2) {
                        alertSound(ChatColor.AQUA + "Sphere Battles is starting in " + ChatColor.RED + timer + ChatColor.AQUA + " seconds", Sound.BLOCK_TRIPWIRE_ATTACH);
                        timer --;
                    }

                    if(timer == 0){
                        scheduler.cancelTask(id);

                        id = scheduler.scheduleSyncDelayedTask(DiamondFire.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                startGame();

                                timer = 10;
                            }
                        }, 20L);
                    }
                }
            }, 0L, 20L);
    }

    public static void startGame(){
        for(Player all : Bukkit.getOnlinePlayers()){
            if(getQueue().contains(all.getUniqueId())){
                Teams.addAll(all);
                getBowLimits().put(all.getUniqueId(), DiamondFire.getFileConfig().getInt("bow_limits"));
                getQueue().clear();
                all.getInventory().clear();
                PlayerUtils.bossBar.removePlayer(all);
            }

            if(getIngame().contains(all.getUniqueId())){
                PlayerUtils.playSound(all, Sound.BLOCK_BREWING_STAND_BREW, 10F);

                if(Teams.inTeam(all) == Teams.Types.BLUE){
                    all.teleport(new Location(Bukkit.getWorld(name), -18.399, 43.00000, 8.525));
                    all.sendMessage(Messages.BLUE.getMessage());
                    PlayerUtils.sendTitle(all, ChatColor.BLUE + "Blue", ChatColor.YELLOW + "You are on the blue team!");
                }else{
                    all.teleport(new Location(Bukkit.getWorld(name), 122.340, 44.00000, 8.512));
                    all.sendMessage(Messages.RED.getMessage());
                    PlayerUtils.sendTitle(all, ChatColor.RED + "Red", ChatColor.YELLOW + "You are on the red team!");

                }
            }
        }

        Teams.sort();
    }

    private static void alert(String message) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (getQueue().contains(all.getUniqueId())) {
                all.sendMessage(message);
            }
        }
    }

    private static void alertSound(String message, Sound sound){
        for(Player all : Bukkit.getOnlinePlayers()){
            if(getQueue().contains(all.getUniqueId())){
                all.sendMessage(message);
                all.playSound(all.getLocation(), sound, 10F, 1F);
            }
        }
    }

    public static List<UUID> getQueue() {
        return queue;
    }

    public static boolean inQueue(Player player){
        return getQueue().contains(player.getUniqueId());
    }

    public static HashMap<UUID, Integer> getBowLimits() {
        return bowLimits;
    }

    public static List<UUID> getIngame() {
        return ingame;
    }
}
