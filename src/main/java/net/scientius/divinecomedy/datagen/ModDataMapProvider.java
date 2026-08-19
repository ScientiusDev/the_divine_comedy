package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {


    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {

        builder(NeoForgeDataMaps.STRIPPABLES)
                .add(ModBlocks.SOUL_OAK_LOG, new Strippable(ModBlocks.STRIPPED_SOUL_OAK_LOG.get()), false)
                .add(ModBlocks.SOUL_OAK_WOOD, new Strippable(ModBlocks.STRIPPED_SOUL_OAK_WOOD.get()), false);

    }
}
