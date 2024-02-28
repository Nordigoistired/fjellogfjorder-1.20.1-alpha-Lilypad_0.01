package net.nordigo.fjellogfjorder.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FjellogFjorder.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

    this.tag(BlockTags.LOGS)
            .add(ModBlocks.PONDEROSA_LOG.get())
            .add(ModBlocks.LARCH_LOG.get());

    this.tag(BlockTags.LEAVES)
            .add(ModBlocks.PONDEROSA_NEEDLES.get())
            .add(ModBlocks.LARCH_NEEDLES.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
