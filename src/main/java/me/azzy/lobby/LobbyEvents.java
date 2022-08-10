package me.azzy.lobby;

import me.azzy.PlayerData;
import me.azzy.lobby.menu.GameMenu;
import me.azzy.rank.Branch;
import me.azzy.utils.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LobbyEvents implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (PlayerData.inLobby(event.getPlayer())) {
            if (PlayerUtils.interactWith(event, Itemdata.getGames())) {
                new GameMenu().deployMenu(player);
            }

            if (event.getItem().equals(Itemdata.getInfo())) {
                player.sendMessage(ChatColor.AQUA + "Does nothing yet. Enjoy some red text. Hmmmm this is some nice text. Oh, wow fancy must be this text. Must this text be the most fancy text you've ever come across?" +
                        " How delightful and inspiring shall it be. How magnificent and awe-inspiring of the color that is on the screen. Of uttermost dazzling transcendent, incomparable and with an excelling daze of predominant tranquility, oh, yes it must be from the glorious sky it must be from as it enchants on the screen in glorious measures of blissful placidity with a hint of the gentle measure of placidity. Oh, must it be the most glorious text you've ever come across." +
                        "" +
                        " Never mind it is aqua now, ohh how illustrious, like a triumphant of the storm of waves after a sublime crash offering gleaming wondrous days of wine and roses that coruscates the ever so peerless unsurpassable kind of color on the screen, oh how must it be astonishing. ");
                event.setCancelled(true);

            }
            if(event.getItem().equals(Itemdata.getProfile(player))){
                event.setCancelled(true);
                new Profile().deploy(player);
            }
        }
    }

    @EventHandler
    public void onHungerDrop(FoodLevelChangeEvent event){
        if(event.getEntity().getType() == EntityType.PLAYER){
            Player player = (Player) event.getEntity();
            if (PlayerData.inLobby(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();

            if (PlayerData.inLobby(player)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(EntityPickupItemEvent event){
        if(event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player) event.getEntity();
            if (PlayerData.inLobby(player)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(PlayerDropItemEvent event){
        if (PlayerData.inLobby(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockPlaceEvent event) {
        if (PlayerData.inLobby(event.getPlayer())) {
            if (!(PlayerData.getBranchID(Branch.ADMINISTRATION, event.getPlayer()) >= 2) || !event.getPlayer().isOp()) {

                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if (PlayerData.inLobby(event.getPlayer())) {
            if (!(PlayerData.getBranchID(Branch.ADMINISTRATION, event.getPlayer()) >= 2) || !event.getPlayer().isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
