package com.ronaldophc.api.bo3;

import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StructureGenerator {

    public static void generateStructure(org.bukkit.World world, Location location, File file) {
        try {
            List<BO3Parser.BlockData> blockDataList = BO3Parser.parseBO3File(file);
            for (BO3Parser.BlockData blockData : blockDataList) {
                if (blockData.material != null) {
                    Location blockLocation = location.clone().add(blockData.x, blockData.y, blockData.z);
                    org.bukkit.block.Block block = world.getBlockAt(blockLocation);
                    block.setType(blockData.material);
                    block.setData(blockData.data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateStructureNMS(World nmsWorld, BlockPosition blockPosition, File file) {
        try {
            List<BO3Parser.BlockData> blockDataList = BO3Parser.parseBO3File(file);
            for (BO3Parser.BlockData blockData : blockDataList) {
                BlockPosition blockLocation = blockPosition.a(blockData.x, blockData.y - 1, blockData.z);
                Block block = Block.getById(blockData.material.getId());
                IBlockData blockDataNMS = block.fromLegacyData(blockData.data);
                nmsWorld.setTypeAndData(blockLocation, blockDataNMS, 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}