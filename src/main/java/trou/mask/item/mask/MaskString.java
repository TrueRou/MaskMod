package trou.mask.item.mask;

import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class MaskString extends ArmorMask {
    private static final ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MASK_STRING", "mask:mask_string", 20, new int[]{1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

    public MaskString() {
        super(ARMOR_MATERIAL, "string");
    }

    @Override
    public boolean canProtectPoison() {
        return true;
    }
}
