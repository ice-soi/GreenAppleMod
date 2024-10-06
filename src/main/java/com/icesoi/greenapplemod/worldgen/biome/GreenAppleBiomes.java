package com.icesoi.greenapplemod.worldgen.biome;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.worldgen.placement.GreenApplePlacement;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

/**
 * 青りんごMODのバイオームに関するクラス
 */
public class GreenAppleBiomes {
    public static final ResourceKey<Biome> GREEN_APPLE_FOREST =
            ResourceKey.create(Registries.BIOME, new ResourceLocation(
                    GreenAppleMod.MOD_ID, "green_apple_forest"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(GREEN_APPLE_FOREST, greenAppleForest(context));
    }


    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome greenAppleForest(BootstapContext<Biome> context) {

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                GreenApplePlacement.GREEN_APPLE_TREE);

        return new Biome.BiomeBuilder()
                // 雨が降るかの設定
                .hasPrecipitation(true)
                // 降水確率
                .downfall(0.5f)
                // 温度
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(9680880)
                        .waterFogColor(8228538)
                        .skyColor(7289685)
                        .grassColorOverride(4349813)
                        .foliageColorOverride(14222332)
                        .fogColor(10854566)
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.ASH, 0.00625F))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
                        .build())
                .build();
    }
}
