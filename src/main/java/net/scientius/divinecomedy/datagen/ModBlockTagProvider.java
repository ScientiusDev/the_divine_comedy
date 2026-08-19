package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DivineComedy.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.INFERNITE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.INFERNITE_ORE.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SOUL_OAK_LOG.get())
                .add(ModBlocks.SOUL_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_SOUL_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_SOUL_OAK_WOOD.get());

        tag(BlockTags.LEAVES)
                .add(ModBlocks.SOUL_OAK_LEAVES.get());

        tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_SOUL_OAK_SAPLING.get());

        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.SOUL_OAK_SAPLING.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.SOUL_OAK_SAPLING.get());

        tag(BlockTags.INFINIBURN_OVERWORLD)
                .add(ModBlocks.BURNING_COFFIN.get());
        tag(BlockTags.INFINIBURN_NETHER)
                .add(ModBlocks.BURNING_COFFIN.get());
        tag(BlockTags.INFINIBURN_END)
                .add(ModBlocks.BURNING_COFFIN.get());
    }
}
