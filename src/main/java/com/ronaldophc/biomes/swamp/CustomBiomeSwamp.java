package com.ronaldophc.biomes.swamp;

import java.util.Random;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeSwamp;
import net.minecraft.server.v1_8_R3.ChunkSnapshot;
import net.minecraft.server.v1_8_R3.World;

public class CustomBiomeSwamp extends BiomeSwamp {

    public CustomBiomeSwamp(int id) {
        super(id);
        this.as = new CustomBiomeDecorator();
    }

    @Override
    public void a(World world, Random random, ChunkSnapshot chunkSnapshot, int x, int z, double noise) {
        this.b(world, random, chunkSnapshot, x, z, noise);
    }

}