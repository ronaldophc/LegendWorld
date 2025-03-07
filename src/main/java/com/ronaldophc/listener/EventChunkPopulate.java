package com.ronaldophc.listener;

import com.ronaldophc.Utils;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventChunkPopulate implements Listener {

    private static final Random random = new Random();
    public static final List<Material> REMOVE = Arrays.asList(Material.SNOW, Material.DEAD_BUSH, Material.RED_ROSE, Material.YELLOW_FLOWER,
            Material.LONG_GRASS, Material.VINE, Material.DOUBLE_PLANT);
    public static final List<Object> REMOVE2 = Arrays.asList(
            new ItemStack(Material.DOUBLE_PLANT, 1, (short) 1),
            new ItemStack(Material.LONG_GRASS, 1, (short) 2),
            new ItemStack(Material.LONG_GRASS, 1, (short) 3),
            new ItemStack(Material.LONG_GRASS, 1, (short) 4),
            new ItemStack(Material.LONG_GRASS, 1, (short) 5),
            new ItemStack(Material.GRASS, 1, (short) 1),
            new ItemStack(Material.GRASS, 1, (short) 2));

    @EventHandler
    public void onChunkGenerate(ChunkPopulateEvent event) {
        Chunk chunk = event.getChunk();
        World world = chunk.getWorld();

        int chunkX = chunk.getX() * 16;
        int chunkZ = chunk.getZ() * 16;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                int worldX = chunkX + x;
                int worldZ = chunkZ + z;

                for (int y = 45; y < 80; y++) {

                    Block block = world.getBlockAt(worldX, y, worldZ);
                    Material type = block.getType();
                    ItemStack item = new ItemStack(type);

                    if (REMOVE.contains(type) || REMOVE2.contains(item)) {
//                        if (random.nextInt(100) < 85) {
                            block.setTypeIdAndData(Material.AIR.getId(), (byte) 0, false);
                            block.getState().update();
//                        }
                    }
                }

                int yBlock = world.getHighestBlockYAt(worldX, worldZ);
                Block blockBelow = world.getBlockAt(worldX, yBlock - 1, worldZ);
                Block blockAbove = blockBelow.getRelative(0, 1, 0);

                if ((random.nextInt(10) == 0)
                        && (blockBelow.getType() == Material.GRASS || blockBelow.getType() == Material.DIRT
                || blockBelow.getType() == Material.STAINED_CLAY || blockBelow.getType() == Material.HARD_CLAY
                || blockBelow.getType() == Material.SNOW)
                        && (blockAbove.getRelative(0, 1, 0).getType() == Material.AIR)) {
                    if (random.nextBoolean()) {
                        blockAbove.setTypeIdAndData(Material.RED_MUSHROOM.getId(), (byte) 0, false);
                    } else {
                        blockAbove.setTypeIdAndData(Material.BROWN_MUSHROOM.getId(), (byte) 0, false);
                    }
                }

            }
        }
        Utils.removeGroundItems("world");
    }


}