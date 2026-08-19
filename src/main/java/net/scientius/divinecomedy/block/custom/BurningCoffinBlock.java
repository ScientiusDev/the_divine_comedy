package net.scientius.divinecomedy.block.custom;

import com.mojang.serialization.MapCodec;
import net.scientius.divinecomedy.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class BurningCoffinBlock extends HorizontalDirectionalBlock {

    public static final MapCodec<BurningCoffinBlock> CODEC = simpleCodec(BurningCoffinBlock::new);
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;

    public BurningCoffinBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, BedPart.FOOT));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    // 1. THE HITBOX: Just return a standard 16x16x16 full block!
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.block();
    }

    // 2. CHECK FOR SPACE
    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection();
        BlockPos pos = context.getClickedPos();
        BlockPos headPos = pos.relative(facing);
        Level level = context.getLevel();

        // Make sure the block in front is empty before allowing placement
        if (level.getBlockState(headPos).canBeReplaced(context) && level.getWorldBorder().isWithinBounds(headPos)) {
            return this.defaultBlockState().setValue(FACING, facing).setValue(PART, BedPart.FOOT);
        }
        return null;
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide()) {
            Direction facing = state.getValue(FACING);
            BlockPos headPos = pos.relative(facing);

            level.setBlock(headPos, state.setValue(PART, BedPart.HEAD), 3);

            BlockPos footFirePos = pos.above();
            if (level.getBlockState(footFirePos).isAir()) {
                level.setBlock(footFirePos, BaseFireBlock.getState(level, footFirePos), 3);}

            BlockPos headFirePos = headPos.above();
            if (level.getBlockState(headFirePos).isAir()) {
                level.setBlock(headFirePos, BaseFireBlock.getState(level, headFirePos), 3);}
        }
    }

    @Override
    protected void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.spawnAfterBreak(state, level, pos, tool, dropExperience);

        boolean hasSilkTouch = EnchantmentHelper.getItemEnchantmentLevel(
                level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH),
                tool
        ) > 0;


            // 30% chance to spawn your custom entity (0.3f = 30%)
            if (level.getRandom().nextFloat() < 0.3f && !hasSilkTouch)  {
                Entity customEntity = ModEntities.HERETIC.get().spawn(
                        level,
                        pos,
                        EntitySpawnReason.EVENT
                );

                if (customEntity != null) {
                    // Position it at the center of the broken block position
                    customEntity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
                    level.addFreshEntity(customEntity);
                }
            }
        }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        BedPart part = state.getValue(PART);
        Direction facing = state.getValue(FACING);

        // Find out which direction the OTHER half of the coffin is supposed to be
        Direction targetDirection = (part == BedPart.FOOT) ? facing : facing.getOpposite();

        // If the block that just updated was in the direction of our other half...
        if (directionToNeighbour == targetDirection) {
            // ...and it is NO LONGER our coffin block (or it's the wrong half)...
            if (!neighbourState.is(this) || neighbourState.getValue(PART) == part) {
                // ...destroy this half too!
                return Blocks.AIR.defaultBlockState();
            }
        }

        // Otherwise, just do the normal block update stuff
        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }
}