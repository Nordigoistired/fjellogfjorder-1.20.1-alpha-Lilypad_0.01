package net.nordigo.fjellogfjorder.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.block.ModBlocks;
import net.nordigo.fjellogfjorder.worldgen.tree.custom.PonderosaFoliagePlacer;
import net.nordigo.fjellogfjorder.worldgen.tree.custom.PonderosaTrunkPlacer;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PONDEROSA_KEY = registerkey("ponderosa");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_KEY = registerkey("larch");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


        register(context, PONDEROSA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PONDEROSA_LOG.get()),
                new PonderosaTrunkPlacer(6,4,1),
                BlockStateProvider.simple(ModBlocks.PONDEROSA_NEEDLES.get()),
                new PonderosaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, LARCH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LARCH_LOG.get()),
                new StraightTrunkPlacer(7,5,3),
                BlockStateProvider.simple(ModBlocks.LARCH_NEEDLES.get()),
                new SpruceFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(3)),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }



    public static final ResourceKey<ConfiguredFeature<?, ?>> registerkey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FjellogFjorder.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
