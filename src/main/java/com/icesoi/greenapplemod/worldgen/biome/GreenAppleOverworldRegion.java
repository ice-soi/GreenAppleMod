package com.icesoi.greenapplemod.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

/**
 * 青りんごMODのバイオーム追加のクラス
 */
public class GreenAppleOverworldRegion extends Region {
    public GreenAppleOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder()
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .depth(ParameterUtils.Depth.FULL_RANGE)
                .build().forEach(point -> builder.add(point, GreenAppleBiomes.GREEN_APPLE_FOREST));

        builder.build().forEach(mapper);
    }
}
