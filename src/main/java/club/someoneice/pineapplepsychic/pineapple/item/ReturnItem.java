package club.someoneice.pineapplepsychic.pineapple.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class ReturnItem extends Item {

    private IItemProvider getItem;

    public ReturnItem(Item.Properties Properties, IItemProvider getItem) {
        super(Properties);
        this.getItem = getItem;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack item, World LV, LivingEntity living) {
        if (living instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) living;
            ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(getItem));
        }
        return super.finishUsingItem(item, LV, living);
    }
}