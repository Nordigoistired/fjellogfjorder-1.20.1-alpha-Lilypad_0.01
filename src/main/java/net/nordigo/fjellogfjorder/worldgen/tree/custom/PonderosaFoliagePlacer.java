package net.nordigo.fjellogfjorder.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.nordigo.fjellogfjorder.worldgen.tree.ModFoliagePlacerTypes;

public class PonderosaFoliagePlacer extends FoliagePlacer {
        public static final Codec<PonderosaFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance)
                .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height)).apply(instance, PonderosaFoliagePlacer::new));
        protected final int height;

        public PonderosaFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerTypes.PONDEROSA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter foliageSetter, RandomSource pRandom,
                                 TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

            // Creating the foliage
            // attachment.pos() is the first position ABOVE the last placed log
            // tryPlaceLeaf() will place one leaf block at the given position. placeLeavesRow() will place a row. Obviously

        for(int i = 0; i < 3; i++) {
            this.placeLeavesRow(pLevel, foliageSetter, pRandom, pConfig, pAttachment.pos().above(i), 1, i - 5, pAttachment.doubleTrunk());
           // tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pAttachment.pos().above(i), i + 1);
        }

    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
