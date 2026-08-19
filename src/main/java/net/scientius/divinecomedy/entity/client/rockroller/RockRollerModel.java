package net.scientius.divinecomedy.entity.client.rockroller;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RockRollerModel  extends EntityModel<RockRollerRenderState> {

    private final ModelPart rock_roller;
    private final ModelPart roller;
    private final ModelPart upperbody;
    private final ModelPart armleft;
    private final ModelPart armright;
    private final ModelPart head;
    private final ModelPart lowerbody;
    private final ModelPart legleft;
    private final ModelPart legright;
    private final ModelPart rock;

    // Animations
    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idleAnimation;

    public RockRollerModel(ModelPart root) {
        super(root);
        this.rock_roller = root.getChild("rock_roller");
        this.roller = this.rock_roller.getChild("roller");
        this.upperbody = this.roller.getChild("upperbody");
        this.armleft = this.upperbody.getChild("armleft");
        this.armright = this.upperbody.getChild("armright");
        this.head = this.upperbody.getChild("head");
        this.lowerbody = this.roller.getChild("lowerbody");
        this.legleft = this.lowerbody.getChild("legleft");
        this.legright = this.lowerbody.getChild("legright");
        this.rock = this.rock_roller.getChild("rock");


        walkingAnimation = RockRollerAnimations.walking.bake(root);
        idleAnimation = RockRollerAnimations.idle.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition rock_roller = partdefinition.addOrReplaceChild("rock_roller", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition roller = rock_roller.addOrReplaceChild("roller", CubeListBuilder.create(), PartPose.offset(-25.0F, 4.0F, -7.0F));

        PartDefinition upperbody = roller.addOrReplaceChild("upperbody", CubeListBuilder.create().texOffs(112, 0).addBox(-2.0F, -12.0F, -4.0F, 4.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.0F, 8.0F, 7.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition armleft = upperbody.addOrReplaceChild("armleft", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 5.0F));

        PartDefinition arm_left_r1 = armleft.addOrReplaceChild("arm_left_r1", CubeListBuilder.create().texOffs(112, 116).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.4399F));

        PartDefinition armright = upperbody.addOrReplaceChild("armright", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, -4.0F));

        PartDefinition arm_right_r1 = armright.addOrReplaceChild("arm_right_r1", CubeListBuilder.create().texOffs(112, 100).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1305F, 0.079F, 1.1201F));

        PartDefinition head = upperbody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 104).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        PartDefinition lowerbody = roller.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(25.0F, 0.0F, 8.0F));

        PartDefinition legleft = lowerbody.addOrReplaceChild("legleft", CubeListBuilder.create().texOffs(112, 68).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.002F)), PartPose.offset(1.0F, 8.0F, 1.0F));

        PartDefinition legright = lowerbody.addOrReplaceChild("legright", CubeListBuilder.create().texOffs(112, 84).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(-0.002F)), PartPose.offset(0.0F, 8.0F, -3.0F));

        PartDefinition rock = rock_roller.addOrReplaceChild("rock", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -6.0F, 16.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 104).addBox(-16.0F, -8.0F, -6.0F, 8.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(112, 20).addBox(-12.0F, 8.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(112, 32).addBox(8.0F, 8.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(112, 44).addBox(8.0F, -12.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(112, 56).addBox(-12.0F, -12.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(40, 104).addBox(8.0F, -8.0F, -6.0F, 8.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 84).addBox(-8.0F, -16.0F, -6.0F, 16.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(56, 84).addBox(-8.0F, 8.0F, -6.0F, 16.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 56).addBox(-4.0F, -12.0F, -10.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(56, 0).addBox(-4.0F, 4.0F, -10.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(56, 28).addBox(-12.0F, -4.0F, -10.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(56, 56).addBox(4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, 8.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(RockRollerRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);


    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 100f);
        this.head.xRot = headPitch * ((float)Math.PI / 100f);
    }

}
