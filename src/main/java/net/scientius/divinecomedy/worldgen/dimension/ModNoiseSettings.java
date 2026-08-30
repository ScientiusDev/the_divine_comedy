package net.scientius.divinecomedy.worldgen.dimension;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.worldgen.biome.ModSurfaceRules;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class ModNoiseSettings {

    public static final ResourceKey<NoiseGeneratorSettings> INFERNO = ResourceKey.create(Registries.NOISE_SETTINGS,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno"));

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> context) {
        HolderGetter<NormalNoise.NoiseParameters> noises = context.lookup(Registries.NOISE);

        context.register(INFERNO, new NoiseGeneratorSettings(
                new NoiseSettings(0, 288, 1, 2),
                Blocks.STONE.defaultBlockState(),
                Blocks.AIR.defaultBlockState(),
                buildRouter(noises),
                ModSurfaceRules.makeInfernoRules(),
                List.of(),
                0, false, false, false, false
        ));
    }

    private static NoiseRouter buildRouter(HolderGetter<NormalNoise.NoiseParameters> noises) {
        DensityFunction finalDensity = layerShape(noises);
        return new NoiseRouter(
                DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
                DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(),
                DensityFunctions.zero(), DensityFunctions.zero(),
                DensityFunctions.zero(),
                finalDensity,
                DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero()
        );
    }

    private static DensityFunction layerShape(HolderGetter<NormalNoise.NoiseParameters> noises) {
        DensityFunction finalShape = DensityFunctions.constant(1.0);

        for (int baseY : ModNoises.LAYER_BASE_YS) {
            finalShape = DensityFunctions.min(finalShape, buildSingleLayer(noises, baseY));
        }

        DensityFunction worldFloor = DensityFunctions.yClampedGradient(0, 4, 2.0, -2.0);
        finalShape = DensityFunctions.max(finalShape, worldFloor);

        DensityFunction worldCeiling = DensityFunctions.yClampedGradient(284, 288, -2.0, 2.0);
        finalShape = DensityFunctions.max(finalShape, worldCeiling);

        return finalShape;
    }

    private static DensityFunction sub(DensityFunction a, DensityFunction b) {
        return DensityFunctions.add(a, DensityFunctions.mul(DensityFunctions.constant(-1.0), b));
    }

    private static DensityFunction buildSingleLayer(HolderGetter<NormalNoise.NoiseParameters> noises, int baseY) {
        DensityFunction y = DensityFunctions.yClampedGradient(0, 288, 0.0, 288.0);


        DensityFunction floorNoise = DensityFunctions.interpolated(
                DensityFunctions.noise(noises.getOrThrow(ModNoises.floorKey(baseY)), 1.5, 0.0));

        DensityFunction floorSurfaceY = DensityFunctions.add(
                DensityFunctions.constant(baseY + 8.5),
                DensityFunctions.mul(floorNoise, DensityFunctions.constant(3.5))
        );
        DensityFunction floorDensity = sub(floorSurfaceY, y);

        DensityFunction ceilingNoise = DensityFunctions.interpolated(
                DensityFunctions.noise(noises.getOrThrow(ModNoises.ceilingKey(baseY)), 2.0, 0.0));

        DensityFunction ceilingSurfaceY = sub(
                DensityFunctions.constant(baseY + 23.5),
                DensityFunctions.mul(ceilingNoise, DensityFunctions.constant(3.5))
        );
        DensityFunction ceilingDensity = sub(y, ceilingSurfaceY);


        DensityFunction roomShape = DensityFunctions.max(floorDensity, ceilingDensity);

        return DensityFunctions.rangeChoice(
                y,
                baseY,
                baseY + 32,
                roomShape,
                DensityFunctions.constant(1.0)
        );
    }
}