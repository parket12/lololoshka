package net.yakshin.vasyalithgforest.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BambooBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.DropperBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yakshin.vasyalithgforest.VasyaLithgForest;
import net.yakshin.vasyalithgforest.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VasyaLithgForest.MOD_ID);
    public  static final  RegistryObject<Block> CAT_ORE = registryBlock("cat_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
            .of(Material.CACTUS).strength(3f)
            .requiresCorrectToolForDrops().lightLevel(state -> 10),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> DOG_ORE = registryBlock("dog_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
            .of(Material.STONE).strength(5f)
            .requiresCorrectToolForDrops(), UniformInt.of(2,4)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> СLAWS = registryBlock("scratching_post",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
            .of(Material.STONE).strength(10f)
            .requiresCorrectToolForDrops().instabreak(), UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);
    public  static final  RegistryObject<Block> EAT = registryBlock("eat",
            () -> new DropExperienceBlock(BlockBehaviour.Properties
            .of(Material.STONE).strength(1f)
            .requiresCorrectToolForDrops().explosionResistance(10f),
                    UniformInt.of(3,7)), CreativeModeTab.TAB_MISC);
    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

