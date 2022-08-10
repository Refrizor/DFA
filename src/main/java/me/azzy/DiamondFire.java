package me.azzy;

import me.azzy.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.io.File;
import java.util.ArrayList;

public class DiamondFire extends JavaPlugin {

    private static Scoreboard scoreboard;
    private static DiamondFire instance;
    private static FileConfiguration messagesConfig;
    private static File file;

    public static DiamondFire getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){
        instance = this;

        createConfig();
        getConfig().options().copyDefaults(true);
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
        getCommand("purgedata").setExecutor(new CommandPurgedata());
        getCommand("config").setExecutor(new CommandConfig());

        Initializer.initialize();
    }

    @Override
    public void onDisable(){
        Initializer.unload();
    }

    private void createConfig(){
        file = new File(getDataFolder(), "messages.yml");
        if(!file.exists()){
            file.getParentFile().mkdirs();
            saveResource("messages.yml", false);
        }
        messagesConfig = new YamlConfiguration();
        try{
            messagesConfig.load(file);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static FileConfiguration getConfiguration(){
        return DiamondFire.getInstance().getConfig();
    }

    public static FileConfiguration getMessagesConfig() {
        return messagesConfig;
    }

    public File getFile() {
        return file;
    }

    public static Scoreboard getScoreboard() {
        return scoreboard;
    }
}
