package com.ronaldophc.api.bo3;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BO3Parser {

    public static List<BlockData> parseBO3File(File file) throws IOException {
        List<BlockData> blockDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Block(")) {
                    String[] parts = line.substring(6, line.length() - 1).split(",");
                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    int z = Integer.parseInt(parts[2]);
                    String[] blockInfo = parts[3].split(":");
                    Material material = Material.getMaterial(blockInfo[0]);
                    byte data = blockInfo.length > 1 ? Byte.parseByte(blockInfo[1]) : 0;
                    blockDataList.add(new BlockData(x, y, z, material, data));
                }
            }
        } catch (IOException e) {
            Bukkit.broadcastMessage("Failed to parse BO3 file: " + e.getMessage());
            throw new IOException("Failed to parse BO3 file: " + e.getMessage());
        }
        return blockDataList;
    }

    public static class BlockData {
        public int x, y, z;
        public Material material;
        public byte data;

        public BlockData(int x, int y, int z, Material material, byte data) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.material = material;
            this.data = data;
        }
    }
}