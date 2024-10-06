package com.icesoi.greenapplemod.datagen.server;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.worldgen.biome.GreenAppleBiomeModifiers;
import com.icesoi.greenapplemod.worldgen.biome.GreenAppleBiomes;
import com.icesoi.greenapplemod.worldgen.features.GreenAppleFeatures;
import com.icesoi.greenapplemod.worldgen.placement.GreenApplePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GreenAppleWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, GreenAppleFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GreenApplePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, GreenAppleBiomeModifiers::bootstrap)
            .add(Registries.BIOME, GreenAppleBiomes::bootstrap);

    public GreenAppleWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(GreenAppleMod.MOD_ID));
    }
}
