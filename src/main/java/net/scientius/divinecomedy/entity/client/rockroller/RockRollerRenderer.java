package net.scientius.divinecomedy.entity.client.rockroller;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.custom.RockRollerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class RockRollerRenderer extends MobRenderer<RockRollerEntity, RockRollerRenderState, RockRollerModel> {


    public RockRollerRenderer(EntityRendererProvider.Context context) {
        super(context, new RockRollerModel(context.bakeLayer(ModModelLayerLocations.ROCK_ROLLER)), 0.75f);
    }

    @Override
    public Identifier getTextureLocation(RockRollerRenderState rockRollerRenderState) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/rock_roller/rock_roller.png");
    }

    @Override
    public RockRollerRenderState createRenderState() {
        return new RockRollerRenderState();
    }

    // For babies I think
//    @Override
//    public void submit(RockRollerRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
//        super.submit(state, poseStack, submitNodeCollector, camera);
//    }

    @Override
    public void extractRenderState(RockRollerEntity entity, RockRollerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
