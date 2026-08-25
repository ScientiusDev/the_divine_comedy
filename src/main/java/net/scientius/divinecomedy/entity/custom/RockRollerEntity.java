package net.scientius.divinecomedy.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class RockRollerEntity extends PathfinderMob {

    // Idle Animation
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;


    public RockRollerEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        // This determines the AI (!)
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 2,false));
        goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
        goalSelector.addGoal(3, new RandomLookAroundGoal(this));


        // This is what it wants to target I think
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, RockRollerEntity.class, true));

    }

    public static AttributeSupplier.Builder createRockRollerAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.ATTACK_DAMAGE, 5d)
                .add(Attributes.ATTACK_SPEED, 2d)
                .add(Attributes.ATTACK_KNOCKBACK, 10d)
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
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount); // Tickcount? not sure, especially since Im doing hostile
        } else {
            this.idleAnimationTimeout--;
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(blockState.getSoundType().getStepSound(), 2.0f, 1.0f);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.HUSK_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.HUSK_HURT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.HUSK_DEATH;
    }

    @Override
    protected int getBaseExperienceReward(ServerLevel level) {
        return 5;
    }
}
