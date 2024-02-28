package net.nordigo.fjellogfjorder.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }
    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PAYASO.get());
        // Ponderosa Set V
        this.dropSelf(ModBlocks.PONDEROSA_LOG.get());
        this.dropSelf(ModBlocks.PONDEROSA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PONDEROSA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PONDEROSA_WOOD.get());
        this.dropSelf(ModBlocks.PONDEROSA_PLANKS.get());
        this.dropSelf(ModBlocks.PONDEROSA_SAPLING.get());

        this.dropSelf(ModBlocks.PONDEROSA_NEEDLES.get());
        // Larch Set V
        this.dropSelf(ModBlocks.LARCH_LOG.get());
        this.dropSelf(ModBlocks.LARCH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_WOOD.get());
        this.dropSelf(ModBlocks.LARCH_PLANKS.get());
        this.dropSelf(ModBlocks.LARCH_SAPLING.get());

        this.dropSelf(ModBlocks.LARCH_NEEDLES.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
