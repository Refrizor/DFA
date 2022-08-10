package me.azzy.events;

import me.azzy.PlayerData;
import me.azzy.chat.Filter;
import me.azzy.commands.CommandNick;
import me.azzy.rank.Branch;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        int events = PlayerData.getBranchID(Branch.EVENTS, player);
        int admin = PlayerData.getBranchID(Branch.ADMINISTRATION, player);
        int moderation = PlayerData.getBranchID(Branch.MODERATION, player);
        int support = PlayerData.getBranchID(Branch.SUPPORT, player);
        int donor = PlayerData.getBranchID(Branch.DONOR, player);
        int youtuber = PlayerData.getBranchID(Branch.YOUTUBER, player);

        if (!Filter.isChatLocked(player)) {
            Filter.setChatLock(player);

            if (!CommandNick.getNicks().containsKey(player.getUniqueId())) {
                event.setFormat(PlayerData.getBadge(player) + PlayerData.getRanks(player, true) + ChatColor.WHITE + player.getName() + ": " + event.getMessage());
            } else {
                event.setFormat(CommandNick.getNickRank().get(player.getUniqueId()) + ChatColor.WHITE + PlayerData.getName(player) + ": " + event.getMessage());
            }
        }else{
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Please wait before sending another message!");
        }
    }
}