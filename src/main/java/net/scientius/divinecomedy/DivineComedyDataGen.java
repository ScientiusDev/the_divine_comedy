package net.scientius.divinecomedy;

import net.scientius.divinecomedy.datagen.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = DivineComedy.MODID)
public class DivineComedyDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(
                packOutput,
                Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(ModChestLootTableProvider::new, LootContextParamSets.CHEST),
                        new LootTableProvider.SubProviderEntry(ModEntityLootTableProvider::new, LootContextParamSets.ENTITY)
                ),
                lookupProvider
        ));
        generator.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModFluidTagsProvider(packOutput, lookupProvider));

    }


}





