package net.scientius.divinecomedy.worldgen.biome;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_SOUL_OAK_TREE = registerKey("add_soul_oak_tree");

    public static final ResourceKey<BiomeModifier> SPAWN_ROCK_ROLLER = registerKey("spawn_rock_roller");
    public static final ResourceKey<BiomeModifier> SPAWN_VIRGILAGER = registerKey("spawn_virgilager");
    public static final ResourceKey<BiomeModifier> SPAWN_CRAWLER = registerKey("spawn_crawler");
    public static final ResourceKey<BiomeModifier> VIRTUOUS_PAGAN = registerKey("spawn_virtuous_pagan");

    public static final ResourceKey<BiomeModifier> ADD_LIMBO_CLUMPS = registerKey("add_limbo_clumps");
    public static final ResourceKey<BiomeModifier> ADD_WHIRLING_WASTELANDS_FEATURES = registerKey("add_whirling_wastelands_features");

    public static final ResourceKey<BiomeModifier> ADD_STYX_FLUID = registerKey("add_styx_fluid");
    public static final ResourceKey<BiomeModifier> ADD_BOILING_BLOOD = registerKey("add_boiling_blood");



    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_VIRGILAGER, new BiomeModifiers.AddSpawnsBiomeModifier(

                biomes.getOrThrow(Tags.Biomes.IS_DARK_FOREST),
                WeightedList.of(List.of(new Weighted<>(new MobSpawnSettings.SpawnerData(ModEntities.VIRGILAGER.get(), 1, 1), 10)))
        ));


        context.register(ADD_LIMBO_CLUMPS, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.LIMBO)),
                HolderSet.direct(
                        placedFeatures.getOrThrow(ModPlacedFeatures.ANDESITE_CLUMP_PLACED_KEY),
                        placedFeatures.getOrThrow(ModPlacedFeatures.BLACKSTONE_CLUMP_PLACED_KEY),
                        placedFeatures.getOrThrow(ModPlacedFeatures.QUARTZ_CLUMP_PLACED_KEY),
                        placedFeatures.getOrThrow(ModPlacedFeatures.DIORITE_CLUMP_PLACED_KEY),
                        placedFeatures.getOrThrow(ModPlacedFeatures.DIRT_CLUMP_PLACED_KEY)
                        ),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WHIRLING_WASTELANDS_FEATURES, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.WHIRLING_WASTELANDS)),
                HolderSet.direct(
                        placedFeatures.getOrThrow(ModPlacedFeatures.DRIPSTONE_CLUMP_PLACED_KEY)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_STYX_FLUID, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.STYX_RIVER)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STYX_FLUID_PLACED_KEY)),
                GenerationStep.Decoration.RAW_GENERATION
        ));

        context.register(ADD_BOILING_BLOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.WOOD_OF_SUICIDES)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BOILING_BLOOD_PLACED_KEY)),
                GenerationStep.Decoration.RAW_GENERATION
        ));

    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {

        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
    }
}
