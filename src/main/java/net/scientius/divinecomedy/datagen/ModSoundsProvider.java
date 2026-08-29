package net.scientius.divinecomedy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.sound.ModSounds;

public class ModSoundsProvider extends SoundDefinitionsProvider {

    public ModSoundsProvider(PackOutput output) {
        super(output, DivineComedy.MODID);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.INFERNO_AMBIENT_MUSIC.get(), definition()
                        .with(sound("minecraft:music/game/nether/nether1"))
                        .with(sound("minecraft:music/game/nether/nether2"))
                        .with(sound("minecraft:music/game/nether/nether3"))
                        .with(sound("minecraft:music/game/nether/nether4"))
                        .with(sound("minecraft:music/game/nether/crimson_forest/chrysopoeia").stream())
                        .with(sound("minecraft:music/game/nether/nether_wastes/rubedo").stream())
                        .with(sound("minecraft:music/game/nether/soul_sand_valley/so_below").stream())
                        .with(sound("minecraft:music/game/deep_dark/ancestry").stream())
                        .with(sound("minecraft:music/game/deep_dark/deeper").stream())
                );
    }
}
