package net.scientius.divinecomedy;

import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.client.cerebus.CerebusModel;
import net.scientius.divinecomedy.entity.client.cerebus.CerebusRenderer;
import net.scientius.divinecomedy.entity.client.crawler.CrawlerModel;
import net.scientius.divinecomedy.entity.client.crawler.CrawlerRenderer;
import net.scientius.divinecomedy.entity.client.heretic.HereticModel;
import net.scientius.divinecomedy.entity.client.heretic.HereticRenderer;
import net.scientius.divinecomedy.entity.client.rockroller.RockRollerModel;
import net.scientius.divinecomedy.entity.client.rockroller.RockRollerRenderer;
import net.scientius.divinecomedy.entity.client.virgilager.VirgilagerModel;
import net.scientius.divinecomedy.entity.client.virgilager.VirgilagerRenderer;
import net.scientius.divinecomedy.entity.client.virtuous_pagan.VirtuousPaganModel;
import net.scientius.divinecomedy.entity.client.virtuous_pagan.VirtuousPaganRenderer;
import net.scientius.divinecomedy.fluid.ModFluidTypes;
import net.scientius.divinecomedy.fluid.ModFluids;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterFluidModelsEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = DivineComedy.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = DivineComedy.MODID, value = Dist.CLIENT)


public class DivineComedyClient {
    public DivineComedyClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.ROCK_ROLLER.get(), RockRollerRenderer::new);
        EntityRenderers.register(ModEntities.VIRGILAGER.get(), VirgilagerRenderer::new);
        EntityRenderers.register(ModEntities.CEREBUS.get(), CerebusRenderer::new);
        EntityRenderers.register(ModEntities.CRAWLER.get(), CrawlerRenderer::new);
        EntityRenderers.register(ModEntities.HERETIC.get(), HereticRenderer::new);
        EntityRenderers.register(ModEntities.VIRTUOUS_PAGAN.get(), VirtuousPaganRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayerLocations.ROCK_ROLLER, RockRollerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.VIRGILAGER, VirgilagerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.CEREBUS, CerebusModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.CRAWLER, CrawlerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.HERETIC, HereticModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayerLocations.VIRTUOUS_PAGAN, VirtuousPaganModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerOnClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(ModFluidTypes.STYX_FLUID_EXTENSION, ModFluidTypes.STYX_FLUID_TYPE.get());
        event.registerFluidType(ModFluidTypes.BOILING_BLOOD_EXTENSION, ModFluidTypes.BOILING_BLOOD_TYPE.get());
    }


    @SubscribeEvent
    public static void registerFluidModelsEvent(RegisterFluidModelsEvent event) {
        FluidModel.Unbaked styxFluidModel = new FluidModel.Unbaked(
                new Material(Identifier.fromNamespaceAndPath(DivineComedy.MODID,"block/water_still")),
                new Material(Identifier.fromNamespaceAndPath(DivineComedy.MODID,"block/water_flow")),
                new Material(Identifier.fromNamespaceAndPath(DivineComedy.MODID,"block/water_overlay")),
                state -> 0xe67a7368
        );
        FluidModel.Unbaked boilingBloodModel = new FluidModel.Unbaked(
                new Material(Identifier.withDefaultNamespace("block/water_still")),
                new Material(Identifier.withDefaultNamespace("block/water_flow")),
                new Material(Identifier.withDefaultNamespace("block/water_overlay")),
                state -> 0xff6b1a1a
        );
    event.register(styxFluidModel, ModFluids.STYX_FLUID_SOURCE.get());
    event.register(styxFluidModel, ModFluids.STYX_FLUID_FLOWING.get());
    event.register(boilingBloodModel, ModFluids.BOILING_BLOOD_SOURCE.get());
    event.register(boilingBloodModel, ModFluids.BOILING_BLOOD_FLOWING.get());

    }
}
