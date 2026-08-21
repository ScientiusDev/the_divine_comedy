package net.scientius.divinecomedy.entity;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.createEntities(DivineComedy.MODID);

    public static final ResourceKey<EntityType<?>> ROCK_ROLLER_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "rock_roller"));
    public static final ResourceKey<EntityType<?>> VIRGILAGER_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "virgilager"));
    public static final ResourceKey<EntityType<?>> CEREBUS_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "cerebus"));
    public static final ResourceKey<EntityType<?>> CRAWLER_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "crawler"));
    public static final ResourceKey<EntityType<?>> HERETIC_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "heretic"));
    public static final ResourceKey<EntityType<?>> VIRTUOUS_PAGAN_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(DivineComedy.MODID, "virtuous_pagan"));

    public static final Supplier<EntityType<RockRollerEntity>> ROCK_ROLLER = ENTITY_TYPES.register("rock_roller",
            () -> EntityType.Builder.of(RockRollerEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(ROCK_ROLLER_KEY));
    public static final Supplier<EntityType<VirgilagerEntity>> VIRGILAGER = ENTITY_TYPES.register("virgilager",
            () -> EntityType.Builder.of(VirgilagerEntity::new, MobCategory.CREATURE).noLootTable().sized(0.6f, 1.95f).build(VIRGILAGER_KEY));
    public static final Supplier<EntityType<CerebusEntity>> CEREBUS = ENTITY_TYPES.register("cerebus",
            () -> EntityType.Builder.of(CerebusEntity::new, MobCategory.MONSTER).sized(4f, 5.5f).build(CEREBUS_KEY));
    public static final Supplier<EntityType<CrawlerEntity>> CRAWLER = ENTITY_TYPES.register("crawler",
            () -> EntityType.Builder.of(CrawlerEntity::new, MobCategory.MONSTER).sized(1.5f, 0.45f).build(CRAWLER_KEY));
    public static final Supplier<EntityType<HereticEntity>> HERETIC = ENTITY_TYPES.register("heretic",
            () -> EntityType.Builder.of(HereticEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(HERETIC_KEY));
    public static final Supplier<EntityType<VirtuousPaganEntity>> VIRTUOUS_PAGAN = ENTITY_TYPES.register("virtuous_pagan",
            () -> EntityType.Builder.of(VirtuousPaganEntity::new, MobCategory.MONSTER).noLootTable().sized(0.6f, 1.95f).build(VIRTUOUS_PAGAN_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
