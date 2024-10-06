package com.icesoi.greenapplemod.datagen.client;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GreenAppleItemModelProvider extends ItemModelProvider {
    public GreenAppleItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GreenAppleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(GreenAppleItems.GREEN_APPLE.get());

        itemWithBlock(GreenAppleBlocks.GREEN_APPLE_SLAB);
        itemWithBlock(GreenAppleBlocks.GREEN_APPLE_STAIRS);
        itemWithBlock(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE);
        itemWithBlock(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE);
        basicItem(GreenAppleBlocks.GREEN_APPLE_DOOR.get().asItem());
        trapdoor(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR);
        fence(GreenAppleBlocks.GREEN_APPLE_FENCE,
                GreenAppleBlocks.GREEN_APPLE_PLANKS);
        button(GreenAppleBlocks.GREEN_APPLE_BUTTON,
                GreenAppleBlocks.GREEN_APPLE_PLANKS);

        sapling(GreenAppleBlocks.GREEN_APPLE_SAPLING);
    }

    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        GreenAppleMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        GreenAppleMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(GreenAppleMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(GreenAppleMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GreenAppleMod.MOD_ID,"block/" + block.getId().getPath()));
    }
}
