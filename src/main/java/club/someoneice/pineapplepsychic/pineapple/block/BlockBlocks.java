package club.someoneice.pineapplepsychic.pineapple.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemGroup;

public class BlockBlocks extends Block {
    public BlockBlocks(Material material, float strength, int hard) {
            super(Properties.of(material).strength(strength).noOcclusion().harvestLevel(hard));
    }
}
