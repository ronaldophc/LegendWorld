package com.ronaldophc.biome.desert;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeDesert;
import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;

import java.util.Random;

public class CustomBiomeDesert extends BiomeDesert {

    public CustomBiomeDesert(int i) {
        super(i);
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
    }

    @Override
    public WorldGenTreeAbstract a(Random random) {
        return new CustomWorldGenTreeDesert(false);
    }
}
