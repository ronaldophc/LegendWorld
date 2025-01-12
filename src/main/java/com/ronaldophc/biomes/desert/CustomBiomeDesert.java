package com.ronaldophc.biomes.desert;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeDesert;

public class CustomBiomeDesert extends BiomeDesert {

    public CustomBiomeDesert(int i) {
        super(i);
        this.as = new CustomBiomeDecorator();
    }

}
