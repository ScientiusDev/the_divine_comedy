package net.scientius.divinecomedy.tag;

import net.scientius.divinecomedy.DivineComedy;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> SOUL_OAK_LOGS = createTag("soul_oak_log");


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(DivineComedy.MODID, name));
        }
    }
}
