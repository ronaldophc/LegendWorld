package com.ronaldophc.biome.forest;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeForest;

public class CustomBiomeForest extends BiomeForest {

    public CustomBiomeForest(int i, int i1) {
        super(i, i1);
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
    }
}
