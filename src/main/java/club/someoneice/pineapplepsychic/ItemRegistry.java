package club.someoneice.pineapplepsychic;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ItemRegistry {
    public static final DeferredRegister<Item> ItemList = DeferredRegister.create(Item.class, Main.MODID);

    // public static final RegistryObject<Item> PINEAPPLE = register(()-> Itemlist.Food(1, 0, false, false, true, 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, Items.GLASS, ItemGroup.TAB_FOOD),"pineapple");

    public static RegistryObject<Item> register(@Nonnull Supplier<Item> initializer, @Nonnull String name) {
        return ItemList.register(name, initializer);
    }
}
