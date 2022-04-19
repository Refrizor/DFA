package com.mcdiamondfire.commands;

import com.mcdiamondfire.server.Patchnotes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandPatch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        sender.sendMessage(Patchnotes.getLatest());
        return true;
    }
}
