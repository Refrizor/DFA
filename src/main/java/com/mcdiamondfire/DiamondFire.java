package com.mcdiamondfire;

import com.mcdiamondfire.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;

public class DiamondFire extends JavaPlugin {

    private static Scoreboard scoreboard;

    private static DiamondFire instance;

    public static DiamondFire getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){
        instance = this;

        FileConfiguration config = this.getConfig();
        config.addDefault("database_user", "Placeholder");
        config.addDefault("database_password", "Placeholder");
        config.addDefault("motd", "Placeholder");
        config.addDefault("login_message", "Placeholder");
        config.addDefault("spawn_location",  new ArrayList<Float>());
        config.addDefault("bow_limits", 5);

        config.options().copyDefaults(true);
        saveConfig();

        getCommand("checkrank").setExecutor(new CommandCheckrank());
        getCommand("status").setExecutor(new CommandStatus());
        getCommand("test").setExecutor(new CommandTest());
        getCommand("setrank").setExecutor(new CommandSetrank());
        getCommand("fly").setExecutor(new CommandFlight());
        getCommand("shout").setExecutor(new CommandShout());
        getCommand("admin").setExecutor(new CommandAdmin());
        getCommand("locationstick").setExecutor(new CommandLocationstick());
        getCommand("setbadge").setExecutor(new CommandBadge());
        getCommand("gamemaster").setExecutor(new CommandGamemaster());
        getCommand("ranks").setExecutor(new CommandRanks());
        getCommand("nick").setExecutor(new CommandNick());
        getCommand("adminv").setExecutor(new CommandAdminv());
        getCommand("patch").setExecutor(new CommandPatch());
        getCommand("spawn").setExecutor(new CommandSpawn());

        Initializer.initialize();
    }

    @Override
    public void onDisable(){
        Initializer.unload();
    }

    public static FileConfiguration getFileConfig(){
        return instance.getConfig();
    }

    public static Scoreboard getScoreboard() {
        return scoreboard;
    }
}
