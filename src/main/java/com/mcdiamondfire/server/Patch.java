package com.mcdiamondfire.server;

import net.md_5.bungee.api.ChatColor;

public enum Patch {
    LATEST("INDEV TESTING"),
    HEADER(ChatColor.of("#82c7f4") + "Current patch: " + ChatColor.of("#71ffe0")),
    RELEASE(ChatColor.of("#669cc0") + "Released on " + ChatColor.of("#fd8a6d")),
    IMPORTANT(ChatColor.of("#82a1f5") + "\uD83D\uDD25 " + ChatColor.RESET),
    ADD(ChatColor.of("#82f5a3") + "▶ " + ChatColor.RESET),
    FIX(ChatColor.of("#f5ee82") + "◆ " + ChatColor.RESET),
    REMOVE(ChatColor.RED + "✘ " + ChatColor.RESET),
    MAIN_COLOR(String.valueOf(ChatColor.of("#dbe0ff"))),
    HEADER_COLOR(String.valueOf(ChatColor.of("#71ffe0")));

    private final String type;
    Patch(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
