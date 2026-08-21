package net.scientius.divinecomedy.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.scientius.divinecomedy.entity.ModEntities;

import java.util.stream.Stream;

public class ModEntityLootTableProvider extends EntityLootSubProvider {
    public ModEntityLootTableProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        add(ModEntities.CRAWLER.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())

                        ));

        add(ModEntities.CEREBUS.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(3.0f))
                                .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(8, 16)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.BONE).setWeight(10))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5, 10)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.BONE_BLOCK).setWeight(4))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())

                        ));
        add(ModEntities.ROCK_ROLLER.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.SAND))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer()))
                        .withPool(LootPool.lootPool()
                                .setRolls(UniformGenerator.between(0, 1))
                                .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(95))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(5))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                        ));
        add(ModEntities.HERETIC.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(20))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(15))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(2))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())

                        ));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return ModEntities.ENTITY_TYPES.getEntries().stream().map(Holder::value);
    }
}
