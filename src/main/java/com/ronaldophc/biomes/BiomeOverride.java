package com.ronaldophc.biomes;

import com.ronaldophc.LegendWorld;
import com.ronaldophc.biomes.desert.CustomBiomeDesert;
import com.ronaldophc.biomes.forest.CustomBiomeForest;
import com.ronaldophc.biomes.iceplains.CustomBiomeIcePlains;
import com.ronaldophc.biomes.jungle.CustomBiomeJungle;
import com.ronaldophc.biomes.mesa.CustomBiomeMesa;
import com.ronaldophc.biomes.mushroom_shore.CustomBiomeMushroomShore;
import com.ronaldophc.biomes.plains.CustomBiomePlains;
import com.ronaldophc.biomes.swamp.CustomBiomeSwamp;
import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.BiomeDecorator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class BiomeOverride {

    // 1 - Plains
    // 2 - Desert
    // 3 - Extreme Hills - Big Hills
    // 4 - Forest
    // 5 - Taiga
    // 6 - Swampland
    // 7 - River
    // 8 - Hell (Nether)
    // 9 - The End
    // 10 - Frozen Ocean
    // 11 - Frozen River
    // 12 - Ice Plains
    // 13 - Ice Mountains
    // 14 - Mushroom Island
    // 15 - Mushroom Island Shore
    // 16 - Beach
    // 17 - Desert Hills
    // 18 - Forest Hills
    // 19 - Taiga Hills
    // 20 - Extreme Hills Edge
    // 21 - Jungle
    // 22 - Jungle Hills
    // 23 - Jungle Edge
    // 24 - Deep Ocean
    // 25 - Stone Beach
    // 26 - Cold Beach
    // 27 - Birch Forest
    // 28 - Birch Forest Hills
    // 29 - Roofed Forest
    // 30 - Cold Taiga
    // 31 - Cold Taiga Hills
    // 32 - Mega Taiga
    // 33 - Mega Taiga Hills
    // 34 - Extreme Hills+
    // 37 - Mesa
    // 38 - Mesa Plateau F

    public static void overrideBiomes() {
        try {

            Field biomesField = BiomeBase.class.getDeclaredField("biomes");
            biomesField.setAccessible(true);
            BiomeBase[] biomes = (BiomeBase[]) biomesField.get(null);

            biomes[37] = new CustomBiomeMesa(37);
            biomes[2] = new CustomBiomeDesert(2);
            biomes[12] = new CustomBiomeIcePlains(12);
            biomes[4] = new CustomBiomeForest(4, 0);
            biomes[6] = new CustomBiomeSwamp(6);
            biomes[1] = new CustomBiomePlains(1);
            biomes[15] = new CustomBiomeMushroomShore(15);
            biomes[21] = new CustomBiomeJungle(21, false);

            List<BiomeBase> biomesToReplace1 = Arrays.asList(
                    BiomeBase.MESA_PLATEAU_F,
                    BiomeBase.MEGA_TAIGA_HILLS, BiomeBase.MEGA_TAIGA, BiomeBase.STONE_BEACH,
                     BiomeBase.ROOFED_FOREST, BiomeBase.JUNGLE_EDGE, BiomeBase.JUNGLE_HILLS
            );

            List<BiomeBase> biomesToReplace2 = Arrays.asList(
                    BiomeBase.OCEAN, BiomeBase.DEEP_OCEAN, BiomeBase.BEACH
            );

            List<BiomeBase> biomesToReplace3 = Arrays.asList(
                    BiomeBase.COLD_TAIGA, BiomeBase.COLD_TAIGA_HILLS, BiomeBase.ICE_MOUNTAINS,
                    BiomeBase.COLD_BEACH, BiomeBase.FROZEN_OCEAN, BiomeBase.FROZEN_RIVER
            );

            List<Integer> biomesToReplace4 = Arrays.asList(162, 156, 158, 34, 131, 163, 17, 132);

            List<BiomeBase> biomesToReplace5 = Arrays.asList(BiomeBase.FOREST_HILLS, BiomeBase.BIRCH_FOREST, BiomeBase.EXTREME_HILLS_PLUS,
                    BiomeBase.EXTREME_HILLS, BiomeBase.BIRCH_FOREST_HILLS );

            List<BiomeBase> biomesToReplace6 = Arrays.asList(BiomeBase.STONE_BEACH, BiomeBase.RIVER, BiomeBase.TAIGA_HILLS, BiomeBase.SAVANNA_PLATEAU);

            List<Integer> lastVerify = Arrays.asList(0, 3, 7, 10, 11,
                    13, 14,
                    16, 17, 18, 19, 20,
                    22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 38,
                    129, 130, 131, 132, 133, 134, 140, 149, 151, 155, 156, 157, 158, 160, 161, 162, 163, 164, 165, 166, 167);


            for (int i = 0; i < biomes.length; i++) {
                if (biomes[i] == null) continue;
                for (BiomeBase biome : biomesToReplace1) {
                    if (biomes[i] == biome) {
                        biomes[i] = BiomeBase.JUNGLE;
                        continue;
                    }
                }
                for (BiomeBase biome : biomesToReplace2) {
                    if (biomes[i] == biome) {
                        biomes[i] = BiomeBase.MESA;
                        continue;
                    }
                }
                for (BiomeBase biome : biomesToReplace3) {
                    if (biomes[i] == biome) {
                        biomes[i] = BiomeBase.ICE_PLAINS;
                        continue;
                    }
                }
                if (biomesToReplace4.contains(i)) {
                    biomes[i] = BiomeBase.SWAMPLAND;
                    continue;
                }
                for (BiomeBase biome : biomesToReplace5) {
                    if (biomes[i] == biome) {
                        biomes[i] = BiomeBase.DESERT;
                        continue;
                    }
                }
                for (BiomeBase biome : biomesToReplace6) {
                    if (biomes[i] == biome) {
                        biomes[i] = BiomeBase.MUSHROOM_SHORE;
                        continue;
                    }
                }
//                if (lastVerify.contains(i)) {
//                    biomes[i] = BiomeBase.MESA;
//                }
            }

        } catch (Exception ignored) {

        }

        try {
            for (BiomeBase biome : BiomeBase.getBiomes()) {
                if (biome == null) continue;

                Field decoratorField = BiomeBase.class.getDeclaredField("aC"); // The field "aC" is where the BiomeDecorator is stored
                decoratorField.setAccessible(true);

                if (BiomeDecorator.class.isAssignableFrom(decoratorField.getType())) {
                    CustomBiomeDecorator customDecorator = new CustomBiomeDecorator();
                    decoratorField.set(biome, customDecorator);
                }
            }
        } catch (Exception ignored) {
        }
    }

}
