package net.scientius.divinecomedy.datagen;

import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.scientius.divinecomedy.loot.ModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLootTableProvider implements LootTableSubProvider {

    private final HolderLookup.Provider registries;

    public ModChestLootTableProvider(HolderLookup.Provider provider) {
        this.registries = provider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
                ModLootTables.GOLD_HOARD,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(0.0f, 2.0f))
                                        .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(2.0f, 6.0f)))
                                                .setWeight(5))
                                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(5.0f, 20.0f)))
                                                .setWeight(10))
                                        .add(LootItem.lootTableItem(Items.IRON_NUGGET)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(4.0f, 18.0f)))
                                                .setWeight(10))
                                        .add(LootItem.lootTableItem(Items.GOLDEN_PICKAXE)
                                                .apply(SetItemCountFunction.setCount(
                                                        ConstantValue.exactly(1.0f)))
                                                .setWeight(3))
                                        .add(LootItem.lootTableItem(Items.IRON_PICKAXE)
                                                .apply(SetItemCountFunction.setCount(
                                                        ConstantValue.exactly(1.0f)))
                                                .setWeight(2))
                                        .apply(SetItemDamageFunction.setDamage(
                                                UniformGenerator.between(0.3f, 0.8f)
                                        )))

                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(1.0f, 3.0f))
                                        .add(LootItem.lootTableItem(Items.SAND)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(8.0f, 20.0f)))
                                                .setWeight(5))
                                        .add(LootItem.lootTableItem(Items.COBBLESTONE)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(8.0f, 20.0f)))
                                                .setWeight(5))
                                        .add(LootItem.lootTableItem(Items.SANDSTONE)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(4.0f, 10.0f)))
                                                .setWeight(4))
                                        .add(LootItem.lootTableItem(Items.STONE)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(4.0f, 10.0f)))
                                                .setWeight(4))
                        )

                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(UniformGenerator.between(0.0f, 1.0f))
                                        .add(LootItem.lootTableItem(Items.GOLD_BLOCK)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(1.0f, 2.0f)))
                                                .setWeight(20))
                                        .add(LootItem.lootTableItem(Items.GOLDEN_APPLE)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(1.0f, 2.0f)))
                                                .setWeight(10))
                                        .add(LootItem.lootTableItem(Items.ENCHANTED_GOLDEN_APPLE)
                                                .apply(SetItemCountFunction.setCount(
                                                        ConstantValue.exactly(1.0f)))
                                                .setWeight(4))

                        ));
        biConsumer.accept(
                ModLootTables.LIMBO_VILLAGE,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool() // Food-ish one
                                .setRolls(UniformGenerator.between(2.0f, 4.0f))
                                .add(LootItem.lootTableItem(Items.PALE_OAK_SAPLING)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(2.0f, 4.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.BREAD)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(2.0f, 4.0f)))
                                        .setWeight(10))
                                .add(LootItem.lootTableItem(Items.DIRT)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(5.0f, 15.0f)))
                                        .setWeight(80))
                                .add(LootItem.lootTableItem(Items.CARROT)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 3.0f)))
                                        .setWeight(5))
                                .add(EmptyLootItem.emptyItem()
                                        .setWeight(20)))

                        .withPool(LootPool.lootPool() // nice materials one
                                .setRolls(UniformGenerator.between(0.0f, 2.0f))
                                .add(LootItem.lootTableItem(Items.IRON_NUGGET)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(8.0f, 17.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(8.0f, 17.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.DIAMOND)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 2.0f)))
                                        .setWeight(1))
                                .add(LootItem.lootTableItem(Items.COPPER_INGOT)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 4.0f)))
                                        .setWeight(10))
                                .add(EmptyLootItem.emptyItem()
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.ALLIUM)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 4.0f)))
                                        .setWeight(18))
                                .add(LootItem.lootTableItem(Items.LEATHER)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(2.0f, 7.0f)))
                                        .setWeight(11)))
        );
        biConsumer.accept(ModLootTables.HERETIC_CEMETERY,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool() //Materials for anchor ooohhh
                                .setRolls(UniformGenerator.between(2.0f, 4.0f))
                                .add(LootItem.lootTableItem(Items.GLOWSTONE_DUST)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 4.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.CRYING_OBSIDIAN)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 2.0f)))
                                        .setWeight(15))
                                .add(LootItem.lootTableItem(Items.GLOWSTONE)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                        .setWeight(18)))
                        .withPool(LootPool.lootPool() // Stronger materials (and fire charge ig)
                                .setRolls(UniformGenerator.between(1.0f, 3.0f))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 6.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(3.0f, 6.0f)))
                                        .setWeight(20))
                                .add(LootItem.lootTableItem(Items.DIAMOND)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(1.0f, 3.0f)))
                                        .setWeight(5))
                                .add(LootItem.lootTableItem(Items.FIRE_CHARGE)
                                        .apply(SetItemCountFunction.setCount(
                                                UniformGenerator.between(2.0f, 4.0f)))
                                        .setWeight(20)))


        );
    }
}
