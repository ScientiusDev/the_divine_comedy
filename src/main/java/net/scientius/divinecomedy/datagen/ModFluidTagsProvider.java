package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DivineComedy.MODID);
    }


    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(FluidTags.WATER)
                .add(ModFluids.STYX_FLUID_SOURCE.get())
                .add(ModFluids.STYX_FLUID_FLOWING.get())
                .add(ModFluids.BOILING_BLOOD_FLOWING.get())
                .add(ModFluids.BOILING_BLOOD_SOURCE.get());

    }
}
