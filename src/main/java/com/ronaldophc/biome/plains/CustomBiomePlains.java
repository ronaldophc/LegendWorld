package com.ronaldophc.biome.plains;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.*;

import java.util.Random;

public class CustomBiomePlains extends BiomePlains {

    public CustomBiomePlains(int id) {
        super(id);
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
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