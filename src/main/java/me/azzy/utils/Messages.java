package me.azzy.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Messages {
    NO_PERM(ChatColor.RED + "No permission."),

    BLUE(ChatColor.BLUE + "You are on the blue team!"),
    RED(ChatColor.RED + "You are on the red team!");

    private final String message;

    Messages(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
