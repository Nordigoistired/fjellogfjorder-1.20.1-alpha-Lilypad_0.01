package net.nordigo.fjellogfjorder.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FjellogFjorder.MOD_ID);
// this can be duplicated to make another tab if need be. Probably going to wait until the next major updates for the mod
public static final RegistryObject<CreativeModeTab> MOUNTAINS_AND_FJORDS_TAB = CREATIVE_MODE_TABS.register("mountains_and_fjords_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FAEN.get()))
                .title(Component.translatable("creativetab.mountains_and_fjords_tab")).displayItems((pParameters, pOutput) -> {
                    // the order items list will be the order of items on the tab
                    pOutput.accept(ModItems.FAEN.get());
                    pOutput.accept(ModBlocks.PAYASO.get());

                    // Ponderosa set V
                    pOutput.accept(ModBlocks.PONDEROSA_LOG.get());
                    pOutput.accept(ModBlocks.PONDEROSA_WOOD.get());
                    pOutput.accept(ModBlocks.STRIPPED_PONDEROSA_LOG.get());
                    pOutput.accept(ModBlocks.STRIPPED_PONDEROSA_WOOD.get());
                    pOutput.accept(ModBlocks.PONDEROSA_NEEDLES.get());
                    pOutput.accept(ModBlocks.PONDEROSA_SAPLING.get());
                    pOutput.accept(ModBlocks.PONDEROSA_PLANKS.get());

                    // Larch set V
                    pOutput.accept(ModBlocks.LARCH_LOG.get());
                    pOutput.accept(ModBlocks.LARCH_WOOD.get());
                    pOutput.accept(ModBlocks.STRIPPED_LARCH_LOG.get());
                    pOutput.accept(ModBlocks.STRIPPED_LARCH_WOOD.get());
                    pOutput.accept(ModBlocks.LARCH_NEEDLES.get());
                    pOutput.accept(ModBlocks.LARCH_SAPLING.get());
                    pOutput.accept(ModBlocks.LARCH_PLANKS.get());

                    // music discs V
                    pOutput.accept(ModItems.ANCHORITE_RECORD.get());







                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
