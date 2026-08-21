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
        var config = context.config();


        int chunkStartX = origin.getX() & ~15;
        int chunkStartZ = origin.getZ() & ~15;

        boolean placedAny = false;


        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {


                for (int y = config.minY(); y <= config.maxY(); y++) {
                    BlockPos pos = new BlockPos(chunkStartX + x, y, chunkStartZ + z);


                    if (level.isEmptyBlock(pos)) {

                        level.setBlock(pos, config.fluidState(), 2);


                        BlockPos belowPos = pos.below();


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