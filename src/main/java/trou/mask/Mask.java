package trou.mask;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import trou.mask.world.oregen.OreGenRegistryHandler;

@Mod(modid = "mask", name = "Mask", version = "1.0.0")
public class Mask {
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        OreGenRegistryHandler.register();
    }
}
