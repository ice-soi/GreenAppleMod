package com.icesoi.greenapplemod.tag;

import com.icesoi.greenapplemod.GreenAppleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * 青りんごMODのタグに関するクラス
 */
public class GreenAppleTags {

    public static class Blocks {
        public static final TagKey<Block> GREEN_APPLE_LOG = tag("green_apple_log");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(GreenAppleMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> GREEN_APPLE_LOG = tag("green_apple_log");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(GreenAppleMod.MOD_ID, name));
        }
    }
}
