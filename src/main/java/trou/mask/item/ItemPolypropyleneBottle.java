package trou.mask.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPolypropyleneBottle extends MaskItem {
    ItemPolypropyleneBottle() {
        super("polypropylene_bottle");
        this.setUnlocalizedName("mask.polypropyleneBottle");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("tooltip.mask.polypropyleneBottle"));
    }
}
