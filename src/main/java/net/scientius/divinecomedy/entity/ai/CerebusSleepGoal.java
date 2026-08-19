package net.scientius.divinecomedy.entity.ai;

import net.minecraft.world.entity.ai.goal.Goal;
import net.scientius.divinecomedy.entity.custom.CerebusEntity;

import java.util.EnumSet;

/**
 * Blocks everything (movement, looking, targeting) until the first hit
 * lands. Sits at priority 0 so nothing lower-priority can run underneath
 * it while flags overlap.
 *
 * FIX: was checking Mob#isSleeping() (vanilla's "is this mob sleeping in
 * a bed" check) instead of CerebusEntity's own synced boolean - those are
 * unrelated, so this never actually gated anything. Now takes a
 * CerebusEntity directly and reads its isSleeping().
 *
 * The actual wake trigger lives in CerebusEntity#onDamageTaken, not here -
 * this goal only reads the flag, it doesn't flip it.
 */
public class CerebusSleepGoal extends Goal {

    private final CerebusEntity cerebus;

    public CerebusSleepGoal(CerebusEntity cerebus) {
        this.cerebus = cerebus;
        this.setFlags(EnumSet.of(Flag.JUMP, Flag.MOVE, Flag.TARGET, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return cerebus.isSleeping();
    }

    @Override
    public boolean canContinueToUse() {
        return cerebus.isSleeping();
    }

    @Override
    public void tick() {
        cerebus.setTarget(null); // belt-and-suspenders: nothing sneaks a target while asleep
    }
}