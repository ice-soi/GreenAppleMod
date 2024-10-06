package com.icesoi.greenapplemod.item;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 青りんごMODのタブに関するのクラス
 */
public class GreenAppleTabs {

    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GreenAppleMod.MOD_ID);

    // レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> GREEN_APPLE_TAB = TABS.register("green_apple_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.green_apple_tab"))
                    .icon(GreenAppleItems.GREEN_APPLE.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(GreenAppleItems.GREEN_APPLE.get());
                        pOutput.accept(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_LEAVES.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_LOG.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_WOOD.get());
                        pOutput.accept(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get());

                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_SLAB.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_STAIRS.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_DOOR.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_FENCE.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_BUTTON.get());
                        pOutput.accept(GreenAppleBlocks.GREEN_APPLE_SAPLING.get());


                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        // クリエイティブタブをイベントバスに登録
        TABS.register(eventBus);
    }
}
