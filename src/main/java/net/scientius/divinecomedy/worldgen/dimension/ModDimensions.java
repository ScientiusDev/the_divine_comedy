package net.scientius.divinecomedy.worldgen.dimension;


import net.minecraft.world.attribute.BedRule;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.Optional;

public class ModDimensions {

    public static final ResourceKey<LevelStem> INFERNO_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno"));
    public static final ResourceKey<Level> INFERNO_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno"));
    public static final ResourceKey<DimensionType> INFERNO_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno_type"));

    public static void bootstrapType(BootstrapContext<DimensionType> context){

        var timelines = context.lookup(Registries.TIMELINE);
        var clocks = context.lookup(Registries.WORLD_CLOCK);

        context.register(INFERNO_TYPE_KEY, new DimensionType(
                true,
                false,
                true,
                false,
                1.0,
                0,
                288,
                288,
                BlockTags.INFINIBURN_NETHER,
                0.7f,
                new DimensionType.MonsterSettings(ConstantInt.of(7), 15),
                DimensionType.Skybox.NONE,
                CardinalLighting.Type.DEFAULT,
                EnvironmentAttributeMap.builder().
                        set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, -13621215)
                        .set(EnvironmentAttributes.BED_RULE, BedRule.EXPLODES)
                        .set(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, true)
                        .build(),
                timelines.getOrThrow(TimelineTags.IN_NETHER),
                Optional.empty())
        );
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context){
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);



        ModBiomeSources customBiomeSource = new ModBiomeSources(List.of(
                new ModBiomeSources.Layer(256, 288, biomeRegistry.getOrThrow(ModBiomes.LIMBO)),
                new ModBiomeSources.Layer(224, 256, biomeRegistry.getOrThrow(ModBiomes.WHIRLING_WASTELANDS)),
                new ModBiomeSources.Layer(192, 224, biomeRegistry.getOrThrow(ModBiomes.GLUTTONOUS_CAVERNS)),
                new ModBiomeSources.Layer(160, 192, biomeRegistry.getOrThrow(ModBiomes.ARID_PLAINS)),
                new ModBiomeSources.Layer(128, 160, biomeRegistry.getOrThrow(ModBiomes.STYX_RIVER)),
                new ModBiomeSources.Layer(96, 128, biomeRegistry.getOrThrow(ModBiomes.DEPTHS_OF_DIS)),
                new ModBiomeSources.Layer(64, 96, biomeRegistry.getOrThrow(ModBiomes.WOOD_OF_SUICIDES)),
                new ModBiomeSources.Layer(32, 64, biomeRegistry.getOrThrow(ModBiomes.MALEBOLGE)),
                new ModBiomeSources.Layer(0, 32, biomeRegistry.getOrThrow(ModBiomes.FROZEN_DEPTHS))

        ));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                customBiomeSource,
                noiseGenSettings.getOrThrow(ModNoiseSettings.INFERNO)
        );

        LevelStem stem = new LevelStem(
                dimTypes.getOrThrow(INFERNO_TYPE_KEY),
                noiseBasedChunkGenerator
        );

        context.register(INFERNO_KEY, stem);
    }

}
