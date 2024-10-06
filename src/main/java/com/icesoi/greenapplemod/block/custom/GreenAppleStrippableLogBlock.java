package com.icesoi.greenapplemod.block.custom;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * 青りんごMODの樹皮を剥いだ原木に関するクラス
 */
public class GreenAppleStrippableLogBlock extends GreenAppleLogBlock {
    private final Supplier<Block> strippedLog;

    public GreenAppleStrippableLogBlock(Properties pProperties, Supplier<Block> strippedLog) {
        super(pProperties);
        this.strippedLog = strippedLog;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        if (toolAction == ToolActions.AXE_STRIP) {
            return strippedLog.get().defaultBlockState()
                    .setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
