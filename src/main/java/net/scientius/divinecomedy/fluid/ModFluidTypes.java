package net.scientius.divinecomedy.fluid;

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.environment.FogEnvironment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector4f;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, DivineComedy.MODID);

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

    public static final Supplier<FluidType> STYX_FLUID_TYPE = FLUID_TYPES.register("styx_fluid_type",
            () -> new FluidType(FluidType.Properties.create()
                    .supportsBoating(true)
                    .canConvertToSource(true)
                    .viscosity(6000).density(3000)
                    .canSwim(true)
                    .canDrown(true)
                    .isWaterLike(false)

            ));

    public static final Supplier<FluidType> BOILING_BLOOD_TYPE = FLUID_TYPES.register("boiling_blood_type",
            () -> new FluidType(FluidType.Properties.create()
                    .supportsBoating(false)
                    .canConvertToSource(true)
                    .viscosity(1000).density(1000)
                    .canSwim(true)
                    .canDrown(true)
                    .isWaterLike(true)

            ));


    public static IClientFluidTypeExtensions STYX_FLUID_EXTENSION = new IClientFluidTypeExtensions() {
        @Override
        public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
            fluidFogColor.set(0.48f, 0.45f, 0.41f);

            IClientFluidTypeExtensions.super.modifyFogColor(camera, partialTick, level, renderDistance, darkenWorldAmount, fluidFogColor);
        }

        @Override
        public void modifyFogRender(Camera camera, @Nullable FogEnvironment environment, float renderDistance, float partialTick, FogData fogData) {

            fogData.renderDistanceStart = 1.0f;
            fogData.environmentalStart = 1.0f;

            fogData.renderDistanceEnd = 3.0f;
            fogData.environmentalEnd = 3.0f;        }
    };




    public static IClientFluidTypeExtensions BOILING_BLOOD_EXTENSION = new IClientFluidTypeExtensions() {
        @Override
        public void modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector4f fluidFogColor) {
            fluidFogColor.set(0.42f, 0.10f, 0.10f);

            IClientFluidTypeExtensions.super.modifyFogColor(camera, partialTick, level, renderDistance, darkenWorldAmount, fluidFogColor);
        }
    };






}
