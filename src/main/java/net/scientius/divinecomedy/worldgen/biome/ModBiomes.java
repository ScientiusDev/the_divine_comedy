package net.scientius.divinecomedy.worldgen.biome;

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    public static final ResourceKey<Biome> LIMBO = registerBiomeKey("limbo");
    public static final ResourceKey<Biome> LUSTING_CLIFFS = registerBiomeKey("lusting_cliffs");
    public static final ResourceKey<Biome> GLUTTONOUS_CAVERNS = registerBiomeKey("gluttonous_caverns");
    public static final ResourceKey<Biome> ARID_PLAINS = registerBiomeKey("arid_plains");
    public static final ResourceKey<Biome> STYX_RIVER = registerBiomeKey("styx_river");
    public static final ResourceKey<Biome> DIS_BIOME = registerBiomeKey("dis_biome");
    public static final ResourceKey<Biome> WOOD_OF_SUICIDES = registerBiomeKey("wood_of_suicides");
    public static final ResourceKey<Biome> BOLGIA = registerBiomeKey("bolgia");
    public static final ResourceKey<Biome> FROZEN_DEPTHS = registerBiomeKey("frozen_depths");



    // Register biomes in here
    public static void bootstrap(BootstrapContext<Biome> context) {
        var carver = context.lookup(Registries.CONFIGURED_CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, LIMBO, ModInfernoBiomes.limbo(placedFeatures, carver));
        register(context, LUSTING_CLIFFS, ModInfernoBiomes.lustingCliffs(placedFeatures, carver));
        register(context, GLUTTONOUS_CAVERNS, ModInfernoBiomes.gluttonousCaverns(placedFeatures, carver));
        register(context, ARID_PLAINS, ModInfernoBiomes.aridPlains(placedFeatures, carver));
        register(context, STYX_RIVER, ModInfernoBiomes.styxRiver(placedFeatures, carver));
        register(context, DIS_BIOME, ModInfernoBiomes.disBiome(placedFeatures, carver));
        register(context, WOOD_OF_SUICIDES, ModInfernoBiomes.woodOfSuicides(placedFeatures, carver));
        register(context, BOLGIA, ModInfernoBiomes.bolgia(placedFeatures, carver));
        register(context, FROZEN_DEPTHS, ModInfernoBiomes.frozenDepths(placedFeatures, carver));
    }

    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }


    private static ResourceKey<Biome> registerBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
    }



}

