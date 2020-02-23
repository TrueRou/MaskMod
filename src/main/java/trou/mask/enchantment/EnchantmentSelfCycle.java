package trou.mask.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EntityEquipmentSlot;

import static trou.mask.enchantment.EnchantmentRegistryHandler.maskType;

public class EnchantmentSelfCycle extends Enchantment {
    EnchantmentSelfCycle() {
        super(Rarity.RARE, maskType, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD});
        this.setName("mask.selfCycle");
        this.setRegistryName("self_cycle");
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return (enchantmentLevel - 1) * 8 + 10;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return getMinEnchantability(enchantmentLevel) + 50;
    }
}
