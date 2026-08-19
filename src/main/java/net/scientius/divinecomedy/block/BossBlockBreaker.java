package net.scientius.divinecomedy.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public final class BossBlockBreaker {

    private BossBlockBreaker() {}

    public static void breakNearby(Level level, BlockPos center, Block bossBlock,
                                   int chunkRadius, int verticalRange) {
        int horizontal = chunkRadius * 16;
        BlockPos min = center.offset(-horizontal, -verticalRange, -horizontal);
        BlockPos max = center.offset(horizontal, verticalRange, horizontal);

        for (BlockPos pos : BlockPos.betweenClosed(min, max)) {
            if (level.getBlockState(pos).is(bossBlock)) {

                level.destroyBlock(pos, false);
            }
        }
    }
}
