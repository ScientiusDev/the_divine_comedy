package net.scientius.divinecomedy.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class ModSurfaceRules {

    // All the blocks I need defined
    private static final SurfaceRules.RuleSource GRASS = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CRYING_OBSIDIAN = makeStateRule(Blocks.CRYING_OBSIDIAN);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);
    private static final SurfaceRules.RuleSource PALE_MOSS = makeStateRule(Blocks.PALE_MOSS_BLOCK);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);
    private static final SurfaceRules.RuleSource ICE = makeStateRule(Blocks.ICE);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource PACKED_MUD = makeStateRule(Blocks.PACKED_MUD);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource STONE_BRICKS = makeStateRule(Blocks.STONE_BRICKS);


    // Now all the custom rules per biome

    public static SurfaceRules.RuleSource makeLimboRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CALCITE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, CALCITE),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, CALCITE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, CALCITE)

        );
    }


    public static SurfaceRules.RuleSource makeLustingCliffsRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, PALE_MOSS),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, PALE_MOSS),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, STONE)
        );
    }


    public static SurfaceRules.RuleSource makeGluttonousCavernsRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ICE)
        );
    }


    public static SurfaceRules.RuleSource makeAridPlainsRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SANDSTONE),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE)
        );
    }



    public static SurfaceRules.RuleSource makeStyxRiverRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, MUD),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, MUD)
        );
    }


    public static SurfaceRules.RuleSource makeDisBiomeRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, STONE_BRICKS),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE_BRICKS),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE_BRICKS)
        );
    }


    public static SurfaceRules.RuleSource makeWoodOfSuicidesRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, COARSE_DIRT),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, NETHERRACK)
        );
    }


    public static SurfaceRules.RuleSource makeBolgiaRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, STONE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, STONE),
                SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, STONE)
        );
    }


    public static SurfaceRules.RuleSource makeFrozenDepthsRules() {

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, PACKED_ICE),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE),
                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ICE)
        );
    }
    public static SurfaceRules.RuleSource makeInfernoRules() {
        // Define the blocks you want to paint with

        SurfaceRules.RuleSource mainBlock = SurfaceRules.state(Blocks.NETHERRACK.defaultBlockState()); // Or whatever core block you want

        // Note: If you want blocks *inside* your layers to be painted, you can add more rules here!
        return SurfaceRules.sequence(
                // Standard for all
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor",
                        VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof",
                        VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(33), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(95), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(127), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(129), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(159), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(161), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(191), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(193), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(223), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(225), 0)),
                                BEDROCK
                        )
                ),
                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(255), 0),
                        SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(257), 0)),
                                BEDROCK
                        )
                ),


                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LIMBO), makeLimboRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.LUSTING_CLIFFS), makeLustingCliffsRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.GLUTTONOUS_CAVERNS), makeGluttonousCavernsRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ARID_PLAINS), makeAridPlainsRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.STYX_RIVER), makeStyxRiverRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.DIS_BIOME), makeDisBiomeRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.WOOD_OF_SUICIDES), makeWoodOfSuicidesRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.BOLGIA), makeBolgiaRules()),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.FROZEN_DEPTHS), makeFrozenDepthsRules())


        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block){
        return SurfaceRules.state(block.defaultBlockState());
    }
}