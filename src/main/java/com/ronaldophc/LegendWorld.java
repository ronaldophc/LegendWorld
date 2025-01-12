package com.ronaldophc;

import com.ronaldophc.biomes.BiomeOverride;
import com.ronaldophc.listeners.EventChunkPopulate;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class LegendWorld extends JavaPlugin {

    public static Logger logger;

    public void onLoad() {
        logger = getLogger();

        Bukkit.unloadWorld("world", false);
        Utils.deleteWorld("world");
        BiomeOverride.overrideBiomes();

        logger.info("LegendWorld Plugin Loaded");
    }

    public void onEnable() {
        registerEvents();
        logger.info("LegendWorld Plugin Enabled");
    }

    public void onDisable() {
        Bukkit.unloadWorld("world", false);
        logger.info("LegendWorld Plugin Disabled");
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EventChunkPopulate(), this);
    }

}
