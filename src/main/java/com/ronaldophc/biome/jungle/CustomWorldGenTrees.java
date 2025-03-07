package com.ronaldophc.biome.jungle;

import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class CustomWorldGenTrees extends WorldGenTrees {

    public CustomWorldGenTrees(boolean flag, int height, IBlockData log, IBlockData leaves, boolean vines) {
        super(flag, height, log, leaves, vines);
    }

    @Override
    public boolean generate(World world, Random random, BlockPosition position) {
        int chance = random.nextInt(10);
        if (chance == 0) {
            return super.generate(world, random, position);
        }

        if (chance <= 3) {
            return true;
        }

        boolean result = super.generate(world, random, position);


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