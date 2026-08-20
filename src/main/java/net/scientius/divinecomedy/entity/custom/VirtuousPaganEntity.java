package net.scientius.divinecomedy.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class VirtuousPaganEntity extends PathfinderMob {
    public VirtuousPaganEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    @Override
    protected void registerGoals() {
        // This determines the AI (!)
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(0, new PanicGoal(this, 2.0f));
        goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 5.0f));
        goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));



    }

    public static AttributeSupplier.Builder createVirtuousPaganAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
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
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationState.start(this.tickCount);
        } else {
            idleAnimationTimeout--;
        }
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
        return SoundEvents.VILLAGER_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.VILLAGER_DEATH;
    }
}
