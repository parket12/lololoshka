package net.yakshin.vasyalithgforest.item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yakshin.vasyalithgforest.VasyaLithgForest;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VasyaLithgForest.MOD_ID);
    public  static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> CAT = ITEMS.register("cryingcat", () -> new Item(new
            Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CATBlACK = ITEMS.register("blackcat", () -> new Item(new
            Item.Properties().fireResistant().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DOGAGRESSIVE = ITEMS.register("dog", () -> new Item(new
            Item.Properties().stacksTo(256).tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DEFENDERMIC111  = ITEMS.register("micro", () -> new Item(new
            Item.Properties()
            .food((new FoodProperties.Builder()).nutrition(10).saturationMod(2f).build()).tab(CreativeModeTab.TAB_MISC)));


}