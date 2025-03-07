package com.ronaldophc.biome.jungle;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class CustomBiomeJungle extends BiomeJungle {
    private static final IBlockData aE;
    private static final IBlockData aF;
    private final boolean dense;

    public CustomBiomeJungle(int id, boolean dense) {
        super(id, false);
        this.as = new CustomBiomeDecorator();
        this.dense = dense;
        this.as.L = false;
    }

    @Override
    public WorldGenTreeAbstract a(Random var1) {
        return new CustomWorldGenTrees(false, 4 + var1.nextInt(7), aE, aF, false);
    }

    private boolean isDense() {
        return this.dense;
    }

    @Override
    public void a(World var1, Random var2, BlockPosition var3) {
        super.a(var1, var2, var3);
    }

    static {
        aE = Blocks.LOG.getBlockData().set(BlockLog1.VARIANT, BlockWood.EnumLogVariant.JUNGLE);
        aF = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.JUNGLE).set(BlockLeaves.CHECK_DECAY, false);
    }
}