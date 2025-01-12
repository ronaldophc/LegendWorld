package com.ronaldophc.biomes.mushroom_shore;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class CustomBiomeMushroomShore extends BiomeMushrooms {

    public CustomBiomeMushroomShore(int id) {
        super(id);
        this.as = new CustomBiomeDecorator();
    }

    @Override
    public void a(World world, Random random, BlockPosition blockPosition) {
        super.a(world, random, blockPosition);
        generateMushrooms(world, random, blockPosition);
        generateTrees(world, random, blockPosition);
    }

    private void generateMushrooms(World world, Random random, BlockPosition blockPosition) {
        for (int i = 0; i < 10; i++) {
            int x = blockPosition.getX() + random.nextInt(16) + 8;
            int z = blockPosition.getZ() + random.nextInt(16) + 8;
            int y = world.getHighestBlockYAt(new BlockPosition(x, 0, z)).getY();
            Block block = world.getType(new BlockPosition(x, y - 1, z)).getBlock();
            BlockPosition mushroomPos = new BlockPosition(x, y, z);
            if (world.getType(mushroomPos).getBlock() == Blocks.AIR && block == Blocks.MYCELIUM) {
                world.setTypeAndData(mushroomPos, random.nextBoolean() ? Blocks.RED_MUSHROOM.getBlockData() : Blocks.BROWN_MUSHROOM.getBlockData(), 2);
            }
        }
    }

    private void generateTrees(World world, Random random, BlockPosition blockPosition) {
        for (int i = 0; i < 1; i++) { // Adjust the number of trees as needed
            int x = blockPosition.getX() + random.nextInt(16) + 8;
            int z = blockPosition.getZ() + random.nextInt(16) + 8;
            int y = world.getHighestBlockYAt(new BlockPosition(x, 0, z)).getY();
            BlockPosition treePos = new BlockPosition(x, y, z);
            SimpleTreeGenerator treeGen = new SimpleTreeGenerator(); // Use appropriate tree generator
            treeGen.generate(world, random, treePos);
        }
    }
}