package com.icesoi.greenapplemod.worldgen.tree;

import com.icesoi.greenapplemod.worldgen.features.GreenAppleFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

/**
 * 青りんごMODの青りんごの木の生成に関するクラス
 */
public class GreenAppleTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return GreenAppleFeatures.GREEN_APPLE_TREE_KEY;
    }
}
