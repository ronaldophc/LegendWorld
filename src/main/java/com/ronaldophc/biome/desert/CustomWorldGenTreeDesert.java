package com.ronaldophc.biome.desert;

import com.ronaldophc.LegendWorld;
import com.ronaldophc.api.Schematic;
import net.minecraft.server.v1_8_R3.*;

import java.io.File;
import java.util.Random;

public class CustomWorldGenTreeDesert extends WorldGenTreeAbstract {

    public CustomWorldGenTreeDesert(boolean notify) {
        super(notify);
    }

    @Override
    public boolean generate(World world, Random random, BlockPosition blockPosition) {
        if (!isAreaFree(world, blockPosition)) {
            return true;
        }

        Block blockBelow = world.getType(blockPosition.down()).getBlock();
        if (blockBelow == Blocks.SAND) {
            int randomInt = random.nextInt(10);
            if (randomInt > 4) {
                return true;
            }
            File file = new File(LegendWorld.getInstance().getDataFolder(), "schematics/desert/tree/DeadTree04.schematic");
            switch (randomInt) {
                case 0:
                    file = new File(LegendWorld.getInstance().getDataFolder(), "schematics/desert/tree/DeadTree02.schematic");
                    break;
                case 1:
                    file = new File(LegendWorld.getInstance().getDataFolder(), "schematics/desert/tree/DeadTree03.schematic");
                    break;
                case 2:
                    file = new File(LegendWorld.getInstance().getDataFolder(), "schematics/desert/tree/DeadTree01.schematic");
                    break;
            }
            Schematic.getInstance().createSchematicNMS(world, blockPosition, file);
            return true;
        }
        return false;
    }

    private boolean isAreaFree(World world, BlockPosition position) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                Block block = world.getType(position.a(x, 0, z)).getBlock();
                if (block.getMaterial() != Material.AIR && block.getMaterial() != Material.REPLACEABLE_PLANT) {
                    return false;
                }
            }
        }
        return true;
    }
}
