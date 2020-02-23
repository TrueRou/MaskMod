package trou.mask.item.fiber;

import trou.mask.item.MaskItem;
import trou.mask.util.StringUtils;

class ItemFiber extends MaskItem {
    ItemFiber(String fiberName) {
        super("fiber_" + fiberName);
        this.setUnlocalizedName("mask.fiber" + StringUtils.firstLetterToUpper(fiberName));
    }
}
