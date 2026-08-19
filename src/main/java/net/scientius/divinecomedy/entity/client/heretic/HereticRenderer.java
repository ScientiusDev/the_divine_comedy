package net.scientius.divinecomedy.entity.client.heretic;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.custom.HereticEntity;

public class HereticRenderer extends MobRenderer<HereticEntity, HereticRenderState, HereticModel> {
    public HereticRenderer(EntityRendererProvider.Context context) {
        super(context,new HereticModel(context.bakeLayer(ModModelLayerLocations.HERETIC)), 0.75f);
    }

    @Override
    public HereticRenderState createRenderState() {
        return new HereticRenderState();
    }

    @Override
    public Identifier getTextureLocation(HereticRenderState hereticRenderState) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/heretic/heretic.png");
    }

    @Override
    public void extractRenderState(HereticEntity entity, HereticRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
