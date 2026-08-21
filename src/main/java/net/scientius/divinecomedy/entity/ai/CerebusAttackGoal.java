package net.scientius.divinecomedy.entity.ai;

import net.scientius.divinecomedy.entity.custom.CerebusEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CerebusAttackGoal extends MeleeAttackGoal {

    private final CerebusEntity entity;

    private static final double MIN_RANGE = 4.0;
    private static final double MAX_RANGE = 10.0;
    private static final int ATTACK_ANIMATION_LENGTH = 30;
    private static final int ATTACK_DELAY = 12;
    private static final double ATTACK_REACH = 6.0;

    private int animationTicks = 0;
    private int ticksUntilAttack = ATTACK_DELAY;
    private boolean attackInProgress = false;
    private boolean hasHit = false;

    public CerebusAttackGoal(CerebusEntity mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
        this.entity = mob;
    }

    private boolean isCerebusInAttackRange(LivingEntity enemy) {
        return this.mob.distanceToSqr(enemy) <= ATTACK_REACH * ATTACK_REACH;
    }

    @Override
    public boolean canUse() {
        if (this.entity.isSleeping()) return false;
        if (!super.canUse()) return false;

        LivingEntity target = this.mob.getTarget();
        if (target == null) return false;

        double distSqr = this.mob.distanceToSqr(target);
        return  distSqr <= MAX_RANGE * MAX_RANGE;
    }


    @Override
    public boolean canContinueToUse() {
        LivingEntity target = this.mob.getTarget();
        if (target == null || !target.isAlive()) return false;


        if (this.attackInProgress) return true;

        double distSqr = this.mob.distanceToSqr(target);


        if (distSqr <= MIN_RANGE * MIN_RANGE) {
            return false;
        }


        if (distSqr > MAX_RANGE * MAX_RANGE) {
            return false;
        }

        return super.canContinueToUse();
    }

    @Override
    public void start() {
        super.start();
        this.animationTicks = 0;
        this.ticksUntilAttack = ATTACK_DELAY;
        this.attackInProgress = false;
        this.hasHit = false;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity enemy) {
        if (this.attackInProgress) return;
        if (!this.isCerebusInAttackRange(enemy)) return;

        this.attackInProgress = true;
        this.hasHit = false;
        this.animationTicks = ATTACK_ANIMATION_LENGTH;
        this.ticksUntilAttack = ATTACK_DELAY;
        this.entity.setAttacking(true);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.attackInProgress) {
            if (!this.hasHit && this.ticksUntilAttack > 0) {
                this.ticksUntilAttack--;
            }

            if (!this.hasHit && this.ticksUntilAttack <= 0) {
                LivingEntity enemy = this.mob.getTarget();
                if (enemy != null && enemy.isAlive()) {
                    this.performAttack(enemy);
                }
                this.hasHit = true;
            }

            if (this.animationTicks > 0) {
                this.animationTicks--;
            }

            if (this.animationTicks <= 0) {
                this.attackInProgress = false;
                this.hasHit = false;
                this.entity.setAttacking(false);
            }
        }
    }

    protected void performAttack(LivingEntity enemy) {
        if (this.mob.level() instanceof ServerLevel serverLevel) {
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(serverLevel, enemy);
        }
    }

    @Override
    public void stop() {
        this.attackInProgress = false;
        this.hasHit = false;
        this.animationTicks = 0;
        this.ticksUntilAttack = ATTACK_DELAY;
        this.entity.setAttacking(false);
        super.stop();
    }
}