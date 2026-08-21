package net.scientius.divinecomedy.worldgen.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBiomeSources extends BiomeSource {

    public static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOME_SOURCES =
            DeferredRegister.create(BuiltInRegistries.BIOME_SOURCE.key(), "divinecomedy");

    public static final Supplier<MapCodec<ModBiomeSources>> Y_LEVEL_BIOME_SOURCE = BIOME_SOURCES.register(
            "y_level_biomes", () -> RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            Layer.CODEC.listOf().fieldOf("layers").forGetter(s -> s.layers)
                    ).apply(instance, ModBiomeSources::new)
            )
    );

    private final List<Layer> layers;

    public record Layer(int minY, int maxY, Holder<Biome> biome) {
        public static final Codec<Layer> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        Codec.INT.fieldOf("min_y").forGetter(Layer::minY),
                        Codec.INT.fieldOf("max_y").forGetter(Layer::maxY),
                        Biome.CODEC.fieldOf("biome").forGetter(Layer::biome)
                ).apply(instance, Layer::new)
        );
    }


    public ModBiomeSources(List<Layer> layers) {
        super();
        this.layers = layers;
    }

    @Override
    protected MapCodec<? extends BiomeSource> codec() {
        return Y_LEVEL_BIOME_SOURCE.get();
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return layers.stream().map(Layer::biome).distinct();
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int blockY = y << 2;
        for (Layer layer : layers) {
            if (blockY >= layer.minY() && blockY <= layer.maxY()) {
                return layer.biome();
            }
        }
        return layers.isEmpty() ? null : layers.get(0).biome();
    }
}