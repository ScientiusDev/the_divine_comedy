package net.scientius.divinecomedy.block;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.custom.BossBlock;
import net.scientius.divinecomedy.block.custom.BurningCoffinBlock;
import net.scientius.divinecomedy.block.custom.InfernoExitPortal;
import net.scientius.divinecomedy.block.custom.ModFlammableRotatedPillarBlock;
import net.scientius.divinecomedy.fluid.ModFluids;
import net.scientius.divinecomedy.item.ModItems;
import net.scientius.divinecomedy.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(DivineComedy.MODID);


    // Blocks start here
    public static final DeferredBlock<Block> INFERNITE_ORE = registerBlock("infernite_ore",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<Block> SOUL_OAK_LOG = registerBlock("soul_oak_log",
            properties -> new ModFlammableRotatedPillarBlock(properties.sound(SoundType.WOOD).strength(2f)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> SOUL_OAK_WOOD = registerBlock("soul_oak_wood",
            properties -> new ModFlammableRotatedPillarBlock(properties.sound(SoundType.WOOD).strength(2f)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_SOUL_OAK_LOG = registerBlock("stripped_soul_oak_log",
            properties -> new ModFlammableRotatedPillarBlock(properties.sound(SoundType.WOOD).strength(2f)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> STRIPPED_SOUL_OAK_WOOD = registerBlock("stripped_soul_oak_wood",
            properties -> new ModFlammableRotatedPillarBlock(properties.sound(SoundType.WOOD).strength(2f)
                    .ignitedByLava()));

    public static final DeferredBlock<Block> SOUL_OAK_PLANKS = registerBlock("soul_oak_planks",
            properties -> new Block(properties.sound(SoundType.WOOD).strength(2f).ignitedByLava()) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> SOUL_OAK_LEAVES = registerBlock("soul_oak_leaves",
            properties -> new UntintedParticleLeavesBlock(0.01f, ParticleTypes.SOUL,
                    properties
                    .mapColor(MapColor.PLANT)
                    .strength(0.2f)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .isValidSpawn(Blocks::ocelotOrParrot)
                    .isSuffocating((blockState, level, blockPos) -> false)
                    .isViewBlocking((blockState, level, blockPos) -> false)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isRedstoneConductor((blockState, level, blockPos) -> false)
                            ) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> SOUL_OAK_SAPLING = registerBlock("soul_oak_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.SOUL_OAK, properties.sound(SoundType.GRASS).instabreak()
                    .randomTicks().pushReaction(PushReaction.DESTROY).noCollision()));

    public static final DeferredBlock<Block> POTTED_SOUL_OAK_SAPLING = BLOCKS.registerBlock("potted_soul_oak_sapling",
            properties -> new FlowerPotBlock(() ->(FlowerPotBlock) Blocks.FLOWER_POT, SOUL_OAK_SAPLING,properties.instabreak().noOcclusion()
                    ));

    public static final DeferredBlock<LiquidBlock> STYX_FLUID_BLOCK = BLOCKS.registerBlock("styx_fluid_block",
            properties -> new LiquidBlock(ModFluids.STYX_FLUID_SOURCE.get(), properties
                    .mapColor(MapColor.WATER). replaceable()
                    .noCollision()
                    .strength(100.0f)
                    .pushReaction(PushReaction.DESTROY)
                    .noLootTable()
                    .liquid()
                    .sound(SoundType.EMPTY)

            ));

    public static final DeferredBlock<LiquidBlock> BOILING_BLOOD_BLOCK = BLOCKS.registerBlock("boiling_blood_block",
            properties -> new LiquidBlock(ModFluids.BOILING_BLOOD_SOURCE.get(), properties
                    .mapColor(MapColor.FIRE). replaceable()
                    .noCollision()
                    .strength(100.0f)
                    .pushReaction(PushReaction.DESTROY)
                    .noLootTable()
                    .liquid()
                    .sound(SoundType.EMPTY)

            ));

    public static final DeferredBlock<Block> BURNING_COFFIN = registerBlock("burning_coffin",
            properties -> new BurningCoffinBlock(properties.sound(SoundType.STONE).pushReaction(PushReaction.IGNORE).strength(2.0f)
                    .noOcclusion()));

    public static final DeferredBlock<Block> INFERNO_EXIT_PORTAL = registerBlock("inferno_exit_portal",
            properties -> new InfernoExitPortal(properties
                    .sound(SoundType.STONE)
                    .pushReaction(PushReaction.IGNORE)
                    .strength(-1.0f)
                    .explosionResistance(3600000f)
                    .noCollision()
            ));

    public static final DeferredBlock<Block> CEREBUS_BOSS_BLOCK = registerBlock("cerebus_boss_block",
            properties -> new BossBlock(properties
                    .sound(SoundType.STONE)
                    .pushReaction(PushReaction.IGNORE)
                    .strength(-1.0f)
                    .explosionResistance(3600000f)
            ));
    public static final DeferredBlock<Block> GERYON_BOSS_BLOCK = registerBlock("geryon_boss_block",
            properties -> new BossBlock(properties
                    .sound(SoundType.STONE)
                    .pushReaction(PushReaction.IGNORE)
                    .strength(-1.0f)
                    .explosionResistance(3600000f)
            ));
    public static final DeferredBlock<Block> DIS_BOSS_BLOCK = registerBlock("dis_boss_block",
            properties -> new BossBlock(properties
                    .sound(SoundType.STONE)
                    .pushReaction(PushReaction.IGNORE)
                    .strength(-1.0f)
                    .explosionResistance(3600000f)
            ));





    // Methods used above
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    private  static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function){
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
