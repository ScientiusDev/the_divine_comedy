package net.scientius.divinecomedy.entity.client.virgilager;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;
import net.scientius.divinecomedy.entity.custom.VirgilagerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class VirgilagerRenderer extends MobRenderer<VirgilagerEntity, VirgilagerRenderState, VirgilagerModel> {

    public VirgilagerRenderer(EntityRendererProvider.Context context) {
        super(context, new VirgilagerModel(context.bakeLayer(ModModelLayerLocations.VIRGILAGER)), 0.75f);
    }

    @Override
    public Identifier getTextureLocation(VirgilagerRenderState virgilagerRenderState) {
        return Identifier.fromNamespaceAndPath(DivineComedy.MODID, "textures/entity/virgilager/virgilager.png");
    }

    @Override
    public VirgilagerRenderState createRenderState() {
        return new VirgilagerRenderState();
    }



    @Override
    public void extractRenderState(VirgilagerEntity entity, VirgilagerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
        state.interactAnimationState.copyFrom(entity.interactAnimationState);
        state.descendAnimationState.copyFrom(entity.descendAnimationState);
    }

}
