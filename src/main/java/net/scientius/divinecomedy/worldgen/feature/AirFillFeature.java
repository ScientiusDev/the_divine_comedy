package net.scientius.divinecomedy.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AirFillFeature extends Feature<AirFillConfiguration> {

    public AirFillFeature(Codec<AirFillConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<AirFillConfiguration> context) {
        var level = context.level();
        var origin = context.origin();
        var config = context.config(); // Grabs your variables!

        // Ensures we start at the absolute corner of the current 16x16 chunk
        int chunkStartX = origin.getX() & ~15;
        int chunkStartZ = origin.getZ() & ~15;

        boolean placedAny = false;

        // Loop through the 16x16 chunk area
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                // Loop between your dynamically passed Y limits
                for (int y = config.minY(); y <= config.maxY(); y++) {
                    BlockPos pos = new BlockPos(chunkStartX + x, y, chunkStartZ + z);

                    // If the block is air/void, replace it with your configured fluid
                    if (level.isEmptyBlock(pos)) {
                        // 1. Place the fluid (Flag 2 is standard for worldgen)
                        level.setBlock(pos, config.fluidState(), 2);

                        // 2. Fix the floor! Grab the block directly below the fluid
                        BlockPos belowPos = pos.below();

                        // 3. If the block below is Grass, instantly turn it into Dirt
                        if (level.getBlockState(belowPos).is(Blocks.GRASS_BLOCK)) {
                            level.setBlock(belowPos, Blocks.DIRT.defaultBlockState(), 2);
                        }

                        placedAny = true;
                    }
                }
            }
        }
        return placedAny;
    }
}