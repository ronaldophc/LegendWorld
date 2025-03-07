package com.ronaldophc.api.bo2;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StructureGenerator {
    public static void generateStructure(World world, Location location, File file) {
        try {
            List<BlockData> blockDataList = BO2Parser.parseBO2File(file);
            for (BlockData blockData : blockDataList) {
                Location blockLocation = location.clone().add(blockData.getX(), blockData.getY(), blockData.getZ());
                Block block = world.getBlockAt(blockLocation);
                block.setType(Material.getMaterial(blockData.getBlockId()));
                block.setData(blockData.getBlockData());
            }
        } catch (IOException e) {
            Bukkit.getLogger().severe("Failed to parse BO2 file: " + e.getMessage());
        }
    }
}
