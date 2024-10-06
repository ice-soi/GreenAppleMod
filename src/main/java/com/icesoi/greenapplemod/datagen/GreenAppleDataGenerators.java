package com.icesoi.greenapplemod.datagen;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.datagen.client.ENUSLanguageProvider;
import com.icesoi.greenapplemod.datagen.client.GreenAppleBlockStateProvider;
import com.icesoi.greenapplemod.datagen.client.GreenAppleItemModelProvider;
import com.icesoi.greenapplemod.datagen.client.JAJPLanguageProvider;
import com.icesoi.greenapplemod.datagen.server.*;
import com.icesoi.greenapplemod.datagen.server.loot.GreenAppleLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GreenAppleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GreenAppleDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        // アイテム用のモデルファイルの生成
        generator.addProvider(event.includeClient(), new GreenAppleItemModelProvider(packOutput
                , existingFileHelper));
        // ブロック用のモデルファイルの生成
        generator.addProvider(event.includeClient(),
                new GreenAppleBlockStateProvider(packOutput, existingFileHelper));
        // 言語ファイル（英語）
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        // 言語ファイル（日本語）
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        // レシピ
        generator.addProvider(event.includeServer(), new GreenAppleRecipeProvider(packOutput));
        // ルートテーブル
        generator.addProvider(event.includeServer(), GreenAppleLootTables.create(packOutput));
        // ブロックタグ
        var blockTagsProvider = generator.addProvider(event.includeServer(),
                new GreenAppleBlockTagsProvider(packOutput
                        ,lookUpProvider, existingFileHelper));
        // アイテムタグ
        generator.addProvider(event.includeServer(), new GreenAppleItemTagsProvider(
                packOutput, lookUpProvider, blockTagsProvider.contentsGetter(),existingFileHelper));
        // バイオーム関連
        generator.addProvider(event.includeServer(),
                new GreenAppleWorldGenProvider(packOutput, lookUpProvider));
    }

}
