package trou.mask.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trou.mask.TabMask;

class MaskBlock extends Block {
    private ItemBlock itemBlock;
    MaskBlock(Material materialIn, String registryName) {
        super(materialIn);
        this.setRegistryName(registryName);
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(registryName);
        itemBlock.setCreativeTab(TabMask.TAB_MASK);
        this.setCreativeTab(TabMask.TAB_MASK);
    }

    ItemBlock getItemBlock() {
         return itemBlock;
    }

    @SideOnly(Side.CLIENT)
    void loadModel() {
        ModelLoader.setCustomModelResourceLocation(itemBlock, 0,
                new ModelResourceLocation(itemBlock.getRegistryName(), "inventory"));
    }
}
