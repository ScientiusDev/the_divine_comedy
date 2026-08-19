package net.scientius.divinecomedy.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record AirFillConfiguration(int minY, int maxY, BlockState fluidState) implements FeatureConfiguration {

    public static final Codec<AirFillConfiguration> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("min_y").forGetter(AirFillConfiguration::minY),
                    Codec.INT.fieldOf("max_y").forGetter(AirFillConfiguration::maxY),
                    BlockState.CODEC.fieldOf("fluid_state").forGetter(AirFillConfiguration::fluidState)
            ).apply(instance, AirFillConfiguration::new)
    );
}