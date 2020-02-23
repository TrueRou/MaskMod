package trou.mask.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemStackUtils {
    public static void increaseCounter(ItemStack itemStack) {
        NBTTagCompound tag = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
        int count = tag.hasKey("counter") ? tag.getInteger("counter") : 0;
        count ++;
        tag.setInteger("counter", count);
        itemStack.setTagCompound(tag);
    }

    public static int accessCounter(ItemStack itemStack) {
        NBTTagCompound tag = itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
        return tag.hasKey("counter") ? tag.getInteger("counter") : 0;
    }

    public static void clearCounter(ItemStack itemStack) {
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("counter")) {
            itemStack.getTagCompound().setInteger("counter", 0);
        }
    }
}
