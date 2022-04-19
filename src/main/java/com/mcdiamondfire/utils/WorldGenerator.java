package com.mcdiamondfire.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;

public class WorldGenerator {

    public static void create(WorldType worldType, String name) {

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = null;

        try {
            jsonObject = (JsonObject) jsonParser.parse(new FileReader("/home/azzy/IdeaProjects/DFA/src/main/java/com/mcdiamondfire/genSettings.json"));
        }catch(Exception e){
            e.printStackTrace();
        }

        WorldCreator worldCreator = new WorldCreator(name);
        worldCreator.type(worldType);
        worldCreator.generateStructures(false);
        worldCreator.generatorSettings((String) jsonObject.toString());
        worldCreator.createWorld();
    }

    public static void load(String world){
        new WorldCreator(world).createWorld();
    }

    public static void delete(String name) {
        Bukkit.unloadWorld(name, false);

        try {

            File file = Paths.get(name).toFile();
            FileVisitor.removeDirectory(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void duplicateWorld(String existingWorld, String newWorld){

        try{
            FileVisitor.copyDirectoryFileVisitor(existingWorld, newWorld);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

//worldCreator.generatorSettings("{\"structures\": {\"structures\": {}}, \"layers\": [{\"block\": \"stone\", \"height\": 45}, {\"block\": \"dirt\", \"height\": 4}, {\"block\": \"grass_block\", \"height\": 1}], \"biome\":\"plains\"}");
//worldCreator.generatorSettings("{\"structures\": {\"structures\": {}}, \"layers\": [], \"biome\":\"the_void\"}");