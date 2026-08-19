package net.scientius.divinecomedy.worldgen.tree;

import net.scientius.divinecomedy.DivineComedy;
import net.scientius.divinecomedy.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower SOUL_OAK = new TreeGrower(DivineComedy.MODID + ":soul_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SOUL_OAK_TREE_KEY), Optional.empty()
    );

}
