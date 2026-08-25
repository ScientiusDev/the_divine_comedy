package net.scientius.divinecomedy.entity.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.scientius.divinecomedy.util.InfernoTeleporter;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VirgilagerEntity extends PathfinderMob {

    private final Map<UUID, Long> lastGreeted = new HashMap<>();
    private static final long RESET_TICKS = 5 * 60 * 20;

    //Animations
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout = 0;
    public final AnimationState descendAnimationState = new AnimationState();
    private int descendAnimationTimeout = 0;
    public final AnimationState interactAnimationState = new AnimationState();
    private int interactAnimationTimeout = 0;

    private Player interactingPlayer = null;

    private int dialogueTimer = 0;
    private int dialogueStep = 0;

    public VirgilagerEntity(EntityType<? extends PathfinderMob> type, Level level) {super(type, level);}

    @Override
    protected void registerGoals() {
        // This determines the AI (!)
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 5.0f));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1,true));
        goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(4, new RandomLookAroundGoal(this));


        // This is what it wants to target I think
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

    }

    public static AttributeSupplier.Builder createVirgilagerAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.ATTACK_DAMAGE, 19d)
                .add(Attributes.ATTACK_SPEED, 2d)
                .add(Attributes.ATTACK_KNOCKBACK, 5d)
                .add(Attributes.FOLLOW_RANGE, 16d)
                ;
    }




    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }



    private void setupAnimationStates() {
        if (this.interactAnimationTimeout > 0) {
            this.interactAnimationTimeout--;
        } else {
            this.interactAnimationState.stop();
        }

        if (this.attackAnimationTimeout > 0) {
            this.attackAnimationTimeout--;
        } else {
            this.attackAnimationState.stop();
        }
    }




    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (hand != InteractionHand.MAIN_HAND) {
            return InteractionResult.PASS;
        }

        if (level().isClientSide() || !(player instanceof ServerPlayer serverPlayer)) {
            return InteractionResult.PASS;
        }

        if (this.getTarget() == serverPlayer) {
            return InteractionResult.PASS; // won't talk mid-fight
        }

        long now = level().getGameTime();
        Long lastSeen = lastGreeted.get(serverPlayer.getUUID());

        if (lastSeen == null || now - lastSeen > RESET_TICKS) {
            serverPlayer.sendSystemMessage(Component.literal("[Virgilager] ").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal("Greetings, wanderer. Interact with me again if you wish to descend to ").withStyle(ChatFormatting.WHITE))
                    .append(Component.literal("Inferno").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.BOLD)));
            lastGreeted.put(serverPlayer.getUUID(), now);
            return InteractionResult.SUCCESS_SERVER;
        }

        lastGreeted.remove(serverPlayer.getUUID());
        InfernoTeleporter.sendToInferno(serverPlayer);
        return InteractionResult.SUCCESS_SERVER;
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(blockState.getSoundType().getStepSound(), 0.15f, 1.0f);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.EVOKER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.EVOKER_DEATH;
    }

    @Override
    protected int getBaseExperienceReward(ServerLevel level) {
        return 10;
    }

}
