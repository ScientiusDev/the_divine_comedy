package net.scientius.divinecomedy.worldgen.biome;

import net.scientius.divinecomedy.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModInfernoBiomes {

    public static Biome limbo(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));



        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures


        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(0.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x808080)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 24.0f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 64.0f)

                .build();
    }



    public static Biome lustingCliffs(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.4f)
                .temperature(0.1f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x000000)

                .build();
    }



    public static Biome gluttonousCaverns(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(-0.5f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x292f40)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 64f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 256f)

                .build();
    }


    public static Biome aridPlains(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.0f)
                .temperature(1.4f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xaeb082)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 64f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 256f)
                .build();
    }



    public static Biome styxRiver(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.9f)
                .temperature(0.8f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x4f3f43)
                .setAttribute(EnvironmentAttributes.FOG_START_DISTANCE, 20f)
                .setAttribute(EnvironmentAttributes.FOG_END_DISTANCE, 64f)
                .build();
    }



    public static Biome disBiome(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));


        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.1f)
                .temperature(1.0f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x71736f)

                .build();
    }

    public static Biome woodOfSuicides(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_OAK_TREE_PLACED_KEY);

        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.7f)
                .temperature(1.2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x0c9999)
                        .foliageColorOverride(0x0c9999).build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x96ecf2)

                .build();
    }


    public static Biome bolgia(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures



        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.5f)
                .temperature(1.8f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xa35543)

                .build();
    }


    public static Biome frozenDepths(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // Kaupenjoe example mobs, this is where mobs go
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
//
//        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures


        // The settings

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.1f)
                .temperature(-0.7f)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .grassColorOverride(0x717871)
                        .foliageColorOverride(0x717871).build())
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0x08012b)

                .build();
    }
}
