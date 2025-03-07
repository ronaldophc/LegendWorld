package com.ronaldophc.api.bo2;

import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BO2Parser {
    public static List<BlockData> parseBO2File(File file) throws IOException {
        List<BlockData> blockDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean dataSection = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[DATA]")) {
                    dataSection = true;
                    continue;
                }
                if (dataSection && !line.isEmpty()) {
                    String[] parts = line.split(":");
                    String[] coords = parts[0].split(",");
                    int x = Integer.parseInt(coords[0]);
                    int y = Integer.parseInt(coords[1]);
                    int z = Integer.parseInt(coords[2]);
                    String[] blockInfo = parts[1].split("\\.");
                    int blockId = Integer.parseInt(blockInfo[0]);
                    byte blockData = Byte.parseByte(blockInfo[1]);
                    blockDataList.add(new BlockData(x, y, z, blockId, blockData));
                }
            }
        } catch (IOException e) {
            Bukkit.broadcastMessage("Failed to parse BO2 file: " + e.getMessage());
            throw new IOException("Failed to parse BO2 file: " + e.getMessage());
        }
        return blockDataList;
    }
}