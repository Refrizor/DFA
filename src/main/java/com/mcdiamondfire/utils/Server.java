package com.mcdiamondfire.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Server {

    public static void sendChatMessage(TextComponent badge, BaseComponent component){
        for(Player all : Bukkit.getOnlinePlayers()){
            all.spigot().sendMessage(badge, new TextComponent(component));
        }
    }
}
