package net.scientius.divinecomedy.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.animal.wolf.WolfSoundVariant;
import net.minecraft.world.entity.animal.wolf.WolfSoundVariants;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.scientius.divinecomedy.block.BossBlockBreaker;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.entity.ai.CerebusAttackGoal;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.scientius.divinecomedy.entity.ai.CerebusChargeGoal;
import net.scientius.divinecomedy.entity.ai.CerebusSlamGoal;
import net.scientius.divinecomedy.entity.ai.CerebusSleepGoal;
import org.jspecify.annotations.Nullable;

public class CerebusEntity extends PathfinderMob {

    private final static EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(CerebusEntity.class, EntityDataSerializers.BOOLEAN);
    private final static EntityDataAccessor<Boolean> SLEEPING =
            SynchedEntityData.defineId(CerebusEntity.class, EntityDataSerializers.BOOLEAN);
    private final static EntityDataAccessor<Boolean> CHARGING =
            SynchedEntityData.defineId(CerebusEntity.class, EntityDataSerializers.BOOLEAN);
    private final static EntityDataAccessor<Boolean> SLAMMING =
            SynchedEntityData.defineId(CerebusEntity.class, EntityDataSerializers.BOOLEAN);




    private final ServerBossEvent bossEvent = new ServerBossEvent(this.uuid, Component.literal("Cerebus"), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.NOTCHED_6);

    //Animations
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState meleeAttackAnimationState = new AnimationState();

    public final AnimationState sleepingAnimationState = new AnimationState();
    public final AnimationState chargeAnimationState = new AnimationState();
    public final AnimationState slamAnimationState = new AnimationState();

    public final AnimationState wakeAnimationState = new AnimationState();
    public final AnimationState angerAnimationState = new AnimationState();

    public CerebusEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setPersistenceRequired();
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new CerebusSleepGoal(this));
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(3, new CerebusAttackGoal(this, 1.5f, true));
        goalSelector.addGoal(2, new CerebusSlamGoal(this));
        goalSelector.addGoal(4, new CerebusChargeGoal(this));
        goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createCerebusAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 500d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.ATTACK_DAMAGE, 5d)
                .add(Attributes.ATTACK_SPEED, 2d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100d)
                .add(Attributes.ATTACK_KNOCKBACK, 1d)
                .add(Attributes.FOLLOW_RANGE, 32d);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }


    public void setAttacking(boolean attacking) { this.entityData.set(ATTACKING, attacking); }
    public void setSleeping(boolean sleeping) { this.entityData.set(SLEEPING, sleeping); }
    public void setCharging(boolean charging) { this.entityData.set(CHARGING, charging); }
    public void setSlamming(boolean slamming) { this.entityData.set(SLAMMING, slamming); }


    public boolean isAttacking() { return this.entityData.get(ATTACKING); }
    public boolean isSleeping() { return this.entityData.get(SLEEPING);}
    public boolean isCharging() { return this.entityData.get(CHARGING); }
    public boolean isSlamming() { return this.entityData.get(SLAMMING); }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(ATTACKING, false);
        entityData.define(SLEEPING, true);
        entityData.define(CHARGING, false);
        entityData.define(SLAMMING, false);
    }

    private void setupAnimationStates() {
        if (!this.isSleeping() && !this.isAttacking() && !this.isCharging() && !this.isSlamming()) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 80;
                this.idleAnimationState.startIfStopped(this.tickCount);
            } else {
                this.idleAnimationTimeout--;
            }
        } else {
            this.idleAnimationState.stop();
        }

        if (this.isAttacking()) {
            this.meleeAttackAnimationState.startIfStopped(this.tickCount);
        } else {
            this.meleeAttackAnimationState.stop();
        }

        if (this.isSleeping()) {
            this.sleepingAnimationState.startIfStopped(this.tickCount);
        } else {
            this.sleepingAnimationState.stop();
        }

        if (this.isCharging()) {
            this.chargeAnimationState.startIfStopped(this.tickCount);
        } else {
            this.chargeAnimationState.stop();
        }

        if (this.isSlamming()) {
            this.slamAnimationState.startIfStopped(this.tickCount);
        } else {
            this.slamAnimationState.stop();
        }
    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!level().isClientSide()) {
            BossBlockBreaker.breakNearby(level(), blockPosition(),
                    ModBlocks.CEREBUS_BOSS_BLOCK.get(), 4, 32);
        }
    }

    @Override
    public void onDamageTaken(DamageContainer damageContainer) {
        super.onDamageTaken(damageContainer);
        if (isSleeping()) {
            setSleeping(false);
        }
    }

    @Override
    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("IsSleeping", this.isSleeping());
        output.putBoolean("IsAttacking", this.isAttacking());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.setSleeping(input.getBooleanOr("IsSleeping", true));
        this.setAttacking(input.getBooleanOr("IsAttacking", false));
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockState) {
        this.playSound(blockState.getSoundType().getStepSound(), 0.15f, 1.0f);
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return getWolfSoundVariant(this.level(), WolfSoundVariants.ANGRY).adultSounds().ambientSound().value();
    }

    @Override
    public void playAmbientSound() {
        this.playSound(getAmbientSound(), 2.0f, 0.5f);
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return getWolfSoundVariant(this.level(), WolfSoundVariants.ANGRY).adultSounds().hurtSound().value();
    }

    @Override
    protected void playHurtSound(DamageSource source) {
        this.playSound(getHurtSound(source), 2.0f, 0.5f);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return getWolfSoundVariant(this.level(), WolfSoundVariants.ANGRY).adultSounds().hurtSound().value();
    }



    public static WolfSoundVariant getWolfSoundVariant(Level level, ResourceKey<WolfSoundVariant> key) {
        return level.registryAccess()
                .lookupOrThrow(Registries.WOLF_SOUND_VARIANT)
                .getOrThrow(key)
                .value();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }


    @Override
    public @Nullable ItemEntity spawnAtLocation(ServerLevel level, ItemStack itemStack, float offset) {

        ItemEntity droppedItem = super.spawnAtLocation(level, itemStack, offset);


        if (droppedItem != null) {

            double explodePower = 1.0D;

            double xVelocity = (this.random.nextDouble() - 0.5D) * explodePower;
            double yVelocity = (this.random.nextDouble() * 0.5D) + 0.3D;
            double zVelocity = (this.random.nextDouble() - 0.5D) * explodePower;

            droppedItem.setDeltaMovement(xVelocity, yVelocity, zVelocity);


        }

        return droppedItem;
    }


    @Override
    protected int getBaseExperienceReward(ServerLevel level) {
        return 100;
    }

    @Override
    protected boolean isAlwaysExperienceDropper() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}