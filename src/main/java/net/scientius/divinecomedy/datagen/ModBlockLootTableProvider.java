package net.scientius.divinecomedy.datagen;

import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //dropSelf(ModBlocks.EXAMPLE.get())

        add(ModBlocks.INFERNITE_ORE.get(),
                createMultipleOreDrops(ModBlocks.INFERNITE_ORE.get(), ModItems.INFERNITE.get(), 1, 5));

        dropSelf(ModBlocks.SOUL_OAK_LOG.get());
        dropSelf(ModBlocks.SOUL_OAK_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_SOUL_OAK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_SOUL_OAK_WOOD.get());

        dropSelf(ModBlocks.SOUL_OAK_PLANKS.get());
        dropSelf(ModBlocks.SOUL_OAK_SAPLING.get());

        add(ModBlocks.POTTED_SOUL_OAK_SAPLING.get(), createPotFlowerItemTable((ModBlocks.SOUL_OAK_SAPLING.get())));
        add(ModBlocks.SOUL_OAK_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.SOUL_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.BURNING_COFFIN.get(), createSilkTouchOnlyTable(ModBlocks.BURNING_COFFIN.get()));

        add(ModBlocks.INFERNO_EXIT_PORTAL.get(), noDrop());
        add(ModBlocks.CEREBUS_BOSS_BLOCK.get(), noDrop());
        add(ModBlocks.GERYON_BOSS_BLOCK.get(), noDrop());
        add(ModBlocks.DIS_BOSS_BLOCK.get(), noDrop());


    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(
                block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
