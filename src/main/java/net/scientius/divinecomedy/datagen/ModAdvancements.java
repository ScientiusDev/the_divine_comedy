package net.scientius.divinecomedy.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.block.ModBlocks;
import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.item.ModItems;
import net.scientius.divinecomedy.worldgen.biome.ModBiomes;
import net.scientius.divinecomedy.worldgen.dimension.ModDimensions;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancements extends AdvancementProvider {
    public ModAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new DivineComedyAdvancements()));
    }

    public static class DivineComedyAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
            var items = provider.lookupOrThrow(Registries.ITEM);
            var blocks = provider.lookupOrThrow(Registries.BLOCK);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(ModItems.VIRGILAGER_SPAWN_EGG,
                            Component.translatable("advancements.divinecomedy.root.title"),
                            Component.translatable("advancements.divinecomedy.root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            false,
                            true,
                            false)
                    .addCriterion("entered_inferno", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(ModDimensions.INFERNO_LEVEL_KEY))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/root"));

            AdvancementHolder styxAdvancement = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModItems.STYX_FLUID_BUCKET,
                            Component.translatable("advancements.divinecomedy.styx_fluid.title"),
                            Component.translatable("advancements.divinecomedy.styx_fluid.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("bucketed_styx_fluid", FilledBucketTrigger.TriggerInstance.filledBucket(
                            ItemPredicate.Builder.item().of(items, ModItems.STYX_FLUID_BUCKET)))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/bucketed_styx_fluid"));

            AdvancementHolder boilingBloodAdvancement = Advancement.Builder.advancement()
                    .parent(styxAdvancement)
                    .display(ModItems.BOILING_BLOOD_BUCKET,
                            Component.translatable("advancements.divinecomedy.boiling_blood.title"),
                            Component.translatable("advancements.divinecomedy.boiling_blood.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            true,
                            true,
                            true)
                    .addCriterion("bucketed_boiling_blood", FilledBucketTrigger.TriggerInstance.filledBucket(
                            ItemPredicate.Builder.item().of(items, ModItems.BOILING_BLOOD_BUCKET)))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/bucketed_boiling_blood"));

            AdvancementHolder secondLayerAdvancement = Advancement.Builder.advancement()
                    .parent(root)
                    .display(Items.PALE_OAK_TRAPDOOR,
                            Component.translatable("advancements.divinecomedy.second_layer.title"),
                            Component.translatable("advancements.divinecomedy.second_layer.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            false,
                            true,
                            true)
                    .addCriterion("second_layer", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(
                            provider.lookupOrThrow(Registries.BIOME).getOrThrow(ModBiomes.WHIRLING_WASTELANDS))))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/second_layer"));

            AdvancementHolder cerebusKilledAdvancement = Advancement.Builder.advancement()
                    .parent(secondLayerAdvancement)
                    .display(Items.STONE_SWORD,
                            Component.translatable("advancements.divinecomedy.cerebus_dead.title"),
                            Component.translatable("advancements.divinecomedy.cerebus_dead.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("cerebus_killed", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of( provider.lookupOrThrow(Registries.ENTITY_TYPE),ModEntities.CEREBUS.get())))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/cerebus_killed"));

            AdvancementHolder descentCompleteAdvancement = Advancement.Builder.advancement()
                    .parent(cerebusKilledAdvancement)
                    .display(Items.GRASS_BLOCK,
                            Component.translatable("advancements.divinecomedy.inferno_complete.title"),
                            Component.translatable("advancements.divinecomedy.inferno_complete.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            true,
                            true,
                            false)
                    .addCriterion("inferno_complete", EnterBlockTrigger.TriggerInstance.entersBlock(ModBlocks.INFERNO_EXIT_PORTAL.get()))
                    .save(consumer, Identifier.fromNamespaceAndPath(DivineComedy.MODID, "divinecomedy/inferno_complete"));

        }
    }
}
