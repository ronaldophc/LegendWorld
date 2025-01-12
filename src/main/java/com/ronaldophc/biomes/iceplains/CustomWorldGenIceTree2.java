package com.ronaldophc.biomes.iceplains;

import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class CustomWorldGenIceTree2 extends WorldGenPackedIce2 {

    public CustomWorldGenIceTree2() {
        super();
    }

    @Override
    public boolean generate(World world, Random random, BlockPosition position) {
        int height = 8 + random.nextInt(4); // Altura entre 8 e 11 blocos
        if (world.getType(position.down()).getBlock() != Blocks.GRASS) {
            return false;
        }
        // Verifica se há espaço suficiente para a árvore
        for (int y = position.getY(); y <= position.getY() + 1 + height; y++) {
            int radius = 1;
            if (y == position.getY()) {
                radius = 0;
            }
            if (y >= position.getY() + 1 + height - 2) {
                radius = 2;
            }

            for (int x = position.getX() - radius; x <= position.getX() + radius; x++) {
                for (int z = position.getZ() - radius; z <= position.getZ() + radius; z++) {
                    if (y >= 0 && y < 256) {
                        Block block = world.getType(new BlockPosition(x, y, z)).getBlock();
                        if (block.getMaterial() != Material.AIR && block.getMaterial() != Material.LEAVES) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        // Gera o tronco da árvore
        for (int y = 0; y < height; y++) {
            BlockPosition upN = position.up(y);
            Block block = world.getType(upN).getBlock();
            if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES || block.getMaterial() == Material.REPLACEABLE_PLANT) {
                world.setTypeAndData(upN, Blocks.LOG.getBlockData().set(BlockLog1.VARIANT, BlockWood.EnumLogVariant.SPRUCE), 2);
            }
        }

        // Gera os galhos de gelo
        for (int y = position.getY() - 3 + height; y <= position.getY() + height; y++) {
            int n = y - (position.getY() + height);
            int radius = 1 - n / 2;

            for (int x = position.getX() - radius; x <= position.getX() + radius; x++) {
                int xOffset = x - position.getX();
                for (int z = position.getZ() - radius; z <= position.getZ() + radius; z++) {
                    int zOffset = z - position.getZ();
                    if (Math.abs(xOffset) != radius || Math.abs(zOffset) != radius || random.nextInt(2) != 0 && n != 0) {
                        BlockPosition blockPos = new BlockPosition(x, y, z);
                        Block block = world.getType(blockPos).getBlock();
                        if (block.getMaterial() == Material.AIR || block.getMaterial() == Material.LEAVES || block.getMaterial() == Material.REPLACEABLE_PLANT) {
                            world.setTypeAndData(blockPos, Blocks.PACKED_ICE.getBlockData(), 2);
                        }
                    }
                }
            }
        }

        return true;
    }
}