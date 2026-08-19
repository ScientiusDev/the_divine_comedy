package net.scientius.divinecomedy.entity.client.virgilager;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class VirgilagerRenderState extends LivingEntityRenderState {
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState descendAnimationState = new AnimationState();
    public final AnimationState interactAnimationState = new AnimationState();
}
