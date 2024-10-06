package com.icesoi.greenapplemod.block;

import com.icesoi.greenapplemod.GreenAppleMod;
import com.icesoi.greenapplemod.block.custom.GreenAppleLeavesBlock;
import com.icesoi.greenapplemod.block.custom.GreenAppleLogBlock;
import com.icesoi.greenapplemod.block.custom.GreenAppleStrippableLogBlock;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import com.icesoi.greenapplemod.worldgen.tree.GreenAppleTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * 青りんごMODのブロックに関するクラス
 */
public class GreenAppleBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GreenAppleMod.MOD_ID);

    public static final RegistryObject<Block> STRIPPED_GREEN_APPLE_LOG = registerBlockItem(
            "stripped_green_apple_log",
            () -> new GreenAppleLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_GREEN_APPLE_WOOD = registerBlockItem(
            "stripped_green_apple_wood",
            () -> new GreenAppleLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GREEN_APPLE_LOG = registerBlockItem(
            "green_apple_log",
            () -> new GreenAppleStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD),
                    STRIPPED_GREEN_APPLE_LOG));
    public static final RegistryObject<Block> GREEN_APPLE_WOOD = registerBlockItem(
            "green_apple_wood",
            () -> new GreenAppleStrippableLogBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD),
                    STRIPPED_GREEN_APPLE_WOOD));
    public static final RegistryObject<Block> GREEN_APPLE_LEAVES = registerBlockItem(
            "green_apple_leaves",
            () -> new GreenAppleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> GREEN_APPLE_PLANKS = registerBlockItem(
            "green_apple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GREEN_APPLE_SLAB = registerBlockItem(
            "green_apple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GREEN_APPLE_STAIRS = registerBlockItem(
            "green_apple_stairs",
            () -> new StairBlock(() -> GreenAppleBlocks.GREEN_APPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GREEN_APPLE_FENCE = registerBlockItem(
            "green_apple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GREEN_APPLE_FENCE_GATE = registerBlockItem(
            "green_apple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    SoundEvents.BONE_BLOCK_PLACE, SoundEvents.SHEEP_DEATH));
    public static final RegistryObject<Block> GREEN_APPLE_DOOR = registerBlockItem(
            "green_apple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));
    public static final RegistryObject<Block> GREEN_APPLE_TRAPDOOR = registerBlockItem(
            "green_apple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> GREEN_APPLE_BUTTON = registerBlockItem(
            "green_apple_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> GREEN_APPLE_PRESSURE_PLATE = registerBlockItem(
            "green_apple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> GREEN_APPLE_SAPLING = registerBlockItem(
            "green_apple_sapling",
            () -> new SaplingBlock(new GreenAppleTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        GreenAppleItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
