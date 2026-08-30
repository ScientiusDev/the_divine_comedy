package net.scientius.divinecomedy.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.levelgen.feature.treedecorators.PaleMossDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.tag.ModTags;
import net.scientius.divinecomedy.worldgen.feature.AirFillConfiguration;
import net.scientius.divinecomedy.worldgen.feature.ModFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOUL_OAK_TREE_KEY = registerKey("soul_oak_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CUSTOM_PALE_OAK_KEY = registerKey("custom_pale_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_CLUMPS_KEY = registerKey("quartz_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKSTONE_CLUMPS_KEY = registerKey("blackstone_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANDESITE_CLUMPS_KEY = registerKey("andesite_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORITE_CLUMPS_KEY = registerKey("diorite_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIRT_CLUMPS_KEY = registerKey("dirt_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRIPSTONE_CLUMPS_KEY = registerKey("dripstone_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INFESTED_CLUMPS_KEY = registerKey("infested_clump");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_PILLAR_KEY = registerKey("quartz_pillar");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STYX_MUDDY_ROOTS = registerKey("styx_muddy_roots");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STYX_FLUID_BLOCK = registerKey("styx_fluid_block");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STYX_FLUID_KEY = registerKey("styx_fluid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOILING_BLOOD_KEY = registerKey("boiling_blood");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COFFIN_KEY = registerKey("coffin");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>>context) {

        register(context, SOUL_OAK_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SOUL_OAK_LOG.get()),
                new DarkOakTrunkPlacer(6, 2, 1),

                BlockStateProvider.simple(ModBlocks.SOUL_OAK_LEAVES.get().defaultBlockState()
                        .setValue(LeavesBlock.DISTANCE, 7)
                        .setValue(LeavesBlock.PERSISTENT, false)
                        .setValue(BlockStateProperties.WATERLOGGED, false)),
                new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),

                new ThreeLayersFeatureSize(1, 0, 1, 1, 2, OptionalInt.of(1))).build());

        register(context, CUSTOM_PALE_OAK_KEY, Feature.TREE,
                (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.PALE_OAK_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.PALE_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).build());

        register(context, QUARTZ_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), Blocks.QUARTZ_BLOCK.defaultBlockState(), 50));
        register(context, ANDESITE_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), Blocks.ANDESITE.defaultBlockState(), 50));
        register(context, BLACKSTONE_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), Blocks.BLACKSTONE.defaultBlockState(), 50));
        register(context, DIORITE_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), Blocks.DIORITE.defaultBlockState(), 50));
        register(context, DIRT_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.CALCITE), Blocks.DIRT.defaultBlockState(), 30));
        register(context, DRIPSTONE_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new TagMatchTest(ModTags.Blocks.WHIRLING_WASTELANDS_REPLACEABLE), Blocks.DRIPSTONE_BLOCK.defaultBlockState(), 50));
        register(context, INFESTED_CLUMPS_KEY, Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.STONE), Blocks.INFESTED_STONE.defaultBlockState(), 20));

        register(context,QUARTZ_PILLAR_KEY, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(
                List.of(
                        BlockColumnConfiguration.layer(
                                ConstantInt.of(20),
                                BlockStateProvider.simple(Blocks.QUARTZ_BLOCK)
                        )
                ),
                Direction.UP,
                BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE,
                true
        ));

        register(context, STYX_MUDDY_ROOTS, Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.MUD), Blocks.MUDDY_MANGROVE_ROOTS.defaultBlockState()
                        ))));

        register(context, STYX_FLUID_BLOCK, Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.MUD), ModBlocks.STYX_FLUID_BLOCK.get().defaultBlockState()
                        ))));




        register(context, STYX_FLUID_KEY, ModFeatures.AIR_FILL_FEATURE.get(),
                new AirFillConfiguration(128, 136, ModBlocks.STYX_FLUID_BLOCK.get().defaultBlockState()));

        register(context, BOILING_BLOOD_KEY, ModFeatures.AIR_FILL_FEATURE.get(),
                new AirFillConfiguration(64, 72, ModBlocks.BOILING_BLOOD_BLOCK.get().defaultBlockState()));

        register(context, COFFIN_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BURNING_COFFIN.get())));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name){

        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
