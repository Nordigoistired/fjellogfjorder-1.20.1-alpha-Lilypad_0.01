package net.nordigo.fjellogfjorder.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.nordigo.fjellogfjorder.worldgen.tree.ModTrunkPlacerTypes;

import javax.annotation.concurrent.Immutable;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PonderosaTrunkPlacer extends TrunkPlacer {
    public static final Codec<PonderosaTrunkPlacer> CODEC = RecordCodecBuilder.create(ponderosaTrunkPlacerInstance ->
            trunkPlacerParts(ponderosaTrunkPlacerInstance).apply(ponderosaTrunkPlacerInstance, PonderosaTrunkPlacer::new));

    public PonderosaTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }


    @Override
    protected TrunkPlacerType<?> type() {

        return ModTrunkPlacerTypes.PONDEROSA_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState>
            pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {


        // THIS IS WHERE THE BLOCK PLACING LOGIC IS
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 1) + pRandom.nextInt(heightRandB - 2, heightRandB + 2);

        for(int i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            if(i % 2 == 0 && pRandom.nextBoolean()) {
                if(pRandom.nextFloat() > 0.85f) {
                    for(int x = 0; x < 2; x++) {
                        placeLog(pLevel,  pBlockSetter, pRandom, pPos.above(i).relative(Direction.NORTH, x), pConfig);
                        pBlockSetter.accept(pPos.above(i).relative(Direction.NORTH), (BlockState) Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(pRandom.nextFloat() > 0.85f) {
                    for(int x = 0; x < 2; x++) {
                        placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i).relative(Direction.SOUTH, x), pConfig);
                        pBlockSetter.accept(pPos.above(i).relative(Direction.SOUTH), (BlockState) Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }

                if(pRandom.nextFloat() > 0.85f) {
                    for(int x = 0; x < 2; x++) {
                        placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i).relative(Direction.EAST, x), pConfig);
                        pBlockSetter.accept(pPos.above(i).relative(Direction.EAST), (BlockState) Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                    }
                }

                if(pRandom.nextFloat() > 0.85f) {
                    for(int x = 0; x < 2; x++) {
                        placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i).relative(Direction.WEST, x), pConfig);
                        pBlockSetter.accept(pPos.above(i).relative(Direction.WEST), (BlockState) Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
