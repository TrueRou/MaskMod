package trou.mask.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import trou.mask.item.mask.ArmorMask;

@Mod.EventBusSubscriber(modid = "mask")
public class EnchantmentRegistryHandler {
    static final EnumEnchantmentType maskType = EnumHelper.addEnchantmentType("MASK", item -> item instanceof ArmorMask);
    public static final EnchantmentSelfCycle SELF_CYCLE = new EnchantmentSelfCycle();
    public static final EnchantmentUnbreakable UNBREAKABLE = new EnchantmentUnbreakable();
    @SubscribeEvent
    public static void onRegistry(Register<Enchantment> event) {
        IForgeRegistry<Enchantment> registry = event.getRegistry();
        registry.register(SELF_CYCLE);
        registry.register(UNBREAKABLE);
    }
}
