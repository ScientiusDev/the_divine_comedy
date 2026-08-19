package net.scientius.divinecomedy.entity.client.virtuous_pagan;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.client.virgilager.VirgilagerRenderState;
import net.scientius.divinecomedy.entity.custom.VirgilagerEntity;
import net.scientius.divinecomedy.entity.custom.VirtuousPaganEntity;

public class VirtuousPaganRenderer extends MobRenderer<VirtuousPaganEntity, VirtuousPaganRenderState, VirtuousPaganModel> {
    public VirtuousPaganRenderer(EntityRendererProvider.Context context) {
        super(context, new VirtuousPaganModel(context.bakeLayer(ModModelLayerLocations.VIRTUOUS_PAGAN)), 0.75f);
    }

    @Override
    public Identifier getTextureLocation(VirtuousPaganRenderState state) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/virtuous_pagan/virtuous_pagan.png");
    }

    @Override
    public VirtuousPaganRenderState createRenderState() {
        return new VirtuousPaganRenderState();
    }

    @Override
    public void extractRenderState(VirtuousPaganEntity entity, VirtuousPaganRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
