package club.someoneice.pineapplepsychic.pineapple.block;

import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCrops extends CropsBlock {
    public BlockCrops() {
        super(Properties.of(Material.PLANT).noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
    }
}
