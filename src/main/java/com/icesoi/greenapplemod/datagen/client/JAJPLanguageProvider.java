package com.icesoi.greenapplemod.datagen.client;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, GreenAppleMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }
    @Override
    protected void addTranslations() {
        addItem(GreenAppleItems.GREEN_APPLE, "青りんご");

        add("creativetabs.green_apple_tab", "青りんごタブ");

        addBlock(GreenAppleBlocks.GREEN_APPLE_LEAVES, "青りんごの葉");
        addBlock(GreenAppleBlocks.GREEN_APPLE_LOG, "青りんごの原木");
        addBlock(GreenAppleBlocks.GREEN_APPLE_WOOD, "青りんごの木");
        addBlock(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG, "樹皮を剥いだ青りんごの原木");
        addBlock(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD, "樹皮を剥いだ青りんごの木");

        addBlock(GreenAppleBlocks.GREEN_APPLE_PLANKS,"青りんごの板材");
        addBlock(GreenAppleBlocks.GREEN_APPLE_SLAB,"青りんごのハーフブロック");
        addBlock(GreenAppleBlocks.GREEN_APPLE_STAIRS,"青りんごの階段");
        addBlock(GreenAppleBlocks.GREEN_APPLE_DOOR,"青りんごのドア");
        addBlock(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR,"青りんごのトラップドア");
        addBlock(GreenAppleBlocks.GREEN_APPLE_FENCE,"青りんごのフェンス");
        addBlock(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE,"青りんごのフェンスゲート");
        addBlock(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE,"青りんごの感圧版");
        addBlock(GreenAppleBlocks.GREEN_APPLE_BUTTON,"青りんごのボタン");
        addBlock(GreenAppleBlocks.GREEN_APPLE_SAPLING,"青りんごの苗木");
    }
}
