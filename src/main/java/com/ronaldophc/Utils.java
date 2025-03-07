package com.ronaldophc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import java.io.File;

public class Utils {

    public static void deleteWorld(String worldName) {
        // Unload the world if it is loaded
        LegendWorld.logger.info("Deleting World");
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Bukkit.unloadWorld(world, false);
        }

        // Delete the world folder
        File worldFolder = new File(Bukkit.getServer().getWorldContainer(), worldName);
        deleteAllFolder(worldFolder);
        LegendWorld.logger.info("World deleted");
    }

    public static void deleteAllFolder(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteAllFolder(file);
                    } else {
                        try {
//                            LegendWorld.logger.info("Deleted file: " + file.getName());
                            boolean fileTest = file.delete();
                        } catch (Exception e) {
                            LegendWorld.logger.warning("Failed to delete file: " + file.getName());
                        }
                    }
                }
            }
        }
        path.delete();
    }

    // Não está sendo usado
    public static void unloadAllChunks(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Chunk[] loadedChunks = world.getLoadedChunks();
            LegendWorld.logger.warning("Unloading chunks");
            for (Chunk chunk : loadedChunks) {
                world.unloadChunk(chunk.getX(), chunk.getZ(), false);
            }
        }
    }

    public static void removeGroundItems(String worldName) {
        World world = Bukkit.getWorld(worldName);
        for (Entity entity : world.getEntities()) {
            if (entity instanceof Item) {
                entity.remove();
            }
        }
    }

    public static String bold = "§l";
    public static String color1 = "§b";
    public static String color2 = "§f";
    public static String color3 = "§e";
    public static String admin = ChatColor.LIGHT_PURPLE.toString();
    public static String success = "§a";
    public static String error = "§c";
    public static String errorServer = "§4";
    public static String title = "§b§lLegendWorld";
    public static String noPermission = error + "Voce não tem permissao para executar este comando.";
    public static String noConsole = error + "Não pode executar este comando no console.";
    public static String noPlayer = error + "Jogador não encontrado.";


    public static String usage(String usage) {
        return Utils.bold + Utils.color1 + "Use " + Utils.bold + Utils.color2 + usage;
    }

    public static void errorCommand(String comando, Exception e) {
        LegendWorld.logger.info("Erro ao usar o comando " + comando + ": " + e.getMessage());
    }

}
