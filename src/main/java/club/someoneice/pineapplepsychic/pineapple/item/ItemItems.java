package club.someoneice.pineapplepsychic.pineapple.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemItems extends Item {
    public ItemItems(int MixStacks, ItemGroup Group) {
        super(new Properties().stacksTo(MixStacks).tab(Group));
    }
}
