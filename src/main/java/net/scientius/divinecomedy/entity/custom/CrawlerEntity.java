package net.scientius.divinecomedy.entity.custom;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class CrawlerEntity extends PathfinderMob {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public CrawlerEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
       goalSelector.addGoal(0, new FloatGoal(this));
       goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0f, false));
       goalSelector.addGoal(3, new RandomLookAroundGoal(this));
       goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0f));

       targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }


    public static AttributeSupplier.Builder createCrawlerAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.35d)
                .add(Attributes.ATTACK_DAMAGE, 3d)
                .add(Attributes.ATTACK_SPEED, 2d)
                .add(Attributes.ATTACK_KNOCKBACK, 1d)
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
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.DROWNED_AMBIENT_WATER;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.DROWNED_HURT_WATER;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.DROWNED_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(SoundEvents.SLIME_SQUISH, 0.3f, 0.5f);
    }
}