package net.scientius.divinecomedy.creativemodetab;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DivineComedy.MODID);

    public static final Supplier<CreativeModeTab> DIVINE_COMEDY_TAB = CREATIVE_MODE_TABS.register("divine_comedy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INFERNITE.get()))
                    .title(Component.translatable( "creativetab.divinecomedy.divine_comedy"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.INFERNITE);
                        output.accept(ModBlocks.INFERNITE_ORE);

                        output.accept(ModBlocks.SOUL_OAK_LOG);
                        output.accept(ModBlocks.SOUL_OAK_WOOD);
                        output.accept(ModBlocks.STRIPPED_SOUL_OAK_LOG);
                        output.accept(ModBlocks.STRIPPED_SOUL_OAK_WOOD);

                        output.accept(ModBlocks.SOUL_OAK_PLANKS);
                        output.accept(ModBlocks.SOUL_OAK_LEAVES);

                        output.accept(ModBlocks.SOUL_OAK_SAPLING);

                        output.accept(ModItems.STYX_FLUID_BUCKET);
                        output.accept(ModItems.BOILING_BLOOD_BUCKET);

                        output.accept(ModItems.ROCK_ROLLER_SPAWN_EGG);
                        output.accept(ModItems.VIRGILAGER_SPAWN_EGG);
                        output.accept(ModItems.CEREBUS_SPAWN_EGG);
                        output.accept(ModItems.CRAWLER_SPAWN_EGG);
                        output.accept(ModItems.HERETIC_SPAWN_EGG);
                        output.accept(ModItems.VIRTUOUS_PAGAN_SPAWN_EGG);

                        output.accept(ModBlocks.BURNING_COFFIN);


                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
