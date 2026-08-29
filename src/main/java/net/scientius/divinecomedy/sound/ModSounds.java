package net.scientius.divinecomedy.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.scientius.divinecomedy.DivineComedy;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, DivineComedy.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> INFERNO_AMBIENT_MUSIC = registerSoundEvent("infenro_ambient_music");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(DivineComedy.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
