package com.icesoi.greenapplemod.worldgen.biome;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

/**
 * 青りんごMODのバイオーム生成に関するクラス
 */
public class GreenAppleSurfaceRuleData {
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    private static final SurfaceRules.RuleSource HONEY_BLOCK = makeStateRule(Blocks.HONEY_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(
                // 青りんごの森の地面を草原にする
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(GreenAppleBiomes.GREEN_APPLE_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK))
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
