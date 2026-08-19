package net.scientius.divinecomedy.entity.ai;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.scientius.divinecomedy.entity.custom.CerebusEntity;

import java.util.EnumSet;
import java.util.List;

public class CerebusSlamGoal extends Goal {

    private static final double TRIGGER_RANGE = 4.0;
    private static final double AOE_RADIUS = 4.5;
    private static final float SLAM_DAMAGE = 8.0f;
    private static final double KNOCK_HORIZONTAL = 1.1;
    private static final double KNOCK_UPWARD = 0.6;

    // TODO: Change this to (Seconds in Blockbench * 20). If the windup is 1.5 seconds, make this 30!
    private static final int WINDUP_TICKS = 30;
    private static final int RECOVER_TICKS = 20;

    private static final int SLAM_COOLDOWN = 160; // Forces an 8-second wait between Slams so he uses Melee

    private final CerebusEntity cerebus;
    private int ticksRunning;
    private boolean impactApplied;
    private int lastSlamTick = -9999;

    public CerebusSlamGoal(CerebusEntity cerebus) {
        this.cerebus = cerebus;
        this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = cerebus.getTarget();
        if (target == null || !target.isAlive()) return false;

        // Block the slam if it's on its 8-second cooldown
        if (cerebus.tickCount - lastSlamTick < SLAM_COOLDOWN) return false;
        return cerebus.distanceToSqr(target) <= TRIGGER_RANGE * TRIGGER_RANGE;
    }

    @Override
    public boolean canContinueToUse() {
        return ticksRunning < (WINDUP_TICKS + RECOVER_TICKS);
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        ticksRunning = 0;
        impactApplied = false;
        cerebus.setSlamming(true);
        cerebus.getNavigation().stop();
    }

    @Override
    public void tick() {
        ticksRunning++;

        LivingEntity target = cerebus.getTarget();
        if (target != null && ticksRunning < WINDUP_TICKS) {
            cerebus.getLookControl().setLookAt(target);
        }

        if (!impactApplied && ticksRunning >= WINDUP_TICKS) {
            doImpact();
            impactApplied = true;
        }
    }

    private void doImpact() {
        if (!(cerebus.level() instanceof ServerLevel serverLevel)) return;

        Vec3 origin = cerebus.position();
        AABB aoe = new AABB(origin, origin).inflate(AOE_RADIUS, 2.0, AOE_RADIUS);

        List<LivingEntity> victims = serverLevel.getEntitiesOfClass(
                LivingEntity.class, aoe, e -> e != cerebus && e.isAlive());

        DamageSource source = cerebus.damageSources().mobAttack(cerebus);

        for (LivingEntity victim : victims) {
            victim.hurt(source, SLAM_DAMAGE);

            Vec3 away = victim.position().subtract(origin);
            double horizDist = Math.max(away.horizontalDistance(), 0.1);
            double dx = (away.x / horizDist) * KNOCK_HORIZONTAL;
            double dz = (away.z / horizDist) * KNOCK_HORIZONTAL;

            victim.setDeltaMovement(victim.getDeltaMovement().add(dx, KNOCK_UPWARD, dz));
            victim.hurtMarked = true;
        }
    }

    @Override
    public void stop() {
        ticksRunning = 0;
        lastSlamTick = cerebus.tickCount; // Start the 8-second cooldown timer
        cerebus.setSlamming(false);
    }
}