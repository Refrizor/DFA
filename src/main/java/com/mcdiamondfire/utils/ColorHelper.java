package com.mcdiamondfire.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorHelper {

    private final int rgb;

    public ColorHelper(int r, int g, int b){
        this.rgb = r << 16 | g << 8 | b << 0;
    }

    public static String translate(String message) {
            Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
            Matcher matcher = pattern.matcher(message);

            while (matcher.find()) {
                String color = message.substring(matcher.start(), matcher.end());
                message = message.replace(color, ChatColor.of(color) + "");
                matcher = pattern.matcher(message);
            }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}