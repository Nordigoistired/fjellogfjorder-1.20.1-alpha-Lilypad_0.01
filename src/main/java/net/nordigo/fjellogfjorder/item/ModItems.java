package net.nordigo.fjellogfjorder.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FjellogFjorder.MOD_ID);

public static final RegistryObject<Item> FAEN = ITEMS.register("faen",
        () -> new Item(new Item.Properties()));

// music discs
public static final RegistryObject<Item> ANCHORITE_RECORD = ITEMS.register("anchorite_record",
        () -> new RecordItem(4, ModSounds.ANCHORITE, new Item.Properties().stacksTo(1),2440));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
