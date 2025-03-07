package com.ronaldophc.biome.mesa;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeMesa;
import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;

import java.util.Random;

public class CustomBiomeMesa extends BiomeMesa {

    public CustomBiomeMesa(int i) {
        super(i, false, false);
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
    }

    @Override
    public WorldGenTreeAbstract a(Random random) {
        return new CustomWorldGenTreeMesa(true);
    }
}
