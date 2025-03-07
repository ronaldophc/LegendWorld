package com.ronaldophc.biome.iceplains;

import com.ronaldophc.biome.CustomBiomeDecorator;
import net.minecraft.server.v1_8_R3.BiomeIcePlains;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;

import java.lang.reflect.Field;
import java.util.Random;

public class CustomBiomeIcePlains extends BiomeIcePlains {

    public CustomBiomeIcePlains(int id) {
        super(id, true);
        try {
            Field aEField = BiomeIcePlains.class.getDeclaredField("aE");
            aEField.setAccessible(true);
            aEField.set(this, new CustomWorldGenIceTree2());
            Field aFField = BiomeIcePlains.class.getDeclaredField("aF");
            aFField.setAccessible(true);
            aFField.set(this, new CustomWorldGenIceTree());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.as = new CustomBiomeDecorator();
        this.as.L = false;
    }

    @Override
    public void a(World world, Random random, BlockPosition position) {
        super.a(world, random, position);
    }

    @Override
    public WorldGenTreeAbstract a(Random random) {
        return new CustomWorldGenTreeNull(true);
    }
}
