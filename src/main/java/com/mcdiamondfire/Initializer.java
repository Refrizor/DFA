package com.mcdiamondfire;

import com.mcdiamondfire.commands.CommandLocationstick;
import com.mcdiamondfire.events.*;
import com.mcdiamondfire.lobby.LobbyEvents;
import com.mcdiamondfire.lobby.menu.GameMenu;
import com.mcdiamondfire.rank.Tab;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scoreboard.Team;

public class Initializer {

    public static void initialize(){
        PluginManager pm = Bukkit.getPluginManager();

        //static Scoreboard scoreboard = DiamondFire.getInstance().getScoreboard();

        Tab.initTeams();

        pm.registerEvents(new JoinEvent(), DiamondFire.getInstance());
        pm.registerEvents(new QuitEvent(), DiamondFire.getInstance());
        pm.registerEvents(new ChatEvent(), DiamondFire.getInstance());
        pm.registerEvents(new LobbyEvents(), DiamondFire.getInstance());
        pm.registerEvents(new PingEvent(), DiamondFire.getInstance());
        pm.registerEvents(new GameMenu(), DiamondFire.getInstance());
        pm.registerEvents(new CommandLocationstick(), DiamondFire.getInstance());
        pm.registerEvents(new BlockChangeEvent(), DiamondFire.getInstance());
    }

    public static void unload(){
        Tab.ownerTeam.unregister();
        Tab.adminTeam.unregister();
        Tab.devTeam.unregister();
        Tab.srModTeam.unregister();
        Tab.modTeam.unregister();
        Tab.jrModTeam.unregister();
        Tab.expertTeam.unregister();
        Tab.helperTeam.unregister();
        Tab.jrHelperTeam.unregister();
        Tab.youtuberTeam.unregister();
        Tab.overlordTeam.unregister();
        Tab.mythicTeam.unregister();
        Tab.emperorTeam.unregister();
        Tab.nobleTeam.unregister();
        Tab.noneTeam.unregister();
    }
}
