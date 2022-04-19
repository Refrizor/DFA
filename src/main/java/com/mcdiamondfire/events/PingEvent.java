package com.mcdiamondfire.events;

import com.mcdiamondfire.DiamondFire;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMotd(ChatColor.translateAlternateColorCodes('&', DiamondFire.getFileConfig().getString("motd")));
    }
}
