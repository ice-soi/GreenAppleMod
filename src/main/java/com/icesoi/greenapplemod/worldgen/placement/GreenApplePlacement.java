package com.icesoi.greenapplemod.worldgen.placement;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.worldgen.features.GreenAppleFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

/**
 * 青りんごMODの生成する場所に関してのクラス
 */
public class GreenApplePlacement {
    public static final ResourceKey<PlacedFeature> GREEN_APPLE_TREE =
            createKey("green_apple_tree");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);


        PlacementUtils.register(context, GREEN_APPLE_TREE,
                configuredFeatures.getOrThrow(GreenAppleFeatures.GREEN_APPLE_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(10, 0.1f, 1),
                        GreenAppleBlocks.GREEN_APPLE_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                new ResourceLocation(GreenAppleMod.MOD_ID, name));
    }
}
