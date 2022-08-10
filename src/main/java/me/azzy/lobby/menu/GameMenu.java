package me.azzy.lobby.menu;

import me.azzy.minigames.sb.SphereBattles;
import me.azzy.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GameMenu implements Menu, Listener {

    private static final String name = ChatColor.BLACK + "Game Menu";

    @Override
    public void deployMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9, name);

        inventory.setItem(4, Itemdata.getSphereBattles());

        player.openInventory(inventory);
    }

    @Override @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryView inventoryView = event.getView();
        Player player = (Player) event.getWhoClicked();
        if(PlayerUtils.clicked(event, inventoryView, name, Itemdata.getSphereBattles())){
            event.setCancelled(true);
            player.closeInventory();

            if(!SphereBattles.inQueue((Player) event.getWhoClicked())){
                SphereBattles.getQueue().add(player.getUniqueId());
                player.sendMessage(ChatColor.AQUA + "You entered the queue!");
                PlayerUtils.playSound(player, Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, 1F);
            }else{
                SphereBattles.getQueue().remove(player.getUniqueId());
                player.sendMessage(ChatColor.AQUA + "You left the queue!");
                PlayerUtils.playSound(player, Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, 0.4F);
            }
        }
    }

   protected static class Itemdata{
        private static final ItemStack sphereBattles = new ItemStack(Material.BOW);

        public static ItemStack getSphereBattles() {
            ItemMeta itemMeta = sphereBattles.getItemMeta();
            itemMeta.setDisplayName(ChatColor.GREEN + "Sphere Battles");
            sphereBattles.setItemMeta(itemMeta);
            return sphereBattles;
        }
    }
}
