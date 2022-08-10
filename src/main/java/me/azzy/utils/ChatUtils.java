package me.azzy.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class ChatUtils {

    public static BaseComponent[] builder(String hex, String text){
        return new ComponentBuilder().append(text).color(net.md_5.bungee.api.ChatColor.of(hex)).create();
    }
}
