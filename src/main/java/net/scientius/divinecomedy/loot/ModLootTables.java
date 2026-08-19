package net.scientius.divinecomedy.loot;

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static final ResourceKey<LootTable> GOLD_HOARD =
            ResourceKey.create(
                    Registries.LOOT_TABLE,
                    Identifier.fromNamespaceAndPath(DivineComedy.MODID, "chests/gold_hoard")
            );
}
