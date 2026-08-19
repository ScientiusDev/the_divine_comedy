package net.scientius.divinecomedy.entity.client.cerebus;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CerebusModel extends EntityModel<CerebusRenderState> {

    private final ModelPart body;
    private final ModelPart bodyback;
    private final ModelPart backleg1;
    private final ModelPart lowerleg3;
    private final ModelPart paw2;
    private final ModelPart claws2;
    private final ModelPart claw4;
    private final ModelPart claw5;
    private final ModelPart claw6;
    private final ModelPart backleg2;
    private final ModelPart lowerleg5;
    private final ModelPart paw3;
    private final ModelPart claws3;
    private final ModelPart claw7;
    private final ModelPart claw8;
    private final ModelPart claw9;
    private final ModelPart tail;
    private final ModelPart bodyfront;
    private final ModelPart frontleg1;
    private final ModelPart lowerleg2;
    private final ModelPart paw;
    private final ModelPart claws;
    private final ModelPart claw;
    private final ModelPart claw2;
    private final ModelPart claw3;
    private final ModelPart frontleg2;
    private final ModelPart lowerleg6;
    private final ModelPart paw5;
    private final ModelPart claws5;
    private final ModelPart claw13;
    private final ModelPart claw14;
    private final ModelPart claw15;
    private final ModelPart headmiddle;
    private final ModelPart allbutneck;
    private final ModelPart snout;
    private final ModelPart upper;
    private final ModelPart lower;
    private final ModelPart ear1;
    private final ModelPart ear2;
    private final ModelPart eye2;
    private final ModelPart eye1;
    private final ModelPart headside1;
    private final ModelPart allbutneck2;
    private final ModelPart snout2;
    private final ModelPart upper2;
    private final ModelPart lower2;
    private final ModelPart ear3;
    private final ModelPart ear4;
    private final ModelPart eye3;
    private final ModelPart eye4;
    private final ModelPart headside2;
    private final ModelPart allbutneck3;
    private final ModelPart snout3;
    private final ModelPart upper3;
    private final ModelPart lower3;
    private final ModelPart ear5;
    private final ModelPart ear6;
    private final ModelPart eye5;
    private final ModelPart eye6;

    //Animations

    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation meleeAttackAnimation;
    private final KeyframeAnimation sleepingAnimation;
    private final KeyframeAnimation chargeAnimation;
    private final KeyframeAnimation slamAnimation;
    private final KeyframeAnimation wakeAnimation;
    private final KeyframeAnimation angerAnimation;

    public CerebusModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.bodyback = this.body.getChild("bodyback");
        this.backleg1 = this.bodyback.getChild("backleg1");
        this.lowerleg3 = this.backleg1.getChild("lowerleg3");
        this.paw2 = this.lowerleg3.getChild("paw2");
        this.claws2 = this.paw2.getChild("claws2");
        this.claw4 = this.claws2.getChild("claw4");
        this.claw5 = this.claws2.getChild("claw5");
        this.claw6 = this.claws2.getChild("claw6");
        this.backleg2 = this.bodyback.getChild("backleg2");
        this.lowerleg5 = this.backleg2.getChild("lowerleg5");
        this.paw3 = this.lowerleg5.getChild("paw3");
        this.claws3 = this.paw3.getChild("claws3");
        this.claw7 = this.claws3.getChild("claw7");
        this.claw8 = this.claws3.getChild("claw8");
        this.claw9 = this.claws3.getChild("claw9");
        this.tail = this.bodyback.getChild("tail");
        this.bodyfront = this.body.getChild("bodyfront");
        this.frontleg1 = this.bodyfront.getChild("frontleg1");
        this.lowerleg2 = this.frontleg1.getChild("lowerleg2");
        this.paw = this.lowerleg2.getChild("paw");
        this.claws = this.paw.getChild("claws");
        this.claw = this.claws.getChild("claw");
        this.claw2 = this.claws.getChild("claw2");
        this.claw3 = this.claws.getChild("claw3");
        this.frontleg2 = this.bodyfront.getChild("frontleg2");
        this.lowerleg6 = this.frontleg2.getChild("lowerleg6");
        this.paw5 = this.lowerleg6.getChild("paw5");
        this.claws5 = this.paw5.getChild("claws5");
        this.claw13 = this.claws5.getChild("claw13");
        this.claw14 = this.claws5.getChild("claw14");
        this.claw15 = this.claws5.getChild("claw15");
        this.headmiddle = this.bodyfront.getChild("headmiddle");
        this.allbutneck = this.headmiddle.getChild("allbutneck");
        this.snout = this.allbutneck.getChild("snout");
        this.upper = this.snout.getChild("upper");
        this.lower = this.snout.getChild("lower");
        this.ear1 = this.allbutneck.getChild("ear1");
        this.ear2 = this.allbutneck.getChild("ear2");
        this.eye2 = this.allbutneck.getChild("eye2");
        this.eye1 = this.allbutneck.getChild("eye1");
        this.headside1 = this.bodyfront.getChild("headside1");
        this.allbutneck2 = this.headside1.getChild("allbutneck2");
        this.snout2 = this.allbutneck2.getChild("snout2");
        this.upper2 = this.snout2.getChild("upper2");
        this.lower2 = this.snout2.getChild("lower2");
        this.ear3 = this.allbutneck2.getChild("ear3");
        this.ear4 = this.allbutneck2.getChild("ear4");
        this.eye3 = this.allbutneck2.getChild("eye3");
        this.eye4 = this.allbutneck2.getChild("eye4");
        this.headside2 = this.bodyfront.getChild("headside2");
        this.allbutneck3 = this.headside2.getChild("allbutneck3");
        this.snout3 = this.allbutneck3.getChild("snout3");
        this.upper3 = this.snout3.getChild("upper3");
        this.lower3 = this.snout3.getChild("lower3");
        this.ear5 = this.allbutneck3.getChild("ear5");
        this.ear6 = this.allbutneck3.getChild("ear6");
        this.eye5 = this.allbutneck3.getChild("eye5");
        this.eye6 = this.allbutneck3.getChild("eye6");

        //Animations

        walkingAnimation = CerebusAnimations.walking.bake(root);
        idleAnimation = CerebusAnimations.idle.bake(root);
        meleeAttackAnimation = CerebusAnimations.attack.bake(root);
        sleepingAnimation = CerebusAnimations.sleeping.bake(root);
        chargeAnimation = CerebusAnimations.charge.bake(root);
        slamAnimation = CerebusAnimations.slam.bake(root);
        wakeAnimation = CerebusAnimations.awakening.bake(root);
        angerAnimation= CerebusAnimations.angered.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-1.5F, -40.5F, -23.75F));

        PartDefinition bodyback = body.addOrReplaceChild("bodyback", CubeListBuilder.create().texOffs(0, 0).addBox(-13.999F, -18.499F, -17.501F, 32.0F, 40.0F, 80.0F, new CubeDeformation(-0.008F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition backleg1 = bodyback.addOrReplaceChild("backleg1", CubeListBuilder.create(), PartPose.offset(9.5F, 3.0F, 55.5F));

        PartDefinition cube_r1 = backleg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(224, 0).addBox(-3.996F, 0.508F, -9.504F, 14.0F, 47.0F, 17.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.5F, -10.0F, -4.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition lowerleg3 = backleg1.addOrReplaceChild("lowerleg3", CubeListBuilder.create(), PartPose.offset(3.0F, 31.0F, 11.5F));

        PartDefinition cube_r2 = lowerleg3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 338).addBox(-4.996F, -7.996F, -4.504F, 10.0F, 25.0F, 10.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.5F, 6.0F, -2.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition paw2 = lowerleg3.addOrReplaceChild("paw2", CubeListBuilder.create().texOffs(226, 312).addBox(-6.996F, 0.004F, -8.504F, 14.0F, 10.0F, 16.0F, new CubeDeformation(-0.008F)), PartPose.offset(0.0F, 21.0F, -6.0F));

        PartDefinition cube_r3 = paw2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(144, 296).addBox(2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.5F, 15.5F, -0.829F, 0.0F, 0.0F));

        PartDefinition cube_r4 = paw2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(112, 208).addBox(1.0F, 1.0F, -1.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.5F, 5.5F, 0.48F, 0.0F, 0.0F));

        PartDefinition claws2 = paw2.addOrReplaceChild("claws2", CubeListBuilder.create(), PartPose.offset(-14.0F, 10.5F, -9.5F));

        PartDefinition claw4 = claws2.addOrReplaceChild("claw4", CubeListBuilder.create().texOffs(92, 264).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(10.0F, -8.0F, 1.0F));

        PartDefinition cube_r5 = claw4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(144, 208).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw5 = claws2.addOrReplaceChild("claw5", CubeListBuilder.create().texOffs(286, 40).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(14.5F, -8.0F, 1.0F));

        PartDefinition cube_r6 = claw5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(256, 104).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw6 = claws2.addOrReplaceChild("claw6", CubeListBuilder.create().texOffs(226, 293).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(19.0F, -8.0F, 1.0F));

        PartDefinition cube_r7 = claw6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(286, 53).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition backleg2 = bodyback.addOrReplaceChild("backleg2", CubeListBuilder.create(), PartPose.offset(-6.5F, 3.0F, 55.5F));

        PartDefinition cube_r8 = backleg2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(224, 0).mirror().addBox(-10.004F, 0.508F, -9.504F, 14.0F, 47.0F, 17.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.5F, -10.0F, -4.0F, 0.3054F, 0.0F, 0.0F));

        PartDefinition lowerleg5 = backleg2.addOrReplaceChild("lowerleg5", CubeListBuilder.create(), PartPose.offset(-4.0F, 31.0F, 11.5F));

        PartDefinition cube_r9 = lowerleg5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 338).mirror().addBox(-5.004F, -7.996F, -4.504F, 10.0F, 25.0F, 10.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.5F, 6.0F, -2.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition paw3 = lowerleg5.addOrReplaceChild("paw3", CubeListBuilder.create().texOffs(226, 312).mirror().addBox(-7.004F, 0.004F, -8.504F, 14.0F, 10.0F, 16.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(1.0F, 21.0F, -6.0F));

        PartDefinition cube_r10 = paw3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(144, 296).mirror().addBox(-4.0F, 2.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -2.5F, 15.5F, -0.829F, 0.0F, 0.0F));

        PartDefinition cube_r11 = paw3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(112, 208).mirror().addBox(-5.0F, 1.0F, -1.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.5F, 5.5F, 0.48F, 0.0F, 0.0F));

        PartDefinition claws3 = paw3.addOrReplaceChild("claws3", CubeListBuilder.create(), PartPose.offset(14.0F, 10.5F, -9.5F));

        PartDefinition claw7 = claws3.addOrReplaceChild("claw7", CubeListBuilder.create().texOffs(92, 264).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-10.0F, -8.0F, 1.0F));

        PartDefinition cube_r12 = claw7.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(144, 208).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw8 = claws3.addOrReplaceChild("claw8", CubeListBuilder.create().texOffs(286, 40).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-14.5F, -8.0F, 1.0F));

        PartDefinition cube_r13 = claw8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(256, 104).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw9 = claws3.addOrReplaceChild("claw9", CubeListBuilder.create().texOffs(226, 293).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-19.0F, -8.0F, 1.0F));

        PartDefinition cube_r14 = claw9.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(286, 53).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition tail = bodyback.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 60.0F));

        PartDefinition cube_r15 = tail.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 264).addBox(-4.996F, 0.004F, -4.504F, 10.0F, 64.0F, 10.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9163F, 0.0F, 0.0F));

        PartDefinition bodyfront = body.addOrReplaceChild("bodyfront", CubeListBuilder.create().texOffs(0, 120).addBox(-22.0F, -26.5F, -17.5F, 48.0F, 56.0F, 32.0F, new CubeDeformation(0.008F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition frontleg1 = bodyfront.addOrReplaceChild("frontleg1", CubeListBuilder.create().texOffs(40, 304).addBox(-1.496F, -6.492F, -4.504F, 10.0F, 40.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, 9.0F, -2.0F));

        PartDefinition lowerleg2 = frontleg1.addOrReplaceChild("lowerleg2", CubeListBuilder.create().texOffs(346, 95).addBox(-1.996F, -5.496F, -4.504F, 10.0F, 19.0F, 10.0F, new CubeDeformation(-0.008F)), PartPose.offset(0.5F, 34.5F, 0.0F));

        PartDefinition paw = lowerleg2.addOrReplaceChild("paw", CubeListBuilder.create().texOffs(226, 312).addBox(-3.996F, 62.004F, -8.504F, 14.0F, 10.0F, 16.0F, new CubeDeformation(-0.008F)), PartPose.offset(-0.5F, -50.5F, 0.0F));

        PartDefinition cube_r16 = paw.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(144, 296).addBox(2.0F, 2.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 59.5F, 15.5F, -0.829F, 0.0F, 0.0F));

        PartDefinition cube_r17 = paw.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(112, 208).addBox(1.0F, 1.0F, -1.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 63.5F, 5.5F, 0.48F, 0.0F, 0.0F));

        PartDefinition claws = paw.addOrReplaceChild("claws", CubeListBuilder.create(), PartPose.offset(-11.0F, 72.5F, -9.5F));

        PartDefinition claw = claws.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(92, 264).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(10.0F, -8.0F, 1.0F));

        PartDefinition cube_r18 = claw.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(144, 208).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw2 = claws.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(286, 40).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(14.5F, -8.0F, 1.0F));

        PartDefinition cube_r19 = claw2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(256, 104).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw3 = claws.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(226, 293).addBox(-2.496F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offset(19.0F, -8.0F, 1.0F));

        PartDefinition cube_r20 = claw3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(286, 53).addBox(-1.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition frontleg2 = bodyfront.addOrReplaceChild("frontleg2", CubeListBuilder.create().texOffs(40, 304).mirror().addBox(-8.504F, -6.492F, -4.504F, 10.0F, 40.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 9.0F, -2.0F));

        PartDefinition lowerleg6 = frontleg2.addOrReplaceChild("lowerleg6", CubeListBuilder.create().texOffs(346, 95).mirror().addBox(-5.004F, -5.496F, -4.504F, 10.0F, 19.0F, 10.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-3.5F, 34.5F, 0.0F));

        PartDefinition paw5 = lowerleg6.addOrReplaceChild("paw5", CubeListBuilder.create().texOffs(226, 312).mirror().addBox(-7.004F, 0.004F, -8.504F, 14.0F, 10.0F, 16.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(0.5F, 11.5F, 0.0F));

        PartDefinition cube_r21 = paw5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(144, 296).mirror().addBox(-4.0F, 2.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -2.5F, 15.5F, -0.829F, 0.0F, 0.0F));

        PartDefinition cube_r22 = paw5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(112, 208).mirror().addBox(-5.0F, 1.0F, -1.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.5F, 5.5F, 0.48F, 0.0F, 0.0F));

        PartDefinition claws5 = paw5.addOrReplaceChild("claws5", CubeListBuilder.create(), PartPose.offset(14.0F, 10.5F, -9.5F));

        PartDefinition claw13 = claws5.addOrReplaceChild("claw13", CubeListBuilder.create().texOffs(92, 264).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-10.0F, -8.0F, 1.0F));

        PartDefinition cube_r23 = claw13.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(144, 208).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw14 = claws5.addOrReplaceChild("claw14", CubeListBuilder.create().texOffs(286, 40).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-14.5F, -8.0F, 1.0F));

        PartDefinition cube_r24 = claw14.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(256, 104).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition claw15 = claws5.addOrReplaceChild("claw15", CubeListBuilder.create().texOffs(226, 293).mirror().addBox(-1.504F, -1.496F, -4.504F, 4.0F, 8.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offset(-19.0F, -8.0F, 1.0F));

        PartDefinition cube_r25 = claw15.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(286, 53).mirror().addBox(-0.5F, -2.496F, -4.504F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.008F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, -2.5F, 0.3927F, 0.0F, 0.0F));

        PartDefinition headmiddle = bodyfront.addOrReplaceChild("headmiddle", CubeListBuilder.create().texOffs(224, 64).addBox(-7.5F, -8.0F, -23.25F, 16.0F, 16.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -15.5F, -13.25F, 0.1745F, 0.0F, 0.0F));

        PartDefinition allbutneck = headmiddle.addOrReplaceChild("allbutneck", CubeListBuilder.create().texOffs(160, 120).addBox(-15.5F, -16.0F, -23.75F, 32.0F, 32.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -15.0F));

        PartDefinition snout = allbutneck.addOrReplaceChild("snout", CubeListBuilder.create(), PartPose.offset(4.0F, 63.5F, 85.0F));

        PartDefinition upper = snout.addOrReplaceChild("upper", CubeListBuilder.create().texOffs(272, 104).addBox(-12.0F, -12.5F, -15.5F, 22.0F, 12.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(100, 290).addBox(-11.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(112, 224).addBox(-7.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(256, 113).addBox(-3.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(264, 113).addBox(-1.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(304, 227).addBox(7.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(120, 224).addBox(3.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 304).addBox(-11.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(234, 306).addBox(7.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(296, 227).addBox(-11.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(226, 306).addBox(7.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -53.0F, -107.75F, -0.3927F, 0.0F, 0.0F));

        PartDefinition lower = snout.addOrReplaceChild("lower", CubeListBuilder.create().texOffs(174, 272).addBox(-12.0F, 5.5F, -15.5F, 22.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(80, 308).addBox(-11.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 324).addBox(-9.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(330, 99).addBox(-5.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 316).addBox(7.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 328).addBox(5.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 332).addBox(1.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 320).addBox(7.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(320, 227).addBox(7.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 312).addBox(-11.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(312, 227).addBox(-11.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -59.0F, -107.75F, 0.3927F, 0.0F, 0.0F));

        PartDefinition ear1 = allbutneck.addOrReplaceChild("ear1", CubeListBuilder.create(), PartPose.offset(4.0F, 63.5F, 85.0F));

        PartDefinition cube_r26 = ear1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(40, 264).addBox(-1.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)), PartPose.offsetAndRotation(15.0F, -89.5F, -116.25F, 0.0F, 0.0F, 2.618F));

        PartDefinition cube_r27 = ear1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(144, 333).addBox(-1.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, -75.0F, -116.25F, 0.0F, 0.0F, 0.6981F));

        PartDefinition ear2 = allbutneck.addOrReplaceChild("ear2", CubeListBuilder.create(), PartPose.offset(-2.5F, 63.5F, 85.0F));

        PartDefinition cube_r28 = ear2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(248, 272).addBox(-0.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)), PartPose.offsetAndRotation(-15.0F, -89.5F, -116.25F, 0.0F, 0.0F, -2.618F));

        PartDefinition cube_r29 = ear2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(334, 227).addBox(-0.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -75.0F, -116.25F, 0.0F, 0.0F, -0.6981F));

        PartDefinition eye2 = allbutneck.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(346, 169).addBox(-4.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -10.0F, -24.75F));

        PartDefinition eye1 = allbutneck.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(346, 153).addBox(-4.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -10.0F, -24.75F));

        PartDefinition headside1 = bodyfront.addOrReplaceChild("headside1", CubeListBuilder.create().texOffs(224, 64).addBox(-7.5F, -8.0F, -23.25F, 16.0F, 16.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, -8.5F, -3.25F, 0.4873F, -0.5925F, -0.1468F));

        PartDefinition allbutneck2 = headside1.addOrReplaceChild("allbutneck2", CubeListBuilder.create().texOffs(160, 120).addBox(-15.5F, -16.0F, -20.75F, 32.0F, 32.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -18.0F));

        PartDefinition snout2 = allbutneck2.addOrReplaceChild("snout2", CubeListBuilder.create(), PartPose.offset(4.0F, 63.5F, 88.0F));

        PartDefinition upper2 = snout2.addOrReplaceChild("upper2", CubeListBuilder.create().texOffs(272, 104).addBox(-12.0F, -12.5F, -15.5F, 22.0F, 12.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(100, 290).addBox(-11.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(112, 224).addBox(-7.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(256, 113).addBox(-3.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(264, 113).addBox(-1.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(304, 227).addBox(7.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(120, 224).addBox(3.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 304).addBox(-11.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(234, 306).addBox(7.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(296, 227).addBox(-11.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(226, 306).addBox(7.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -53.0F, -107.75F, -0.3927F, 0.0F, 0.0F));

        PartDefinition lower2 = snout2.addOrReplaceChild("lower2", CubeListBuilder.create().texOffs(174, 272).addBox(-12.0F, 5.5F, -15.5F, 22.0F, 6.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(80, 308).addBox(-11.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 324).addBox(-9.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(330, 99).addBox(-5.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 316).addBox(7.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 328).addBox(5.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 332).addBox(1.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 320).addBox(7.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(320, 227).addBox(7.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(80, 312).addBox(-11.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(312, 227).addBox(-11.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -59.0F, -107.75F, 0.3927F, 0.0F, 0.0F));

        PartDefinition ear3 = allbutneck2.addOrReplaceChild("ear3", CubeListBuilder.create(), PartPose.offset(4.0F, 63.5F, 88.0F));

        PartDefinition cube_r30 = ear3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(40, 264).addBox(-1.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)), PartPose.offsetAndRotation(15.0F, -89.5F, -116.25F, 0.0F, 0.0F, 2.618F));

        PartDefinition cube_r31 = ear3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(144, 333).addBox(-1.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, -75.0F, -116.25F, 0.0F, 0.0F, 0.6981F));

        PartDefinition ear4 = allbutneck2.addOrReplaceChild("ear4", CubeListBuilder.create(), PartPose.offset(-2.5F, 63.5F, 88.0F));

        PartDefinition cube_r32 = ear4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(248, 272).addBox(-0.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)), PartPose.offsetAndRotation(-15.0F, -89.5F, -116.25F, 0.0F, 0.0F, -2.618F));

        PartDefinition cube_r33 = ear4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(334, 227).addBox(-0.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -75.0F, -116.25F, 0.0F, 0.0F, -0.6981F));

        PartDefinition eye3 = allbutneck2.addOrReplaceChild("eye3", CubeListBuilder.create().texOffs(346, 153).addBox(-4.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -10.0F, -21.75F));

        PartDefinition eye4 = allbutneck2.addOrReplaceChild("eye4", CubeListBuilder.create().texOffs(346, 169).addBox(-4.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -10.0F, -21.75F));

        PartDefinition headside2 = bodyfront.addOrReplaceChild("headside2", CubeListBuilder.create().texOffs(224, 64).mirror().addBox(-8.5F, -8.0F, -23.25F, 16.0F, 16.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.5F, -8.5F, -3.25F, 0.4873F, 0.5925F, 0.1468F));

        PartDefinition allbutneck3 = headside2.addOrReplaceChild("allbutneck3", CubeListBuilder.create().texOffs(160, 120).mirror().addBox(-16.5F, -16.0F, -38.75F, 32.0F, 32.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition snout3 = allbutneck3.addOrReplaceChild("snout3", CubeListBuilder.create(), PartPose.offset(-4.0F, 63.5F, 70.0F));

        PartDefinition upper3 = snout3.addOrReplaceChild("upper3", CubeListBuilder.create().texOffs(272, 104).mirror().addBox(-10.0F, -12.5F, -15.5F, 22.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(100, 290).mirror().addBox(9.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(112, 224).mirror().addBox(5.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(256, 113).mirror().addBox(1.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(264, 113).mirror().addBox(-1.0F, -0.5F, -14.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(304, 227).mirror().addBox(-9.0F, -0.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(120, 224).mirror().addBox(-5.0F, -0.5F, -14.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 304).mirror().addBox(9.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(234, 306).mirror().addBox(-9.0F, -0.5F, -6.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(296, 227).mirror().addBox(9.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(226, 306).mirror().addBox(-9.0F, -0.5F, -10.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -53.0F, -107.75F, -0.3927F, 0.0F, 0.0F));

        PartDefinition lower3 = snout3.addOrReplaceChild("lower3", CubeListBuilder.create().texOffs(174, 272).mirror().addBox(-10.0F, 5.5F, -15.5F, 22.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 308).mirror().addBox(9.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 324).mirror().addBox(7.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(330, 99).mirror().addBox(3.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 316).mirror().addBox(-9.0F, 3.5F, -12.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 328).mirror().addBox(-7.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 332).mirror().addBox(-3.0F, 3.5F, -14.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 320).mirror().addBox(-9.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(320, 227).mirror().addBox(-9.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(80, 312).mirror().addBox(9.0F, 3.5F, -8.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(312, 227).mirror().addBox(9.0F, 3.5F, -4.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -59.0F, -107.75F, 0.3927F, 0.0F, 0.0F));

        PartDefinition ear5 = allbutneck3.addOrReplaceChild("ear5", CubeListBuilder.create(), PartPose.offset(-4.0F, 63.5F, 70.0F));

        PartDefinition cube_r34 = ear5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(40, 264).mirror().addBox(-0.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)).mirror(false), PartPose.offsetAndRotation(-15.0F, -89.5F, -116.25F, 0.0F, 0.0F, -2.618F));

        PartDefinition cube_r35 = ear5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(144, 333).mirror().addBox(-0.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.5F, -75.0F, -116.25F, 0.0F, 0.0F, -0.6981F));

        PartDefinition ear6 = allbutneck3.addOrReplaceChild("ear6", CubeListBuilder.create(), PartPose.offset(2.5F, 63.5F, 70.0F));

        PartDefinition cube_r36 = ear6.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(248, 272).mirror().addBox(-1.5F, -20.0F, 7.5F, 2.0F, 16.0F, 24.0F, new CubeDeformation(-0.004F)).mirror(false), PartPose.offsetAndRotation(15.0F, -89.5F, -116.25F, 0.0F, 0.0F, 2.618F));

        PartDefinition cube_r37 = ear6.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(334, 227).mirror().addBox(-1.5F, -14.0F, 7.5F, 2.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.5F, -75.0F, -116.25F, 0.0F, 0.0F, 0.6981F));

        PartDefinition eye5 = allbutneck3.addOrReplaceChild("eye5", CubeListBuilder.create().texOffs(346, 153).mirror().addBox(-3.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(9.0F, -10.0F, -39.75F));

        PartDefinition eye6 = allbutneck3.addOrReplaceChild("eye6", CubeListBuilder.create().texOffs(346, 169).mirror().addBox(-3.5F, -4.0F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.0F, -10.0F, -39.75F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(CerebusRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 1f, 2.0f);
        this.meleeAttackAnimation.apply(state.meleeAttackAnimationState, state.ageInTicks, 1f);
        this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
        this.sleepingAnimation.apply(state.sleepingAnimationState, state.ageInTicks, 1f);
        this.chargeAnimation.apply(state.chargeAnimationState, state.ageInTicks, 1f);
        this.slamAnimation.apply(state.slamAnimationState, state.ageInTicks, 1f);
        this.wakeAnimation.apply(state.wakeAnimationState, state.ageInTicks, 1f);
        this.angerAnimation.apply(state.angerAnimationState, state.ageInTicks, 1f);


    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.headmiddle.yRot = headYaw * ((float)Math.PI / 100f);
        this.headmiddle.xRot = headPitch * ((float)Math.PI / 100f);
    }

}