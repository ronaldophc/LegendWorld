package com.ronaldophc.biome.swamp;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeSwamp;
import net.minecraft.server.v1_8_R3.ChunkSnapshot;
import net.minecraft.server.v1_8_R3.World;

import java.util.Random;

public class CustomBiomeSwamp extends BiomeSwamp {

    public CustomBiomeSwamp(int id) {
        super(id);
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
    }


    @Override
    public void a(World world, Random random, ChunkSnapshot chunkSnapshot, int x, int z, double noise) {
        this.b(world, random, chunkSnapshot, x, z, noise);
    }



}