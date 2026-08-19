package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, DivineComedy.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.PLANKS)
                .add(ModBlocks.SOUL_OAK_PLANKS.asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SOUL_OAK_LOG.asItem())
                .add(ModBlocks.SOUL_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SOUL_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_SOUL_OAK_WOOD.asItem());

        tag(ModTags.Items.SOUL_OAK_LOGS)
                .add(ModBlocks.SOUL_OAK_LOG.asItem())
                .add(ModBlocks.SOUL_OAK_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SOUL_OAK_LOG.asItem())
                .add(ModBlocks.STRIPPED_SOUL_OAK_WOOD.asItem());




    }
}
