package com.icesoi.greenapplemod.datagen.client;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider  extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, GreenAppleMod.MOD_ID, Locale.US.toString().toLowerCase());
    }
    @Override
    protected void addTranslations() {
        addItem(GreenAppleItems.GREEN_APPLE, "Green Apple");

        add("creativetabs.green_apple_tab", "Green apple tab");

        addBlock(GreenAppleBlocks.GREEN_APPLE_LEAVES, "Green Apple Leaves");
        addBlock(GreenAppleBlocks.GREEN_APPLE_LOG, "Green Apple Log");
        addBlock(GreenAppleBlocks.GREEN_APPLE_WOOD, "Green Apple Wood");
        addBlock(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG, "Stripped Green Apple Log");
        addBlock(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD, "Stripped Green Apple Wood");

        addBlock(GreenAppleBlocks.GREEN_APPLE_PLANKS,"green_apple_planks");
        addBlock(GreenAppleBlocks.GREEN_APPLE_SLAB,"green_apple_slab");
        addBlock(GreenAppleBlocks.GREEN_APPLE_STAIRS,"green_apple_stairs");
        addBlock(GreenAppleBlocks.GREEN_APPLE_DOOR,"green_apple_door");
        addBlock(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR,"green_apple_trapdoor");
        addBlock(GreenAppleBlocks.GREEN_APPLE_FENCE,"green_apple_fence");
        addBlock(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE,"green_apple_fence_gate");
        addBlock(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE,"green_apple_pressure_plate");
        addBlock(GreenAppleBlocks.GREEN_APPLE_BUTTON,"green_apple_button");
        addBlock(GreenAppleBlocks.GREEN_APPLE_SAPLING,"green_apple_sapling");
    }
}
