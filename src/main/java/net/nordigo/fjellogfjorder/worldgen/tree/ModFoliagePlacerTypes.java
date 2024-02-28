package net.nordigo.fjellogfjorder.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.worldgen.tree.custom.PonderosaFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, FjellogFjorder.MOD_ID);
public static final RegistryObject<FoliagePlacerType<PonderosaFoliagePlacer>> PONDEROSA_FOLIAGE_PLACER =
        FOLIAGE_PLACERS.register("ponderosa_foliage_placer", () -> new FoliagePlacerType<>(PonderosaFoliagePlacer.CODEC));
public static void register(IEventBus eventBus) {
    FOLIAGE_PLACERS.register(eventBus);
}
}
