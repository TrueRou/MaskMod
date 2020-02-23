package trou.mask.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trou.mask.TabMask;

public class MaskItem extends Item {
    public MaskItem(String registryName) {
        this.setRegistryName(registryName);
        this.setCreativeTab(TabMask.TAB_MASK);
    }

    @SideOnly(Side.CLIENT)
    public void loadModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}
