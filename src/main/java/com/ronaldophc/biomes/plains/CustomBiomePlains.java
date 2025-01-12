package com.ronaldophc.biomes.plains;

import java.util.Random;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.BiomePlains;
import net.minecraft.server.v1_8_R3.BlockFlowers;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.World;

public class CustomBiomePlains extends BiomePlains {

    public CustomBiomePlains(int id) {
        super(id);
        this.as = new CustomBiomeDecorator();
    }

    @Override
    public BlockFlowers.EnumFlowerVarient a(Random random, BlockPosition blockPosition) {
        return super.a(random, blockPosition);
    }

    @Override
    public void a(World world, Random random, BlockPosition blockPosition) {
        super.a(world, random, blockPosition);
    }

    @Override
    protected BiomeBase d(int i) {
        return super.d(i);
    }
}