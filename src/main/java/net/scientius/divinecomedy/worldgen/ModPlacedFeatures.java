package net.scientius.divinecomedy.worldgen;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SOUL_OAK_TREE_PLACED_KEY = registerKey("soul_oak_tree_placed");
    public static final ResourceKey<PlacedFeature> CUSTOM_PALE_OAK_TREE_PLACED_KEY = registerKey("custom_pale_oak_tree_placed");

    public static final ResourceKey<PlacedFeature> QUARTZ_CLUMP_PLACED_KEY = registerKey("quartz_clump_placed_placed");
    public static final ResourceKey<PlacedFeature> ANDESITE_CLUMP_PLACED_KEY = registerKey("andesite_clump_placed_placed");
    public static final ResourceKey<PlacedFeature> BLACKSTONE_CLUMP_PLACED_KEY = registerKey("blackstone_clump_placed_placed");
    public static final ResourceKey<PlacedFeature> DIORITE_CLUMP_PLACED_KEY = registerKey("diorite_clump_placed_placed");
    public static final ResourceKey<PlacedFeature> DIRT_CLUMP_PLACED_KEY = registerKey("dirt_clump_placed_placed");

    public static final ResourceKey<PlacedFeature> STYX_FLUID_PLACED_KEY = registerKey("styx_fluid_placed");
    public static final ResourceKey<PlacedFeature> BOILING_BLOOD_PLACED_KEY = registerKey("boiling_blood_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SOUL_OAK_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOUL_OAK_TREE_KEY),
                List.of(
                        PlacementUtils.countExtra(8, 0.2f, 4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(70), VerticalAnchor.absolute(80)),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.matchesBlocks(
                                        new Vec3i(0, -1, 0),
                                        List.of(Blocks.GRASS_BLOCK) // Directly checks if the block 1 block below the feature is grass
                                )
                        ),
                        BiomeFilter.biome()
                ));

        register(context, CUSTOM_PALE_OAK_TREE_PLACED_KEY, configuredFeatures.getOrThrow(TreeFeatures.PALE_OAK),
                List.of(
                        PlacementUtils.countExtra(8, 0.2f, 4),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(260), VerticalAnchor.absolute(267)),
                        BlockPredicateFilter.forPredicate(
                                BlockPredicate.wouldSurvive(Blocks.PALE_OAK_SAPLING.defaultBlockState(), new Vec3i(0, -1, 0))),
                        BiomeFilter.biome()
                ));


        register(context, QUARTZ_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUARTZ_CLUMPS_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(288))
                        ));
        register(context, ANDESITE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANDESITE_CLUMPS_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(288))
                ));
        register(context, BLACKSTONE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLACKSTONE_CLUMPS_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(288))
                ));
        register(context, DIORITE_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DIORITE_CLUMPS_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(288))
                ));
        register(context, DIRT_CLUMP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DIRT_CLUMPS_KEY),
                ModOrePlacements.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(288))
                ));

        // For Styx River (if its layer is 128 to 160)
        register(context, STYX_FLUID_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STYX_FLUID_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(140), VerticalAnchor.absolute(150)), // MATCH YOUR LAYER BOUNDS!
                        BiomeFilter.biome()
                ));

// For Boiling Blood / Wood of Suicides (if its layer is a different range, e.g., 64 to 96)
        register(context, BOILING_BLOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOILING_BLOOD_KEY),
                List.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(70), VerticalAnchor.absolute(80)), // MATCH THAT LAYER'S BOUNDS!
                        BiomeFilter.biome()
                ));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}