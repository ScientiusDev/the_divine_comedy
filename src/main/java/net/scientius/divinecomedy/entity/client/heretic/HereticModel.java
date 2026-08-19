package net.scientius.divinecomedy.entity.client.heretic;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class HereticModel extends EntityModel<HereticRenderState> {


    private final ModelPart swirling_spirit;
    private final ModelPart torso;
    private final ModelPart arm1;
    private final ModelPart arm2;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart head;
    private final ModelPart hat;

    public final KeyframeAnimation walkingAnimation;
    public final KeyframeAnimation idleAnimation;
    public final KeyframeAnimation freedAnimation;

    public HereticModel(ModelPart root) {
        super(root);
        this.swirling_spirit = root.getChild("swirling_spirit");
        this.torso = this.swirling_spirit.getChild("torso");
        this.arm1 = this.torso.getChild("arm1");
        this.arm2 = this.torso.getChild("arm2");
        this.leg1 = this.torso.getChild("leg1");
        this.leg2 = this.torso.getChild("leg2");
        this.head = this.torso.getChild("head");
        this.hat = this.head.getChild("hat");

        walkingAnimation = HereticAnimations.walking.bake(root);
        idleAnimation = HereticAnimations.idle.bake(root);
        freedAnimation = HereticAnimations.freed.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition swirling_spirit = partdefinition.addOrReplaceChild("swirling_spirit", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition torso = swirling_spirit.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(40, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(-0.005F))
                .texOffs(0, 0).addBox(-4.0F, -5.5F, -3.0F, 8.0F, 20.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -10.0F, 1.0F));

        PartDefinition arm1 = torso.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(28, 55).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, 0.0F));

        PartDefinition arm2 = torso.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(44, 55).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -4.0F, 0.0F));

        PartDefinition leg1 = torso.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(2.0F, 6.0F, 0.0F));

        PartDefinition cube_r1 = leg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition leg2 = torso.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-2.0F, 6.0F, 0.0F));

        PartDefinition cube_r2 = leg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 39).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 39).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.002F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 26).addBox(-5.0F, -8.0F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(60, 55).addBox(1.0F, -8.0F, 4.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(-0.002F))
                .texOffs(0, 62).addBox(-5.0F, -8.0F, 4.0F, 4.0F, 12.0F, 2.0F, new CubeDeformation(-0.002F))
                .texOffs(60, 12).addBox(-5.0F, -10.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 32).addBox(-5.0F, -11.0F, -5.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).addBox(-5.0F, -11.0F, 1.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(-4.0F, -14.0F, 2.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(60, 6).addBox(-4.0F, -14.0F, -5.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 16).addBox(-2.0F, -17.0F, -4.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 21).addBox(-2.0F, -17.0F, 2.0F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(HereticRenderState state) {
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