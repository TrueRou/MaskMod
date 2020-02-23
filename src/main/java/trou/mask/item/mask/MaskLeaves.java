package trou.mask.item.mask;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trou.mask.enchantment.EnchantmentRegistryHandler;

import javax.annotation.Nullable;
import java.util.List;

public class MaskLeaves extends ArmorMask {
    private static final ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MASK_LEAVES", "mask:mask_leaves", 6, new int[]{1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0);

    public MaskLeaves() {
        super(ARMOR_MATERIAL, "leaves");
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        super.onCreated(stack, worldIn, playerIn);
        stack.addEnchantment(EnchantmentRegistryHandler.SELF_CYCLE, 1);
    }

    @Override
    public boolean canProtectPoison() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("tooltip.mask.maskLeaves"));
    }
}
