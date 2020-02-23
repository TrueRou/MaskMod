package trou.mask.item.mask;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trou.mask.TabMask;
import trou.mask.enchantment.EnchantmentRegistryHandler;
import trou.mask.enchantment.EnchantmentSelfCycle;
import trou.mask.enchantment.EnchantmentUnbreakable;
import trou.mask.util.ItemStackUtils;
import trou.mask.util.StringUtils;

import javax.annotation.Nonnull;
import java.util.Random;

public class ArmorMask extends ItemArmor implements ISpecialArmor {
    ArmorMask(ArmorMaterial ARMOR_MATERIAL, String maskType) {
        super(ARMOR_MATERIAL, 0, EntityEquipmentSlot.HEAD);
        this.setRegistryName("mask_" + maskType);
        this.setUnlocalizedName("mask.mask" + StringUtils.firstLetterToUpper(maskType));
        this.setCreativeTab(TabMask.TAB_MASK);
    }

    @SideOnly(Side.CLIENT)
    public void loadModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, @Nonnull ItemStack armor, DamageSource source, double damage, int slot) {
        return new ArmorProperties(0, 0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, @Nonnull ItemStack armor, int slot) {
        return 0;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment instanceof EnchantmentSelfCycle ||
                enchantment instanceof EnchantmentDurability ||
                enchantment instanceof EnchantmentUnbreakable;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, @Nonnull ItemStack stack, DamageSource source, int damage, int slot){}

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistryHandler.UNBREAKABLE, itemStack) == 0) {
            if (ItemStackUtils.accessCounter(itemStack) >= 2600) { //2600
                ItemStackUtils.clearCounter(itemStack);
                int level = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, itemStack);
                if (level == 0) itemStack.damageItem(1, player);
                else if (!EnchantmentDurability.negateDamage(new ItemStack(Items.AIR), level, new Random())) itemStack.damageItem(1, player);
            } else {
                ItemStackUtils.increaseCounter(itemStack);
            }
        }
        if (itemStack.getItem() instanceof MaskPolypropylene) player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 300, 0));
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistryHandler.SELF_CYCLE, itemStack);
        if (level == 0) return;
        if (level >= 1 && player.isInsideOfMaterial(Material.WATER)) player.setAir(300);
        if (level >= 2 && player.isInsideOfMaterial(Material.WATER)) player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 300, 0));
    }

    public boolean canProtectPoison() {
        return false;
    }
}
