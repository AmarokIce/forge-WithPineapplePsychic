package club.someoneice.pineapplepsychic.pineapple.deprecated;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;


public class ItemFoods extends Item{

    private IItemProvider returnItem;

    public ItemFoods(int nutrition, float saturation, boolean isMeat, boolean fastFood, boolean alwaysEat, int MixStacks, Effect[] effects, int getEffectTime, int getEffectLever, float random, UseAction UseAnim, IItemProvider returnItem, ItemGroup Group) {
        super(new Properties());
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
        this.returnItem = returnItem;
    }

    public ItemFoods(int nutrition, float saturation,int MixStacks, Effect[] effects, int getEffectTime, int getEffectLever, float random, UseAction UseAnim, IItemProvider returnItem, ItemGroup Group) {
        this(nutrition, saturation, false, false, false, MixStacks, effects, getEffectTime, getEffectLever, random, UseAnim, returnItem, Group);
    }

    public ItemFoods(int nutrition, float saturation, Effect[] effects, int getEffectTime, int getEffectLever, float random, IItemProvider returnItem, ItemGroup Group) {
        this(nutrition, saturation, false, false, false, 1, effects, getEffectTime, getEffectLever, random, UseAction.DRINK, returnItem, Group);
    }

    public ItemFoods(int nutrition, float saturation, boolean isMeat, boolean fastFood, boolean alwaysEat,IItemProvider returnItem, ItemGroup Group) {
        this(nutrition, saturation, isMeat, fastFood, alwaysEat, 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, returnItem, Group);
    }

    public ItemFoods(int nutrition, float saturation,IItemProvider returnItem, ItemGroup Group) {
        this(nutrition, saturation, false, false ,false , 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, returnItem, Group);
    }

    public ItemFoods(int nutrition, float saturation, boolean alwaysEat,IItemProvider returnItem, ItemGroup Group) {
        this(nutrition, saturation, false, false , alwaysEat, 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, returnItem, Group);
    }

    public ItemFoods(int nutrition, float saturation, boolean alwaysEat, ItemGroup Group) {
        this(nutrition, saturation, false, false, alwaysEat, 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, null, Group);
    }

    public ItemFoods(int nutrition, float saturation, ItemGroup Group) {
        this(nutrition, saturation, false, false, false, 64, new Effect[]{}, 0, 0, 0, UseAction.EAT, null, Group);
    }


    public ItemStack finishUsingItem(ItemStack itemStick, World world, LivingEntity entity) {
        PlayerEntity playerentity = entity instanceof PlayerEntity ? (PlayerEntity)entity : null;
        if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, itemStick);
        }

        if (playerentity != null) {
            playerentity.awardStat(Stats.ITEM_USED.get(this));
            if (!playerentity.abilities.instabuild) {
                itemStick.shrink(1);
            }
        }

        if (playerentity == null || !playerentity.abilities.instabuild) {
            if (itemStick.isEmpty()) {
                return new ItemStack(returnItem);
            }

            if (playerentity != null) {
                playerentity.inventory.add(new ItemStack(returnItem));
            }
        }
        return itemStick;
    }
}
