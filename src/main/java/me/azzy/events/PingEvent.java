package me.azzy.events;

import me.azzy.DiamondFire;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        String textToTranslate = DiamondFire.getMessagesConfig().getString("motd");
        assert textToTranslate != null;
        event.setMotd(ChatColor.translateAlternateColorCodes('&', textToTranslate));
    }
}
