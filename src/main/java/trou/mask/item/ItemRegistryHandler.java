package trou.mask.item;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import trou.mask.item.fiber.FiberLeaves;
import trou.mask.item.fiber.FiberPolypropylene;
import trou.mask.item.mask.MaskLeaves;
import trou.mask.item.mask.MaskPolypropylene;
import trou.mask.item.mask.MaskString;
import trou.mask.item.woven.WovenLeaves;
import trou.mask.item.woven.WovenPolypropylene;
import trou.mask.item.woven.WovenString;

@Mod.EventBusSubscriber(modid = "mask")
public class ItemRegistryHandler {
    public static final FiberLeaves FIBER_LEAVES = new FiberLeaves();
    private static final FiberPolypropylene FIBER_POLYPROPYLENE = new FiberPolypropylene();
    private static final MaskLeaves MASK_LEAVES = new MaskLeaves();
    private static final MaskPolypropylene MASK_POLYPROPYLENE = new MaskPolypropylene();
    private static final MaskString MASK_STRING = new MaskString();
    public static final ItemPolypropyleneBottle POLYPROPYLENE_BOTTLE = new ItemPolypropyleneBottle();
    private static final WovenLeaves WOVEN_LEAVES = new WovenLeaves();
    private static final WovenPolypropylene WOVEN_POLYPROPYLENE = new WovenPolypropylene();
    private static final WovenString WOVEN_STRING = new WovenString();

    @SubscribeEvent
    public static void onRegistry(Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(FIBER_LEAVES);
        registry.register(FIBER_POLYPROPYLENE);
        registry.register(MASK_LEAVES);
        registry.register(MASK_POLYPROPYLENE);
        registry.register(MASK_STRING);
        registry.register(POLYPROPYLENE_BOTTLE);
        registry.register(WOVEN_LEAVES);
        registry.register(WOVEN_POLYPROPYLENE);
        registry.register(WOVEN_STRING);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        FIBER_LEAVES.loadModel();
        MASK_LEAVES.loadModel();
        MASK_POLYPROPYLENE.loadModel();
        MASK_STRING.loadModel();
        POLYPROPYLENE_BOTTLE.loadModel();
        WOVEN_LEAVES.loadModel();
        WOVEN_POLYPROPYLENE.loadModel();
        WOVEN_STRING.loadModel();
        FIBER_POLYPROPYLENE.loadModel();
    }
}
