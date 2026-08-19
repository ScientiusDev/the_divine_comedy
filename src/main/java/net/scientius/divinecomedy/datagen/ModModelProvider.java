package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.block.custom.BurningCoffinBlock;
import net.scientius.divinecomedy.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BedPart;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, DivineComedy.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {


        /* ITEMS */
        itemModels.generateFlatItem(ModItems.INFERNITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.STYX_FLUID_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BOILING_BLOOD_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ROCK_ROLLER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VIRGILAGER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CEREBUS_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CRAWLER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.HERETIC_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VIRTUOUS_PAGAN_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);

        Identifier coffinModel = Identifier.fromNamespaceAndPath(DivineComedy.MODID, "item/burning_coffin");
        itemModels.itemModelOutput.accept(
                ModBlocks.BURNING_COFFIN.asItem(),
                ItemModelUtils.plainModel(coffinModel)
        );


        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.INFERNITE_ORE.get());

        blockModels.createTrivialCube(ModBlocks.INFERNO_EXIT_PORTAL.get());
        blockModels.createTrivialCube(ModBlocks.CEREBUS_BOSS_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.GERYON_BOSS_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.DIS_BOSS_BLOCK.get());

        blockModels.createTrivialCube(ModBlocks.SOUL_OAK_PLANKS.get());
        blockModels.woodProvider(ModBlocks.SOUL_OAK_LOG.get()).logWithHorizontal(ModBlocks.SOUL_OAK_LOG.get()).wood(ModBlocks.SOUL_OAK_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_SOUL_OAK_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_SOUL_OAK_LOG.get()).wood(ModBlocks.STRIPPED_SOUL_OAK_WOOD.get());

        blockModels.createTintedLeaves(ModBlocks.SOUL_OAK_LEAVES.get(), TexturedModel.LEAVES, -12012255);
        blockModels.createPlantWithDefaultItem(ModBlocks.SOUL_OAK_SAPLING.get(), ModBlocks.POTTED_SOUL_OAK_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);

        blockModels.createNonTemplateModelBlock((ModBlocks.STYX_FLUID_BLOCK.get()));
        blockModels.createNonTemplateModelBlock((ModBlocks.BOILING_BLOOD_BLOCK.get()));

        Identifier footModel = Identifier.fromNamespaceAndPath(DivineComedy.MODID, "block/burning_coffin_foot");
        Identifier headModel = Identifier.fromNamespaceAndPath(DivineComedy.MODID, "block/burning_coffin_head");

        var footVariant = BlockModelGenerators.plainVariant(footModel);
        var headVariant = BlockModelGenerators.plainVariant(headModel);

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.BURNING_COFFIN.get())
                        .with(PropertyDispatch.initial(BurningCoffinBlock.FACING, BurningCoffinBlock.PART)
                                .select(Direction.NORTH, BedPart.FOOT, footVariant)
                                .select(Direction.EAST,  BedPart.FOOT, footVariant.with(BlockModelGenerators.Y_ROT_90))
                                .select(Direction.SOUTH, BedPart.FOOT, footVariant.with(BlockModelGenerators.Y_ROT_180))
                                .select(Direction.WEST,  BedPart.FOOT, footVariant.with(BlockModelGenerators.Y_ROT_270))
                                .select(Direction.NORTH, BedPart.HEAD, headVariant)
                                .select(Direction.EAST,  BedPart.HEAD, headVariant.with(BlockModelGenerators.Y_ROT_90))
                                .select(Direction.SOUTH, BedPart.HEAD, headVariant.with(BlockModelGenerators.Y_ROT_180))
                                .select(Direction.WEST,  BedPart.HEAD, headVariant.with(BlockModelGenerators.Y_ROT_270))
                        )
        );
    }
}
