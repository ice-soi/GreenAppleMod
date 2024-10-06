package com.icesoi.greenapplemod.datagen.server;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.tag.GreenAppleTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GreenAppleBlockTagsProvider extends BlockTagsProvider {
    public GreenAppleBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GreenAppleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // 板材のレシピを作るときに使う
        this.tag(GreenAppleTags.Blocks.GREEN_APPLE_LOG)
                .add(GreenAppleBlocks.GREEN_APPLE_LOG.get())
                .add(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get())
                .add(GreenAppleBlocks.GREEN_APPLE_WOOD.get())
                .add(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get());
        // 原木を使うレシピや、地面かどうかの判定処理に使われる
        this.tag(BlockTags.LOGS)
                .add(GreenAppleBlocks.GREEN_APPLE_LOG.get())
                .add(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get());
        // 焼くと木炭になる
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(GreenAppleBlocks.GREEN_APPLE_LOG.get())
                .add(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get())
                .add(GreenAppleBlocks.GREEN_APPLE_WOOD.get())
                .add(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get());
        // 地面かどうかの判定に使われたり、ハサミで回収できるようになったりする
        this.tag(BlockTags.LEAVES)
                .add(GreenAppleBlocks.GREEN_APPLE_LEAVES.get());

        // 木材
        this.tag(BlockTags.PLANKS).add(GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        this.tag(BlockTags.SLABS).add(GreenAppleBlocks.GREEN_APPLE_SLAB.get());
        this.tag(BlockTags.STAIRS).add(GreenAppleBlocks.GREEN_APPLE_STAIRS.get());
        this.tag(BlockTags.FENCES).add(GreenAppleBlocks.GREEN_APPLE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE.get());
        this.tag(BlockTags.DOORS).add(GreenAppleBlocks.GREEN_APPLE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR.get());
        this.tag(BlockTags.BUTTONS).add(GreenAppleBlocks.GREEN_APPLE_BUTTON.get());
        this.tag(BlockTags.PRESSURE_PLATES).add(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE.get());
    }
}
