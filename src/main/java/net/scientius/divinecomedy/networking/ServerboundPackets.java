package net.scientius.divinecomedy.networking;


import net.scientius.divinecomedy.networking.packet.TestPacketC2S;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

// HERE WE ARE ON THE SERVER (according to kaupenjoe)
public class ServerboundPackets {
    public static void handleTestPacket(TestPacketC2S testPacketC2S, IPayloadContext context) {
        Player player = context.player();
        ServerLevel level = ((ServerLevel) player.level());
        EntityType.COW.spawn(level, player.getOnPos(), EntitySpawnReason.TRIGGERED);
        player.sendSystemMessage(Component.literal(testPacketC2S.name() + " has just said " + testPacketC2S.value()));

    }
}
