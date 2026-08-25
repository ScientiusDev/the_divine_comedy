package net.scientius.divinecomedy.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.levelgen.feature.DripstoneClusterFeature;
import net.scientius.divinecomedy.entity.ModEntities;
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
        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(ModEntities.VIRTUOUS_PAGAN.get(), 1, 2))
                .addMobCharge(ModEntities.VIRTUOUS_PAGAN.get(), 2.0d, 1.0d);

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 1, 2))
                .addMobCharge(EntityType.SKELETON, 2.0d, 1.0d);


        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                placedFeatureGetter.getOrThrow(TreePlacements.PALE_OAK_CHECKED));



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


    public static Biome whirlingWastelands(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.BREEZE, 1, 1))
                .addMobCharge(EntityType.BREEZE, 4.0d, 1.0d);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION,
                placedFeatureGetter.getOrThrow(ResourceKey.create(Registries.PLACED_FEATURE, Identifier.withDefaultNamespace("dripstone_cluster"))));


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

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 1, 1))
                .addMobCharge(EntityType.WITHER_SKELETON, 2.0d, 1.0d);
        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(ModEntities.CRAWLER.get(), 1, 3))
                .addMobCharge(ModEntities.CRAWLER.get(), 2.0d, 1.0d);



//
//

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


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

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(ModEntities.ROCK_ROLLER.get(), 1, 3))
                .addMobCharge(ModEntities.ROCK_ROLLER.get(), 2.0d, 1.0d);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


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

        spawnBuilder.addSpawn(MobCategory.MONSTER, 50, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 1, 1))
                .addMobCharge(EntityType.GHAST, 2.0d, 1.0d);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


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


    public static Biome depthsOfDis(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();




        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


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

        // Placed features

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SOUL_OAK_TREE_PLACED_KEY);



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


    public static Biome malebolge(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {


        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);

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


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);


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
