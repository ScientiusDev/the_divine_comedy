package net.scientius.divinecomedy.entity.client.cerebus;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.custom.CerebusEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class CerebusRenderer extends MobRenderer<CerebusEntity, CerebusRenderState, CerebusModel> {
    public CerebusRenderer(EntityRendererProvider.Context context) {
        super(context, new CerebusModel(context.bakeLayer(ModModelLayerLocations.CEREBUS)), 0.0f);
    }

    @Override
    public Identifier getTextureLocation(CerebusRenderState renderState) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/cerebus/cerebus.png");
    }

    @Override
    public CerebusRenderState createRenderState() {
        return new CerebusRenderState();
    }

    @Override
    public void extractRenderState(CerebusEntity entity, CerebusRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.meleeAttackAnimationState.copyFrom(entity.meleeAttackAnimationState);
        state.sleepingAnimationState.copyFrom(entity.sleepingAnimationState);
        state.chargeAnimationState.copyFrom(entity.chargeAnimationState);
        state.slamAnimationState.copyFrom(entity.slamAnimationState);
        state.wakeAnimationState.copyFrom(entity.wakeAnimationState);
        state.angerAnimationState.copyFrom(entity.angerAnimationState);


    }
}
