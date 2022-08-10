package me.azzy.commands;

import me.azzy.DiamondFire;
import me.azzy.minigames.sb.Teams;
import me.azzy.utils.WorldGenerator;
import me.azzy.utils.PlayerUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        int length = args.length;

        if(args[0].equalsIgnoreCase("tp")){
            player.teleport(new Location(Bukkit.getWorld(args[1]), 1, 100, 1));
        }

        if (args[0].equalsIgnoreCase("genworld")) {

            WorldGenerator.create(WorldType.FLAT, args[1]);
        }

        if(args[0].equalsIgnoreCase("delete")){
            WorldGenerator.delete(args[1]);
        }

        if(args[0].equalsIgnoreCase("sidebar")){
            PlayerUtils.sendSidebar(player);
        }

        if(args[0].equalsIgnoreCase("test")){
            player.spigot().sendMessage(PlayerUtils.hoverText("Test", "test"));
        }

        if(args[0].equalsIgnoreCase("emote")) {
            TextComponent tc = new TextComponent(ChatColor.GOLD + "⛨");
            HoverEvent he = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.AQUA + "Events staff"));
            tc.setHoverEvent(he);

            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                all.spigot().sendMessage(tc);
            }
        }

        if(args[0].equalsIgnoreCase("bowlimits")){
            player.sendMessage("" + DiamondFire.getConfiguration().getInt("bow_limits"));
        }

        if(args[0].equalsIgnoreCase("size")){
            player.sendMessage("" + Teams.getBlue().size() + " for blue");
            player.sendMessage("" + Teams.getRed().size() + " for red");
        }
        return true;
    }
}