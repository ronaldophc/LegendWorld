package com.ronaldophc.biome.mushroom_shore;

import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class SimpleTreeGenerator extends WorldGenerator {

    @Override
    public boolean generate(World world, Random random, BlockPosition position) {
        // Define the height of the tree
        int height = random.nextInt(3) + 5;

        // Check if the position is valid for tree generation
        if (position.getY() >= 1 && position.getY() + height + 1 <= 256) {
            Block block = world.getType(position.down()).getBlock();
            if (block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.MYCELIUM) {
                // Generate the trunk
                for (int y = 0; y < height; y++) {
                    BlockPosition trunkPos = position.up(y);
                    Block blockAtPos = world.getType(trunkPos).getBlock();
                    if (blockAtPos.getMaterial() == Material.AIR || blockAtPos.getMaterial() == Material.LEAVES) {
                        world.setTypeAndData(trunkPos, Blocks.LOG.getBlockData(), 2);
                    }
                }

                // Generate the mushroom cap
                int capStart = position.getY() + height - 2;
                for (int y = capStart; y <= position.getY() + height; y++) {
                    int yOffset = y - (position.getY() + height);
                    int radius = 3 - yOffset / 2;
                    for (int x = position.getX() - radius; x <= position.getX() + radius; x++) {
                        for (int z = position.getZ() - radius; z <= position.getZ() + radius; z++) {
                            if (Math.abs(x - position.getX()) > 2 || Math.abs(z - position.getZ()) > 2 || y >= position.getY() + height) {
                                BlockPosition capPos = new BlockPosition(x, y, z);
                                Block blockAtPos = world.getType(capPos).getBlock();
                                if (blockAtPos.getMaterial() == Material.AIR || blockAtPos.getMaterial() == Material.LEAVES) {
                                    world.setTypeAndData(capPos, Blocks.RED_MUSHROOM_BLOCK.getBlockData(), 2);
                                }
                            }
                        }
                    }
                }

                return true;
            }
        }
        return false;
    }
}