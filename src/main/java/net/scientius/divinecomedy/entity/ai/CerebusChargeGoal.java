package net.scientius.divinecomedy.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.scientius.divinecomedy.entity.custom.CerebusEntity;

import java.util.EnumSet;

public class CerebusChargeGoal extends Goal {

    private static final double TRIGGER_RANGE = 10.0;
    private static final int WINDUP_TICKS = 15;
    private static final int MAX_CHARGE_TICKS = 60;
    private static final double CHARGE_SPEED = 3.0; // Standard pathfinding speed modifier (2.0x speed)


    private enum Phase { WINDUP, CHARGING}

    private final CerebusEntity cerebus;
    private Phase phase;
    private int phaseTicks;

    public CerebusChargeGoal(CerebusEntity cerebus) {
        this.cerebus = cerebus;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = cerebus.getTarget();
        if (target == null || !target.isAlive() || cerebus.isSleeping()) return false;
        return cerebus.distanceToSqr(target) > TRIGGER_RANGE * TRIGGER_RANGE;
    }

    @Override
    public boolean canContinueToUse() {
        LivingEntity target = cerebus.getTarget();
        return phase != null && target != null && target.isAlive();
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        phase = Phase.WINDUP;
        phaseTicks = WINDUP_TICKS;
        cerebus.setCharging(true);
        cerebus.getNavigation().stop();
    }

    @Override
    public void tick() {
        LivingEntity target = cerebus.getTarget();
        if (target == null) {
            phase = null;
            return;
        }

        switch (phase) {
            case WINDUP -> {
                cerebus.getLookControl().setLookAt(target);
                cerebus.getNavigation().stop();
                if (--phaseTicks <= 0) {
                    phase = Phase.CHARGING;
                    phaseTicks = MAX_CHARGE_TICKS;
                }
            }
            case CHARGING -> {
                // Uses standard pathfinding navigation so he can clear blocks, climb steps, and jump!
                cerebus.getNavigation().moveTo(target, CHARGE_SPEED);
                cerebus.getLookControl().setLookAt(target, 30.0F, 30.0F);

                if ((cerebus.distanceToSqr(target) <= 6 * 6) || (--phaseTicks <= 0)) {
                    phase = null;
                }
            }
        }
    }

    @Override
    public void stop() {
        phase = null;
        cerebus.setCharging(false);
        cerebus.getNavigation().stop();
    }
}