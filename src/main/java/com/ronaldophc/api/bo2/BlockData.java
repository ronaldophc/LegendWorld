package com.ronaldophc.api.bo2;

public class BlockData {
    private final int x;
    private final int y;
    private final int z;
    private final int blockId;
    private final byte blockData;

    public BlockData(int x, int y, int z, int blockId, byte blockData) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.blockId = blockId;
        this.blockData = blockData;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getBlockId() {
        return blockId;
    }

    public byte getBlockData() {
        return blockData;
    }
}
