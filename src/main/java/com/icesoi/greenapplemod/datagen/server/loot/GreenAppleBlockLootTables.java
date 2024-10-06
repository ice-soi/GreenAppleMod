package com.icesoi.greenapplemod.datagen.server.loot;

import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.item.GreenAppleItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class GreenAppleBlockLootTables extends BlockLootSubProvider {
    protected GreenAppleBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_LOG.get());
        this.dropSelf(GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_WOOD.get());
        this.dropSelf(GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get());
        // まず、createLeavesDropsで苗木をドロップさせる設定
        LootTable.Builder leavesLootTable =
                createLeavesDrops(GreenAppleBlocks.GREEN_APPLE_LEAVES.get(),
                        GreenAppleBlocks.GREEN_APPLE_SAPLING.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES
                );
        leavesLootTable.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(applyExplosionDecay(GreenAppleBlocks.GREEN_APPLE_LEAVES.get(),
                        LootItem.lootTableItem(GreenAppleItems.GREEN_APPLE.get())
                        .when(LootItemRandomChanceCondition.randomChance(0.1f))))
        );  // 10%で青りんごをドロップ
        this.add(GreenAppleBlocks.GREEN_APPLE_LEAVES.get(), leavesLootTable);

        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_SLAB.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_STAIRS.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_FENCE.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_FENCE_GATE.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_DOOR.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_TRAPDOOR.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_BUTTON.get());
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_PRESSURE_PLATE.get());
        this.add(GreenAppleBlocks.GREEN_APPLE_SLAB.get(),
                createSlabItemTable(GreenAppleBlocks.GREEN_APPLE_SLAB.get()));
        this.add(GreenAppleBlocks.GREEN_APPLE_DOOR.get(),
                createDoorTable(GreenAppleBlocks.GREEN_APPLE_DOOR.get()));
        this.dropSelf(GreenAppleBlocks.GREEN_APPLE_SAPLING.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GreenAppleBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
