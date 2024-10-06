package com.icesoi.greenapplemod.worldgen.features;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

/**
 * 青りんごMODの生成情報のクラス
 */
public class GreenAppleFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_APPLE_TREE_KEY =
            createKey("green_apple_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        FeatureUtils.register(context, GREEN_APPLE_TREE_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(GreenAppleBlocks.GREEN_APPLE_LOG.get()),
                        new ForkingTrunkPlacer(5, 15, 0),
                        BlockStateProvider.simple(GreenAppleBlocks.GREEN_APPLE_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2),
                                ConstantInt.of(0), 2),
                        new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(GreenAppleMod.MOD_ID, name));
    }
}
