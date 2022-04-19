package com.mcdiamondfire.lobby.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public interface Menu {

    public void deployMenu(Player player);

    public void onClick(InventoryClickEvent event);

}
