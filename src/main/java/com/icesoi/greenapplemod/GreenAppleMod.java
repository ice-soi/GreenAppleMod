package com.icesoi.greenapplemod;

import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import com.icesoi.greenapplemod.item.GreenAppleTabs;
import com.icesoi.greenapplemod.worldgen.biome.GreenAppleOverworldRegion;
import com.icesoi.greenapplemod.worldgen.biome.GreenAppleSurfaceRuleData;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(GreenAppleMod.MOD_ID)
/**
 * 青りんごMODのメインクラス。
 * このクラスはMODのコンポーネントを初期化します。
 */
public class GreenAppleMod
{
    // MODで使うIDの指定
    public static final String MOD_ID = "greenapplemod";
    // ロガー（デバックとかで使う）
    private static final Logger LOGGER = LogUtils.getLogger();

    // コンストラクタ
    public GreenAppleMod() {
        // イベント取得
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ロード時の処理
        modEventBus.addListener(this::commonSetup);

        // アイテム登録
        GreenAppleItems.register(modEventBus);
        // タブ登録
        GreenAppleTabs.register(modEventBus);
        // タブロック録
        GreenAppleBlocks.register(modEventBus);

        // イベント登録
        MinecraftForge.EVENT_BUS.register(this);
        // クリエイトモード時のイベント登録
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(() -> {
            // Modのロード時に、オーバーワールドにバイオーム追加
            Regions.register(new GreenAppleOverworldRegion(
                    new ResourceLocation(
                            GreenAppleMod.MOD_ID, "overworld"
                    ), 5));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,
                    MOD_ID, GreenAppleSurfaceRuleData.makeRules());
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(GreenAppleItems.GREEN_APPLE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
