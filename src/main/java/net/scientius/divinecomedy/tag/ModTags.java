package net.scientius.divinecomedy.tag;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> SOUL_OAK_LOGS = createItemTag("soul_oak_log");


        private static TagKey<Item> createItemTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
        }

    }

    public static class Blocks {
        public static final TagKey<Block> WHIRLING_WASTELANDS_REPLACEABLE = createBlockTag("whirling_wastelands_replaceable");


        private static TagKey<Block> createBlockTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
        }
    }
}
