package com.ronaldophc.biome.mesa;

import com.ronaldophc.LegendWorld;
import com.ronaldophc.api.bo3.StructureGenerator;
import net.minecraft.server.v1_8_R3.*;

import java.io.File;
import java.util.Random;

public class CustomWorldGenTreeMesa extends WorldGenTreeAbstract {

    public CustomWorldGenTreeMesa(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World world, Random random, BlockPosition blockPosition) {
        Block blockBelow = world.getType(blockPosition.down()).getBlock();
        if (blockBelow == Blocks.SAND) {
            if (random.nextInt(10) < 5) {
                File file = new File(LegendWorld.getInstance().getDataFolder(), "Orange.bo3");
                StructureGenerator.generateStructureNMS(world, blockPosition, file);
            }
            return true;
        }
        return false;
    }
}
