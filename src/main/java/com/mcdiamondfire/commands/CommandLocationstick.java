package com.mcdiamondfire.commands;

import com.mcdiamondfire.PlayerData;
import com.mcdiamondfire.rank.Branch;
import com.mcdiamondfire.utils.Messages;
import com.mcdiamondfire.utils.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CommandLocationstick implements CommandExecutor, Listener {

    private static final ArrayList<String> list = new ArrayList<>();
    private static final ItemStack stick = new ItemStack(Material.STICK);
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;

        if(player.isOp() || PlayerData.getBranchID(Branch.ADMINISTRATION, player) > 1){
            if(!list.contains(player.getName())){
                getList().add(player.getName());
                player.getInventory().addItem(getStick());
                player.sendMessage(ChatColor.GREEN + "Stick added!");
            }else{
                getList().remove(player.getName());
                player.getInventory().remove(getStick());
                player.sendMessage(ChatColor.GREEN + "Stick removed!");
            }
        }else{
            player.sendMessage(Messages.NO_PERM.getMessage());
        }
        return true;
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static ItemStack getStick() {
        ItemMeta itemMeta = stick.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Location stick");
        itemMeta.addEnchant(Enchantment.MENDING, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stick.setItemMeta(itemMeta);
        return stick;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        if(PlayerUtils.interactWith(event, getStick())){
            String separator = ChatColor.RESET + ", ";
            event.getPlayer().sendMessage("X: " + ChatColor.YELLOW + event.getClickedBlock().getX() + separator + ChatColor.YELLOW + event.getClickedBlock().getY() + separator + ChatColor.YELLOW + event.getClickedBlock().getZ());
            event.setCancelled(true);
        }
    }
}
