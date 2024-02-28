package net.nordigo.fjellogfjorder.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.worldgen.tree.custom.PonderosaTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, FjellogFjorder.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<PonderosaTrunkPlacer>> PONDEROSA_TRUNK_PLACER =
            TRUNK_PLACERS.register("ponderosa_trunk_placer", () -> new TrunkPlacerType<>(PonderosaTrunkPlacer.CODEC));


    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }


}
