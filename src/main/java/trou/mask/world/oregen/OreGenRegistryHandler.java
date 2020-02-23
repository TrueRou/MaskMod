package trou.mask.world.oregen;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGenRegistryHandler {
    private BlockPos pos;
    private static PolypropyleneGenerator polypropyleneGenerator = new PolypropyleneGenerator();

    public static void register() {
        MinecraftForge.ORE_GEN_BUS.register(new OreGenRegistryHandler());
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event) {
        if (!event.getPos().equals(this.pos)) {
            this.pos = event.getPos();
            polypropyleneGenerator.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }
}
