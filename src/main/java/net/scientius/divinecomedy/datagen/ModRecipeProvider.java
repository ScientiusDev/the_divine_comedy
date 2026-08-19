package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        woodFromLogs(ModBlocks.SOUL_OAK_WOOD, ModBlocks.SOUL_OAK_LOG);
        woodFromLogs(ModBlocks.STRIPPED_SOUL_OAK_WOOD, ModBlocks.STRIPPED_SOUL_OAK_LOG);
        planksFromLog(ModBlocks.SOUL_OAK_PLANKS, ModTags.Items.SOUL_OAK_LOGS, 4);
    }
}
