package net.scientius.divinecomedy.worldgen.dimension;

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class ModNoises {

    public static final int[] LAYER_BASE_YS = {0, 32, 64, 96, 128, 160, 192, 224, 256};

    public static ResourceKey<NormalNoise.NoiseParameters> floorKey(int baseY) {
        return ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno_floor_" + baseY));
    }

    public static ResourceKey<NormalNoise.NoiseParameters> ceilingKey(int baseY) {
        return ResourceKey.create(Registries.NOISE, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno_ceiling_" + baseY));
    }

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        for (int baseY : LAYER_BASE_YS) {
            context.register(floorKey(baseY), new NormalNoise.NoiseParameters(-7, 1.0, 1.0));
            context.register(ceilingKey(baseY), new NormalNoise.NoiseParameters(-7, 1.0, 1.0));
        }
    }
}