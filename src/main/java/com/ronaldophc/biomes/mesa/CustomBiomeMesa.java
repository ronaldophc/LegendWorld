package com.ronaldophc.biomes.mesa;

import com.ronaldophc.biomes.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeMesa;

public class CustomBiomeMesa extends BiomeMesa {

    public CustomBiomeMesa(int i) {
        super(i, false, false);
        this.as = new CustomBiomeDecorator();
    }
}
