package com.ronaldophc.biomes.jungle;

import java.util.Random;

import com.ronaldophc.biomes.CustomBiomeDecorator;

import net.minecraft.server.v1_8_R3.BiomeJungle;
import net.minecraft.server.v1_8_R3.BlockLeaves;
import net.minecraft.server.v1_8_R3.BlockLeaves1;
import net.minecraft.server.v1_8_R3.BlockLog1;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.BlockWood;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;

public class CustomBiomeJungle extends BiomeJungle {
    private static final IBlockData aE;
    private static final IBlockData aF;
    private final boolean dense;

    public CustomBiomeJungle(int id, boolean dense) {
        super(id, false);
        this.as = new CustomBiomeDecorator();
        this.dense = dense;
    }

    @Override
    public WorldGenTreeAbstract a(Random var1) {
        return (WorldGenTreeAbstract) (new CustomWorldGenTrees(false, 4 + var1.nextInt(7), aE, aF, false));
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