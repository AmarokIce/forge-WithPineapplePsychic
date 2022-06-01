package club.someoneice.pineapplepsychic.pineapple.item;

import club.someoneice.pineapplepsychic.pineapple.deprecated.ItemFoods;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.IItemProvider;

public class Itemlist {
    public static Item itemFood(int nutrition, float saturation, boolean isMeat, boolean fastFood, boolean alwaysEat, int MixStacks, Effect[] effects, int getEffectTime, int getEffectLever, float random, UseAction UseAnim, IItemProvider getItem, ItemGroup Group){
        Item.Properties properties = new Item.Properties();
        Food.Builder Builder = new Food.Builder();
        Builder.nutrition(nutrition);
        Builder.saturationMod(saturation);
        for (Effect effect : effects) {
            Builder.effect(() -> new EffectInstance(effect, getEffectTime, getEffectLever), random);
        }
        if (isMeat) {
            Builder.meat();
        }
        if (fastFood) {
            Builder.fast();
        }
        if (alwaysEat) {
            Builder.alwaysEat();
        }
        properties.stacksTo(MixStacks);
        properties.food(Builder.build());
        properties.tab(Group);

        return new ReturnItem(properties, getItem);
    }

    public static Item itemItem(int MixStacks, ItemGroup Group){
        return new ItemItems(MixStacks,Group);
    }

    public static Item itemCraftingItem(int MixStacks, int MixDamage, int DamageNumber, ItemStack returnItem, ItemGroup Group){
        return new ItemCraftingItem(MixStacks, MixDamage, DamageNumber, returnItem, Group);
    }
}