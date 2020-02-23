package trou.mask.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = "mask")
public class BlockRegistryHandler {
    public static final BlockPolypropylene POLYPROPYLENE_BLOCK = new BlockPolypropylene();

    @SubscribeEvent
    public static void onBlockRegistry(Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(POLYPROPYLENE_BLOCK);
    }

    @SubscribeEvent
    public static void onBlockItemRegistry(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(BlockRegistryHandler.POLYPROPYLENE_BLOCK.getItemBlock());
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        BlockRegistryHandler.POLYPROPYLENE_BLOCK.loadModel();
    }
}
