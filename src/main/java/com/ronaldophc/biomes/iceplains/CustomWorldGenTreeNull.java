package com.ronaldophc.biomes.iceplains;

import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;

public class CustomWorldGenTreeNull extends WorldGenTreeAbstract {

    public CustomWorldGenTreeNull(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(net.minecraft.server.v1_8_R3.World world, java.util.Random random, net.minecraft.server.v1_8_R3.BlockPosition blockPosition) {
        return false;
    }
}
