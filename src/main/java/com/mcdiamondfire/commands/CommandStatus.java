package com.mcdiamondfire.commands;

import com.mcdiamondfire.DatabaseHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.Connection;

public class CommandStatus implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        try{
            Connection connection = DatabaseHandler.getConnection();
            if(!connection.isClosed()){
                sender.sendMessage(ChatColor.GREEN + "Opened!");
            }else{
                sender.sendMessage(ChatColor.RED + "Closed!");

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
