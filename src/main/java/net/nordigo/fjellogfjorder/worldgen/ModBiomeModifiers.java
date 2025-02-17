package net.nordigo.fjellogfjorder.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.nordigo.fjellogfjorder.FjellogFjorder;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_PONDEROSA = registerKey("add_tree_ponderosa");
    public static final ResourceKey<BiomeModifier> ADD_TREE_LARCH = registerKey("add_tree_larch");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_PONDEROSA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.MEADOW)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PONDEROSA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_LARCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.TAIGA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LARCH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(FjellogFjorder.MOD_ID, name));
    }





}
