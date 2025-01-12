package com.ronaldophc.biomes;

import java.util.Random;

import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.BiomeDecorator;
import net.minecraft.server.v1_8_R3.BlockFlowers;
import net.minecraft.server.v1_8_R3.BlockFlowers.EnumFlowerVarient;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.BlockStone;
import net.minecraft.server.v1_8_R3.BlockStone.EnumStoneVariant;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.CustomWorldSettingsFinal;
import net.minecraft.server.v1_8_R3.CustomWorldSettingsFinal.CustomWorldSettings;
import net.minecraft.server.v1_8_R3.Material;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldGenCactus;
import net.minecraft.server.v1_8_R3.WorldGenClay;
import net.minecraft.server.v1_8_R3.WorldGenDeadBush;
import net.minecraft.server.v1_8_R3.WorldGenFlowers;
import net.minecraft.server.v1_8_R3.WorldGenHugeMushroom;
import net.minecraft.server.v1_8_R3.WorldGenMinable;
import net.minecraft.server.v1_8_R3.WorldGenMushrooms;
import net.minecraft.server.v1_8_R3.WorldGenPumpkin;
import net.minecraft.server.v1_8_R3.WorldGenReed;
import net.minecraft.server.v1_8_R3.WorldGenSand;
import net.minecraft.server.v1_8_R3.WorldGenTreeAbstract;
import net.minecraft.server.v1_8_R3.WorldGenWaterLily;
import net.minecraft.server.v1_8_R3.WorldGenerator;

public class CustomBiomeDecorator extends BiomeDecorator {
    protected World a;
    protected Random b;
    protected BlockPosition c;
    protected CustomWorldSettingsFinal d;
    protected WorldGenerator e = new WorldGenClay(4);
    protected WorldGenerator f; // = new WorldGenSand(Blocks.SAND, 7);
    protected WorldGenerator g; // = new WorldGenSand(Blocks.GRAVEL, 6);
    protected WorldGenerator h; // = new WorldGenMinable(Blocks.DIRT.getBlockData(), 32);
    protected WorldGenerator i; // = new WorldGenMinable(Blocks.GRAVEL.getBlockData(), 32);
    protected WorldGenerator j; // = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.GRANITE), 10);
    protected WorldGenerator k; // = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.DIORITE), 8);
    protected WorldGenerator l; // = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.ANDESITE), 7);
    protected WorldGenerator m; // = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), 16);
    protected WorldGenerator n; // = new WorldGenMinable(Blocks.IRON_ORE.getBlockData(), 8);
    protected WorldGenerator o; // = new WorldGenMinable(Blocks.GOLD_ORE.getBlockData(), 8);
    protected WorldGenerator p; // = new WorldGenMinable(Blocks.REDSTONE_ORE.getBlockData(), 7);
    protected WorldGenerator q; // = new WorldGenMinable(Blocks.DIAMOND_ORE.getBlockData(), 7);
    protected WorldGenerator r; // = new WorldGenMinable(Blocks.LAPIS_ORE.getBlockData(), 6);
    protected WorldGenFlowers s; // = new WorldGenFlowers(Blocks.YELLOW_FLOWER, EnumFlowerVarient.DANDELION);
    protected WorldGenerator t; // = new WorldGenMushrooms(Blocks.BROWN_MUSHROOM);
    protected WorldGenerator u; // = new WorldGenMushrooms(Blocks.RED_MUSHROOM);
    protected WorldGenerator v; // = new WorldGenHugeMushroom();
    protected WorldGenerator w; // = new WorldGenReed();
    protected WorldGenerator x; // = new WorldGenCactus();
    protected WorldGenerator y; // = new WorldGenWaterLily();
    protected int z; // = flowerCount;
    protected int A; // = grassCount;
    protected int B; // = bigMushroomsCount;
    protected int C; // = reedCount;
    protected int D; // = deadBushCount;
    protected int E; // = waterlilyCount;
    protected int F; // = waterlilyPerChunk;
    protected int G; // = cactusCount;
    protected int H; // = sandCount;
    protected int I; // = sandPerChunk;
    protected int J; // = clayCount;
    protected int K; // = bigMushroomsPerChunk;
    public boolean L = false; // = generateLakes;

    public CustomBiomeDecorator() {
        this.f = new WorldGenSand(Blocks.SAND, 7);
        this.g = new WorldGenSand(Blocks.GRAVEL, 6);
        this.s = new WorldGenFlowers(Blocks.YELLOW_FLOWER, EnumFlowerVarient.DANDELION);
        this.t = new WorldGenMushrooms(Blocks.BROWN_MUSHROOM);
        this.u = new WorldGenMushrooms(Blocks.RED_MUSHROOM);
        this.v = new WorldGenHugeMushroom();
        this.w = new WorldGenReed();
        this.x = new WorldGenCactus();
        this.y = new WorldGenWaterLily();
        this.B = 0;
        this.C = 0;
        this.H = 1;
        this.I = 1;
        this.J = 4;
        this.L = false;
    }

    public void a(World var1, Random var2, BiomeBase var3, BlockPosition var4) {
        if (this.a != null) {
            throw new RuntimeException("Already decorating");
        } else {
            this.a = var1;
            String var5 = var1.getWorldData().getGeneratorOptions();
            if (var5 != null) {
                this.d = CustomWorldSettings.a(var5).b();
            } else {
                this.d = CustomWorldSettings.a("").b();
            }

            this.b = var2;
            this.c = var4;
            this.h = new WorldGenMinable(Blocks.DIRT.getBlockData(), this.d.I);
            this.i = new WorldGenMinable(Blocks.GRAVEL.getBlockData(), this.d.M);
            this.j = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.GRANITE), this.d.Q);
            this.k = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.DIORITE), this.d.U);
            this.l = new WorldGenMinable(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, EnumStoneVariant.ANDESITE), this.d.Y);
            this.m = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), this.d.ac);
            this.n = new WorldGenMinable(Blocks.IRON_ORE.getBlockData(), this.d.ag);
            this.o = new WorldGenMinable(Blocks.GOLD_ORE.getBlockData(), this.d.ak);
            this.p = new WorldGenMinable(Blocks.REDSTONE_ORE.getBlockData(), this.d.ao);
            this.q = new WorldGenMinable(Blocks.COAL_ORE.getBlockData(), this.d.as);
            this.r = new WorldGenMinable(Blocks.LAPIS_ORE.getBlockData(), this.d.aw);
            this.a(var3);
            this.a = null;
            this.b = null;
        }
    }

    protected void a(BiomeBase var1) {
        this.a();

        int var2;
        int var3;
        int var4;

        // SAND
        for (var2 = 0; var2 < this.I; ++var2) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            this.f.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
        }

        // clay
        for (var2 = 0; var2 < this.J; ++var2) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            this.e.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
        }

        // gravel
        for (var2 = 0; var2 < this.H; ++var2) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            this.g.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
        }

        // dirt
//        var2 = this.A;
//        if (this.b.nextInt(10) == 0) {
//            ++var2;
//        }

        int var5;
        BlockPosition var7;
        for (var3 = 0; var3 < var2; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            WorldGenTreeAbstract var6 = var1.a(this.b);
            var6.e();
            var7 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5));
            if (var6.generate(this.a, this.b, var7)) {
                var6.a(this.a, this.b, var7);
            }
        }

        for (var3 = 0; var3 < this.K; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            this.v.generate(this.a, this.b, this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)));
        }

        BlockPosition var8;
        int var11;
        int var12;
        for (var3 = 0; var3 < this.B; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() + 32;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                var8 = this.c.a(var4, var12, var5);
                BlockFlowers.EnumFlowerVarient var9 = var1.a(this.b, var8);
                BlockFlowers var10 = var9.a().a();
                if (var10.getMaterial() != Material.AIR) {
                    this.s.a(var10, var9);
                    this.s.generate(this.a, this.b, var8);
                }
            }
        }

        for (var3 = 0; var3 < this.C; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                var1.b(this.b).generate(this.a, this.b, this.c.a(var4, var12, var5));
            }
        }

        for (var3 = 0; var3 < this.D; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                (new WorldGenDeadBush()).generate(this.a, this.b, this.c.a(var4, var12, var5));
            }
        }

        for (var3 = 0; var3 < 5; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);

                BlockPosition var14;
                for (var8 = this.c.a(var4, var12, var5); var8.getY() > 0; var8 = var14) {
                    var14 = var8.down();
                    if (!this.a.isEmpty(var14)) {
                        break;
                    }
                }

                this.y.generate(this.a, this.b, var8);
            }
        }

        for (var3 = 0; var3 < this.E; ++var3) {
            if (this.b.nextInt(4) == 0) {
                var4 = this.b.nextInt(16) + 8;
                var5 = this.b.nextInt(16) + 8;
                BlockPosition var13 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5));
                this.t.generate(this.a, this.b, var13);
            }

            if (this.b.nextInt(8) == 0) {
                var4 = this.b.nextInt(16) + 8;
                var5 = this.b.nextInt(16) + 8;
                var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
                if (var11 > 0) {
                    var12 = this.b.nextInt(var11);
                    var8 = this.c.a(var4, var12, var5);
                    this.u.generate(this.a, this.b, var8);
                }
            }
        }

        if (this.b.nextInt(4) == 0) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            var5 = this.a.getHighestBlockYAt(this.c.a(var3, 0, var4)).getY() * 2;
            if (var5 > 0) {
                var11 = this.b.nextInt(var5);
                this.t.generate(this.a, this.b, this.c.a(var3, var11, var4));
            }
        }

        if (this.b.nextInt(8) == 0) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            var5 = this.a.getHighestBlockYAt(this.c.a(var3, 0, var4)).getY() * 2;
            if (var5 > 0) {
                var11 = this.b.nextInt(var5);
                this.u.generate(this.a, this.b, this.c.a(var3, var11, var4));
            }
        }

        for (var3 = 0; var3 < this.F; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                this.w.generate(this.a, this.b, this.c.a(var4, var12, var5));
            }
        }

        for (var3 = 0; var3 < 10; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                this.w.generate(this.a, this.b, this.c.a(var4, var12, var5));
            }
        }

        if (this.b.nextInt(32) == 0) {
            var3 = this.b.nextInt(16) + 8;
            var4 = this.b.nextInt(16) + 8;
            var5 = this.a.getHighestBlockYAt(this.c.a(var3, 0, var4)).getY() * 2;
            if (var5 > 0) {
                var11 = this.b.nextInt(var5);
                (new WorldGenPumpkin()).generate(this.a, this.b, this.c.a(var3, var11, var4));
            }
        }

        // cactus
        for (var3 = 0; var3 < this.G + 100; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.getHighestBlockYAt(this.c.a(var4, 0, var5)).getY() * 2;
            if (var11 > 0) {
                var12 = this.b.nextInt(var11);
                this.x.generate(this.a, this.b, this.c.a(var4, var12, var5));
            }
        }

    }

    protected void a(int var1, WorldGenerator var2, int var3, int var4) {
        int var5;
        if (var4 < var3) {
            var5 = var3;
            var3 = var4;
            var4 = var5;
        } else if (var4 == var3) {
            if (var3 < 255) {
                ++var4;
            } else {
                --var3;
            }
        }

        for (var5 = 0; var5 < var1; ++var5) {
            BlockPosition var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4 - var3) + var3, this.b.nextInt(16));
            var2.generate(this.a, this.b, var6);
        }

    }

    protected void b(int var1, WorldGenerator var2, int var3, int var4) {
        for (int var5 = 0; var5 < var1; ++var5) {
            BlockPosition var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
            var2.generate(this.a, this.b, var6);
        }

    }

    @Override
    protected void a() {

        this.a(this.d.J / 10, this.h, this.d.K, this.d.L); // Reduzir a quantidade de geração de areia pela metade
        this.a(this.d.N / 10, this.i, this.d.O, this.d.P); // Reduzir a quantidade de geração de cascalho pela metade
        this.a(this.d.V / 10, this.k, this.d.W, this.d.X); // Reduzir a quantidade de geração de granito pela metade
        this.a(this.d.R / 10, this.j, this.d.S, this.d.T); // Reduzir a quantidade de geração de diorito pela metade
        this.a(this.d.Z / 10, this.l, this.d.aa, this.d.ab); // Reduzir a quantidade de geração de andesito pela metade
        this.a(this.d.ad * 3, this.m, this.d.ae, this.d.af); // Reduzir a quantidade de geração de carvão pela metade
        this.a(this.d.ah * 5, this.n, this.d.ai, this.d.aj); // Reduzir a quantidade de geração de ferro pela metade
        this.a(this.d.al / 10, this.o, this.d.am, this.d.an); // Reduzir a quantidade de geração de ouro pela metade
        this.a(this.d.ap / 10, this.p, this.d.aq, this.d.ar); // Reduzir a quantidade de geração de redstone pela metade
        this.a(this.d.at / 1000, this.q, this.d.au, this.d.av); // Reduzir a quantidade de geração de diamante pela metade
        this.b(this.d.ax / 10, this.r, this.d.ay, this.d.az); // Reduzir a quantidade de geração de lápis-lazúli pela metade
    }
}
