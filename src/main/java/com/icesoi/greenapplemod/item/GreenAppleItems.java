package com.icesoi.greenapplemod.item;

import com.icesoi.greenapplemod.GreenAppleMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 青りんごMODのアイテムに関するクラス
 */
public class GreenAppleItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GreenAppleMod.MOD_ID);

    public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                            .nutrition(6)
                            .saturationMod(0.8f)
                            .fast()
                            .alwaysEat()
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600), 1.0f)
                            .effect(new MobEffectInstance(MobEffects.JUMP, 600), 1.0f)
                            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1.0f)
                            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600), 1.0f)
                            .build())));
    public static void register(IEventBus eventBus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventBus);
    }
}
