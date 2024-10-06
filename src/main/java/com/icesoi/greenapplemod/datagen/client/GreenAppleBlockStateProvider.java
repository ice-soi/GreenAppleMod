package com.icesoi.greenapplemod.datagen.client;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GreenAppleBlockStateProvider extends BlockStateProvider {
    public GreenAppleBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GreenAppleMod.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) GreenAppleBlocks.GREEN_APPLE_LOG.get());
        logBlock((RotatedPillarBlock) GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get());
        axisBlock((RotatedPillarBlock) GreenAppleBlocks.GREEN_APPLE_WOOD.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_LOG.get()),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get(),
                blockTexture(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get()),
                blockTexture(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get()));
        item(GreenAppleBlocks.GREEN_APPLE_LOG);
        item(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG);
        item(GreenAppleBlocks.GREEN_APPLE_WOOD);
        item(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD);
        greenAppleLeaves(GreenAppleBlocks.GREEN_APPLE_LEAVES);

        simpleBlockWithItem(GreenAppleBlocks.GREEN_APPLE_PLANKS);
        slabBlock((SlabBlock) GreenAppleBlocks.GREEN_APPLE_SLAB.get(),
                // 二つ重ねたときのテクスチャ
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()),
                // 単体のテクスチャ
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));
        stairsBlock((StairBlock) GreenAppleBlocks.GREEN_APPLE_STAIRS.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));
        fenceBlock((FenceBlock) GreenAppleBlocks.GREEN_APPLE_FENCE.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) GreenAppleBlocks.GREEN_APPLE_FENCE_GATE.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) GreenAppleBlocks.GREEN_APPLE_DOOR.get(),
                modLoc("block/green_apple_door_bottom"),
                modLoc("block/green_apple_door_top"),
                "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock)
                        GreenAppleBlocks.GREEN_APPLE_TRAPDOOR.get(),
                modLoc("block/green_apple_trapdoor"), true,
                "cutout");
        buttonBlock((ButtonBlock) GreenAppleBlocks.GREEN_APPLE_BUTTON.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock)
                        GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE.get(),
                blockTexture(GreenAppleBlocks.GREEN_APPLE_PLANKS.get()));

        sapling(GreenAppleBlocks.GREEN_APPLE_SAPLING);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                GreenAppleMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 青りんごの葉ブロック
    private void greenAppleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeTop(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                TextureMapping.getBlockTexture(block.get(), "_side"),
                TextureMapping.getBlockTexture(block.get(), "_top")
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }

    // 青りんごの苗木
    private void sapling(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
