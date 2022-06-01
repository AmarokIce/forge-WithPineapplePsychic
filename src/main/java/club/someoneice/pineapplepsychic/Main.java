package club.someoneice.pineapplepsychic;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "pineapple_psychic";
    public static final String Version = "t1";
    public static final Logger LOGGER = LogManager.getLogger("[pineapple_psychic]");

    public Main() {
        MinecraftForge.EVENT_BUS.register(this);
        ItemRegistry.ItemList.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
