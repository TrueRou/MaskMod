package trou.mask;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import trou.mask.item.ItemRegistryHandler;

public class TabMask extends CreativeTabs {
    public static final TabMask TAB_MASK = new TabMask();

    private TabMask() {
        super("mask");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.FIBER_LEAVES);
    }
}
