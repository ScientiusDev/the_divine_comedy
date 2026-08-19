package net.scientius.divinecomedy.fluid;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, DivineComedy.MODID);

    public static final Supplier<FlowingFluid> STYX_FLUID_SOURCE = FLUIDS.register("styx_fluid_source",
            () -> new BaseFlowingFluid.Source(ModFluids.STYX_FLUID_PROPERTIES));
    public static final Supplier<FlowingFluid> BOILING_BLOOD_SOURCE = FLUIDS.register("boiling_blood_source",
            () -> new BaseFlowingFluid.Source(ModFluids.BOILING_BLOOD_PROPERTIES));


    public static final Supplier<FlowingFluid> STYX_FLUID_FLOWING = FLUIDS.register("styx_fluid_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.STYX_FLUID_PROPERTIES));
    public static final Supplier<FlowingFluid> BOILING_BLOOD_FLOWING = FLUIDS.register("boiling_blood_flowing",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BOILING_BLOOD_PROPERTIES));



    public static final BaseFlowingFluid.Properties STYX_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.STYX_FLUID_TYPE, STYX_FLUID_SOURCE, STYX_FLUID_FLOWING)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModBlocks.STYX_FLUID_BLOCK).bucket(ModItems.STYX_FLUID_BUCKET);
    public static final BaseFlowingFluid.Properties BOILING_BLOOD_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.BOILING_BLOOD_TYPE, BOILING_BLOOD_SOURCE, BOILING_BLOOD_FLOWING)
            .slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(ModBlocks.BOILING_BLOOD_BLOCK).bucket(ModItems.BOILING_BLOOD_BUCKET);

    public static void register(IEventBus eventbus) {
        FLUIDS.register(eventbus);
    }
}
