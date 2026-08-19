package net.scientius.divinecomedy;

import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.creativemodetab.ModCreativeModTabs;
import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.fluid.ModFluidTypes;
import net.scientius.divinecomedy.fluid.ModFluids;
import net.scientius.divinecomedy.item.ModItems;
import net.scientius.divinecomedy.worldgen.dimension.ModBiomeSources;
import net.scientius.divinecomedy.worldgen.feature.ModFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DivineComedy.MODID)
public class DivineComedy {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "divinecomedy";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.


    // Make sure DENSITY_FUNCTIONS.register(modEventBus) is called in your main constructor!
    public DivineComedy(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBiomeSources.BIOME_SOURCES.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);

        ModFluidTypes.register(modEventBus);

        ModFluids.register(modEventBus);

        ModEntities.register(modEventBus);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (DanteReimaginedTheDivineComedy) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);



        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SOUL_OAK_SAPLING.getId(), ModBlocks.POTTED_SOUL_OAK_SAPLING);

        });



    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // this is not needed as I made a custom tab, keeping just in case
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(ModItems.INFERNITE);
//        }
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
