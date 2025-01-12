package com.ronaldophc.biomes.forest;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeForest;

public class CustomBiomeForest extends BiomeForest {

    public CustomBiomeForest(int i, int i1) {
        super(i, i1);
        this.as = new CustomBiomeDecorator();
    }
}
