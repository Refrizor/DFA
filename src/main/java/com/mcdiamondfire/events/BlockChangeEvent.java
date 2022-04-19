package com.mcdiamondfire.events;

import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class BlockChangeEvent implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void on(EntityChangeBlockEvent event) {
        if (event.getEntity() instanceof FallingBlock && event.getBlock().getType() == Material.GREEN_CONCRETE_POWDER)
            event.setCancelled(true);
    }
}