package net.nordigo.fjellogfjorder.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nordigo.fjellogfjorder.block.ModBlocks;
import net.nordigo.fjellogfjorder.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PONDEROSA_WOOD.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModBlocks.PONDEROSA_LOG.get())
                .unlockedBy("has_ponderosa_log",inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.PONDEROSA_LOG.get()).build()))
                .save(pWriter);
    }
}
