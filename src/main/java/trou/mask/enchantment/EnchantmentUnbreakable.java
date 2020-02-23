package trou.mask.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.inventory.EntityEquipmentSlot;

import static trou.mask.enchantment.EnchantmentRegistryHandler.maskType;

public class EnchantmentUnbreakable extends Enchantment {
    EnchantmentUnbreakable() {
        super(Rarity.VERY_RARE, maskType, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD});
        this.setName("mask.unbreakable");
        this.setRegistryName("unbreakable");
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 30;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !(ench instanceof EnchantmentUnbreakable || ench instanceof EnchantmentDurability);
    }
}
