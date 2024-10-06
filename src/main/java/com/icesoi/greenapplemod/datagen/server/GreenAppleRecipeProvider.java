package com.icesoi.greenapplemod.datagen.server;

import com.icesoi.greenapplemod.block.GreenAppleBlocks;
import com.icesoi.greenapplemod.tag.GreenAppleTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class GreenAppleRecipeProvider extends RecipeProvider {

    public GreenAppleRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        woodFromLogs(pRecipeOutput, GreenAppleBlocks.GREEN_APPLE_WOOD.get(),
                GreenAppleBlocks.GREEN_APPLE_LOG.get());
        woodFromLogs(pRecipeOutput, GreenAppleBlocks.STRIPPED_GREEN_APPLE_WOOD.get(),
                GreenAppleBlocks.STRIPPED_GREEN_APPLE_LOG.get());
        planksFromLog(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get(),
                GreenAppleTags.Items.GREEN_APPLE_LOG, 4);
        slab(pRecipeOutput,
                RecipeCategory.BUILDING_BLOCKS,
                GreenAppleBlocks.GREEN_APPLE_SLAB.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        stairs(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_STAIRS.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        fence(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_FENCE.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        fenceGate(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_FENCE_GATE.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        door(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_DOOR.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        trapdoor(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_TRAPDOOR.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
        button(pRecipeOutput,
                GreenAppleBlocks.GREEN_APPLE_BUTTON.get(),
                GreenAppleBlocks.GREEN_APPLE_PLANKS.get());
    }

    private static void stairs(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        stairBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fence(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        fenceBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void fenceGate(RecipeOutput pRecipeOutput, ItemLike pResult,
                                  ItemLike pIngredient) {
        fenceGateBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void door(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        doorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void trapdoor(RecipeOutput pRecipeOutput, ItemLike pResult,
                                 ItemLike pIngredient) {
        trapdoorBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
    private static void button(RecipeOutput pRecipeOutput, ItemLike pResult, ItemLike pIngredient) {
        buttonBuilder(pResult, Ingredient.of(pIngredient))
                .unlockedBy(getHasName(pIngredient), has(pIngredient))
                .save(pRecipeOutput);
    }
}
