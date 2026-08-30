package net.scientius.divinecomedy.event;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.skeleton.Stray;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.scientius.divinecomedy.Config;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.entity.custom.*;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.scientius.divinecomedy.util.InfernoTeleporter;
import net.scientius.divinecomedy.worldgen.biome.ModBiomes;
import net.scientius.divinecomedy.worldgen.dimension.ModDimensions;

import java.util.List;
import java.util.Scanner;

@EventBusSubscriber(modid = DivineComedy.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1"); //.executesOn(HandlerThread.MAIN);

    }



    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ROCK_ROLLER.get(), RockRollerEntity.createRockRollerAttributes().build());
        event.put(ModEntities.VIRGILAGER.get(), VirgilagerEntity.createVirgilagerAttributes().build());
        event.put(ModEntities.CEREBUS.get(), CerebusEntity.createCerebusAttributes().build());
        event.put(ModEntities.CRAWLER.get(), CrawlerEntity.createCrawlerAttributes().build());
        event.put(ModEntities.HERETIC.get(), HereticEntity.createHereticAttributes().build());
        event.put(ModEntities.VIRTUOUS_PAGAN.get(), VirtuousPaganEntity.createVirtuousPaganAttributes().build());
    }

    @SubscribeEvent
    public static void registerMobPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.ROCK_ROLLER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.VIRGILAGER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.CEREBUS.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.CRAWLER.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ModEntities.VIRTUOUS_PAGAN.get(), SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

    }


    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.isEndConquered() && event.getEntity() instanceof ServerPlayer player && Config.DESCEND_ON_DEATH.getAsBoolean()) {

            // If they have a saved position AND they successfully spawned in that dimension,
            // it means they safely spawned at their bed/anchor.
            boolean spawnedAtPersonalSpawn =  player.level().dimension() == ModDimensions.INFERNO_LEVEL_KEY;

            // Only send them to the default Inferno spawn if they didn't have a valid bed/anchor
            if (!spawnedAtPersonalSpawn) {
                InfernoTeleporter.sendToInferno(player);
            }
        }
    }


    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;

        if (event.getEntity().getType() == EntityType.SKELETON
                && event.getLevel().getBiome(event.getEntity().getOnPos()).is(ModBiomes.FROZEN_DEPTHS)) {

            Skeleton oldSkeleton = (Skeleton) event.getEntity();
            ServerLevel level = (ServerLevel) event.getLevel();

            Stray stray = EntityType.STRAY.create(level, EntitySpawnReason.CONVERSION);
            if (stray != null) {
                stray.setPos(oldSkeleton.getX(), oldSkeleton.getY(), oldSkeleton.getZ()
                );
                stray.finalizeSpawn(level, level.getCurrentDifficultyAt(oldSkeleton.blockPosition()),
                        EntitySpawnReason.CONVERSION, null);

                event.setCanceled(true);
                level.addFreshEntity(stray);
            }
        }
    }

}
