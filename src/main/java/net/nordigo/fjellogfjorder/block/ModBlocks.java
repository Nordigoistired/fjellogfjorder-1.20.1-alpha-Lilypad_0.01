package net.nordigo.fjellogfjorder.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nordigo.fjellogfjorder.FjellogFjorder;
import net.nordigo.fjellogfjorder.item.ModItems;
import net.nordigo.fjellogfjorder.worldgen.tree.LarchTreeGrower;
import net.nordigo.fjellogfjorder.worldgen.tree.PonderosaTreeGrower;

import java.util.function.Supplier;



public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FjellogFjorder.MOD_ID);

    public static final RegistryObject<Block> PAYASO = registerBlock("payaso",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.WOOL).ignitedByLava()));

    // Ponderosa sets start V
    // Ponderosa natural set V
    public static final RegistryObject<Block> PONDEROSA_LOG = registerBlock("ponderosa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PONDEROSA_LOG = registerBlock("stripped_ponderosa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_LOG).strength(3f)));
    public static final RegistryObject<Block> PONDEROSA_WOOD = registerBlock("ponderosa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_PONDEROSA_WOOD = registerBlock("stripped_ponderosa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD).strength(3f)));

   public static final RegistryObject<Block> PONDEROSA_SAPLING = registerBlock("ponderosa_sapling",
            () -> new SaplingBlock(new PonderosaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));
    public static final RegistryObject<Block> PONDEROSA_NEEDLES = registerBlock("ponderosa_needles",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)) {
                    @Override
                    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                    @Override
                    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
// Ponderosa processed set V
    public static final RegistryObject<Block> PONDEROSA_PLANKS = registerBlock("ponderosa_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)) {
    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
    });
// Ponderosa sets end ^

// Larch set starts V
// Larch Natural set V
    public static final RegistryObject<Block> LARCH_LOG = registerBlock("larch_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).strength(3f)));

    public static final RegistryObject<Block> LARCH_WOOD = registerBlock("larch_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_LARCH_LOG = registerBlock("stripped_larch_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).strength(3f)));
    public static final RegistryObject<Block> STRIPPED_LARCH_WOOD = registerBlock("stripped_larch_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LOG).strength(3f)));
    public static final RegistryObject<Block> LARCH_NEEDLES = registerBlock("larch_needles",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> LARCH_SAPLING = registerBlock("larch_sapling",
            () -> new SaplingBlock(new LarchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.SPRUCE_SAPLING)));
    // processed set V
    public static final RegistryObject<Block> LARCH_PLANKS = registerBlock("larch_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });









private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
}

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void  register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
