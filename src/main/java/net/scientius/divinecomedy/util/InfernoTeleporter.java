package net.scientius.divinecomedy.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.scientius.divinecomedy.DivineComedy;

import java.util.Set;

public final class InfernoTeleporter {

    private static final ResourceKey<Level> INFERNO_KEY = ResourceKey.create(
            Registries.DIMENSION,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "inferno")
    );

    private static final int SCAN_START_Y = 285;
    private static final int SCAN_END_Y = 260;
    private static final int DEFAULT_Y = 270;

    private InfernoTeleporter() {}

    /** Call this from anywhere with a ServerPlayer - Virgil, death, a block, etc. */
    public static void sendToInferno(ServerPlayer player) {
        MinecraftServer server = player.level().getServer();
        if (server == null) return;

        ServerLevel destination = server.getLevel(INFERNO_KEY);
        if (destination == null) return; // dimension not registered - bail safely


        int y = findLandingY(destination, Mth.floor(0), Mth.floor(0));

        player.teleportTo(destination, 0, y, 0, Set.of(), player.getYRot(), player.getXRot(), false);
    }

    public static void sendToOverworld(Entity entity) {
        if (entity.level().isClientSide() || entity.level().getServer() == null) {
            return;
        }

        TeleportTransition transition;


        if (entity instanceof ServerPlayer player) {
            transition = player.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING);
        }

        else {
            ServerLevel overworld = entity.level().getServer().getLevel(Level.OVERWORLD);
            if (overworld == null) return;

            var respawnData = overworld.getRespawnData();

            BlockPos surfacePos = overworld.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, respawnData.pos());

            transition = new TeleportTransition(
                    overworld,
                    surfacePos.getBottomCenter(),
                    Vec3.ZERO,
                    respawnData.yaw(),
                    0.0F,
                    TeleportTransition.DO_NOTHING
            );
        }

        if (transition != null) {
            entity.teleport(transition);
        }
    }


    private static int findLandingY(ServerLevel level, int x, int z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int y = SCAN_START_Y; y >= SCAN_END_Y; y--) {
            pos.set(x, y, z);
            boolean isAir = level.getBlockState(pos).isAir();

            pos.setY(y - 1);
            boolean belowSolid = !level.getBlockState(pos).isAir();

            if (isAir && belowSolid) {
                return y;
            }
        }
        return DEFAULT_Y;
    }
}
