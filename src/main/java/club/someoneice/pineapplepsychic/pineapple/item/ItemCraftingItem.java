package club.someoneice.pineapplepsychic.pineapple.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemCraftingItem extends Item {
    private ItemStack Items;
    private int DamageNumber;

    public ItemCraftingItem(int MixStacks, int MixDamage, int DamageNumber, ItemStack returnItem, ItemGroup Group) {
        super(new Properties().stacksTo(MixStacks).durability(MixDamage).tab(Group));
        this.Items = returnItem;
        this.DamageNumber = DamageNumber;
    }

    public ItemCraftingItem(int MixStacks, ItemGroup Group) {
        this(MixStacks, 1, 1, null, Group);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        ItemStack item = new ItemStack(this);
        item.setDamageValue(itemstack.getDamageValue() + DamageNumber);
        if (item.getDamageValue() >= item.getMaxDamage()) {
            return Items;
        }
        return item;
    }

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
}