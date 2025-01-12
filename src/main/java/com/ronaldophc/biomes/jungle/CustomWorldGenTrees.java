package com.ronaldophc.biomes.jungle;

import java.util.Random;

import net.minecraft.server.v1_8_R3.BlockCocoa;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.EnumDirection;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldGenTrees;

public class CustomWorldGenTrees extends WorldGenTrees {

    public CustomWorldGenTrees(boolean flag, int height, IBlockData log, IBlockData leaves, boolean vines) {
        super(flag, height, log, leaves, vines);
    }

    @Override
    public boolean generate(World world, Random random, BlockPosition position) {
        boolean result = super.generate(world, random, position);

        // Aumentar a chance de gerar cacau
        if (result) {
            for (int y = 0; y < 3; y++) {
                BlockPosition cocoaPos = position.up(y);
                if (world.getType(cocoaPos).getBlock() == Blocks.LOG) {
                    for (EnumDirection direction : EnumDirection.EnumDirectionLimit.HORIZONTAL) {
                        if (random.nextInt(100) >= 40) { // Aumentar a chance
                            BlockPosition blockposition1 = cocoaPos.shift(direction);
                            if (world.isEmpty(blockposition1)) {
                                IBlockData iblockdata = Blocks.COCOA.getBlockData().set(BlockCocoa.AGE, random.nextInt(3)).set(BlockCocoa.FACING, direction.opposite());
                                world.setTypeAndData(blockposition1, iblockdata, 2);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}