package trou.mask.item.mask;

import net.minecraft.init.SoundEvents;
import net.minecraftforge.common.util.EnumHelper;

public class MaskPolypropylene extends ArmorMask {
    private static final ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MASK_POLYPROPYLENE", "mask:mask_polypropylene", 60, new int[]{1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0);

    public MaskPolypropylene() {
        super(ARMOR_MATERIAL, "polypropylene");
    }

    @Override
    public boolean canProtectPoison() {
        return true;
    }
}
