package net.scientius.divinecomedy.entity.client.crawler;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.scientius.divinecomedy.entity.client.ModModelLayerLocations;

public class CrawlerModel extends EntityModel<CrawlerRenderState> {
    private final ModelPart crawler;
    private final ModelPart torso;
    private final ModelPart left_arm;
    private final ModelPart lower4;
    private final ModelPart right_arm;
    private final ModelPart lower3;
    private final ModelPart right_leg;
    private final ModelPart lower2;
    private final ModelPart left_leg;
    private final ModelPart lower;
    private final ModelPart head;

    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idleAnimation;

    public CrawlerModel(ModelPart root) {
        super(root);
        this.crawler = root.getChild("crawler");
        this.torso = this.crawler.getChild("torso");
        this.left_arm = this.torso.getChild("left_arm");
        this.lower4 = this.left_arm.getChild("lower4");
        this.right_arm = this.torso.getChild("right_arm");
        this.lower3 = this.right_arm.getChild("lower3");
        this.right_leg = this.torso.getChild("right_leg");
        this.lower2 = this.right_leg.getChild("lower2");
        this.left_leg = this.torso.getChild("left_leg");
        this.lower = this.left_leg.getChild("lower");
        this.head = this.torso.getChild("head");

        walkingAnimation = CrawlerAnimations.crawling.bake(root);
        idleAnimation = CrawlerAnimations.idle.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition crawler = partdefinition.addOrReplaceChild("crawler", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 24.0F, -2.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition torso = crawler.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, -12.0F, 1.0F, 8.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, 5.0F));

        PartDefinition cube_r2 = left_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition lower4 = left_arm.addOrReplaceChild("lower4", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition cube_r3 = lower4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -1.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r4 = right_arm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 24).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition lower3 = right_arm.addOrReplaceChild("lower3", CubeListBuilder.create(), PartPose.offset(6.0F, 0.0F, 0.0F));

        PartDefinition cube_r5 = lower3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(32, 8).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_leg = torso.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(36, 16).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -6.0F));

        PartDefinition lower2 = right_leg.addOrReplaceChild("lower2", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition left_leg = torso.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 32).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -1.0F, -6.0F));

        PartDefinition lower = left_leg.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.0F, 7.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(CrawlerRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2.0f, 3.00f);
        this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);

    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 100f);
        this.head.xRot = headPitch * ((float)Math.PI / 100f);
    }
}