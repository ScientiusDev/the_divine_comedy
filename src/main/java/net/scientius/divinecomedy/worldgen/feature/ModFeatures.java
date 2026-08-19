package net.scientius.divinecomedy.worldgen.feature; // Or wherever your feature classes are

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFeatures {
    // Creates the registry for Features under your mod ID
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, DivineComedy.MODID);

    // Registers your specific custom feature blueprint!
    public static final Supplier<Feature<AirFillConfiguration>> AIR_FILL_FEATURE =
            FEATURES.register("air_fill", () -> new AirFillFeature(AirFillConfiguration.CODEC));
}