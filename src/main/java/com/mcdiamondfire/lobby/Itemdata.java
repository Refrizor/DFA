package com.mcdiamondfire.lobby;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Itemdata {

    private static final ItemStack info = new ItemStack(Material.KNOWLEDGE_BOOK);
    private static final ItemStack games = new ItemStack(Material.DIAMOND);
    private static final ItemStack compass = new ItemStack(Material.COMPASS);
    private static final ItemStack profile = new ItemStack(Material.PLAYER_HEAD);

    public static ItemStack getInfo() {
        ItemMeta itemMeta = info.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA + "Information");
        info.setItemMeta(itemMeta);
        return info;
    }

    public static ItemStack getGames() {
        ItemMeta itemMeta = games.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Game sessions");
        games.setItemMeta(itemMeta);
        return games;
    }

    public static ItemStack getCompass() {
        ItemMeta itemMeta = compass.getItemMeta();
        itemMeta.setDisplayName(ChatColor.MAGIC + "D  F    A");
        itemMeta.addEnchant(Enchantment.MENDING, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        compass.setItemMeta(itemMeta);
        return compass;
    }

    public static ItemStack getProfile(OfflinePlayer player) {
        ItemMeta itemMeta = profile.getItemMeta();
        SkullMeta skullMeta = (SkullMeta) itemMeta;
        skullMeta.setOwningPlayer(player);
        itemMeta.setDisplayName(ChatColor.YELLOW + "Profile");
        profile.setItemMeta(itemMeta);
        return profile;
    }
}
