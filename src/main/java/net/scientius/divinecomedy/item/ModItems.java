package net.scientius.divinecomedy.item;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.entity.ModEntities;
import net.scientius.divinecomedy.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DivineComedy.MODID);


    // Items start here
    public static final DeferredItem<Item> INFERNITE = ITEMS.registerSimpleItem("infernite");

    public static final DeferredItem<Item> STYX_FLUID_BUCKET = ITEMS.registerItem("styx_fluid_bucket",
            properties -> new BucketItem(ModFluids.STYX_FLUID_SOURCE.get(), properties.stacksTo(1).craftRemainder(Items.BUCKET))
            );
    public static final DeferredItem<Item> BOILING_BLOOD_BUCKET = ITEMS.registerItem("boiling_blood_bucket",
            properties -> new BucketItem(ModFluids.BOILING_BLOOD_SOURCE.get(), properties.stacksTo(1).craftRemainder(Items.BUCKET))
    );

    public static final DeferredItem<Item> ROCK_ROLLER_SPAWN_EGG = ITEMS.registerItem("rock_roller_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.ROCK_ROLLER.get()))
    );
    public static final DeferredItem<Item> VIRGILAGER_SPAWN_EGG = ITEMS.registerItem("virgilager_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.VIRGILAGER.get()))
    );
    public static final DeferredItem<Item> CEREBUS_SPAWN_EGG = ITEMS.registerItem("cerebus_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.CEREBUS.get()))
    );
    public static final DeferredItem<Item> CRAWLER_SPAWN_EGG = ITEMS.registerItem("crawler_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.CRAWLER.get()))
    );
    public static final DeferredItem<Item> HERETIC_SPAWN_EGG = ITEMS.registerItem("heretic_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.HERETIC.get()))
    );
    public static final DeferredItem<Item> VIRTUOUS_PAGAN_SPAWN_EGG = ITEMS.registerItem("virtuous_pagan_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.VIRTUOUS_PAGAN.get()))
    );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
