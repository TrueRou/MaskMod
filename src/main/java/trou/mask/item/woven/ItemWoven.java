package trou.mask.item.woven;

import trou.mask.item.MaskItem;
import trou.mask.util.StringUtils;

public class ItemWoven extends MaskItem {
    ItemWoven(String wovenName) {
        super("woven_" + wovenName);
        this.setUnlocalizedName("mask.woven" + StringUtils.firstLetterToUpper(wovenName));
    }
}
