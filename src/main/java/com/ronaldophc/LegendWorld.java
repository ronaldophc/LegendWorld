package com.ronaldophc;

import com.ronaldophc.biome.BiomeOverride;
import com.ronaldophc.command.BO2Command;
import com.ronaldophc.command.BO3Command;
import com.ronaldophc.listener.EventChunkPopulate;
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
        registerCommands();
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

    public void registerCommands() {
        LegendWorld instance = getInstance();
        instance.getCommand("bo2").setExecutor(new BO2Command());
        instance.getCommand("bo3").setExecutor(new BO3Command());
    }

    public static LegendWorld getInstance() {
        return getPlugin(LegendWorld.class);
    }

}
