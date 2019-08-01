package com.ninjafarm.blocks;

import com.Main;
import com.ninjafarm.init.ModBlocks;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public void registerModels(){
        Main.proxy.registerItemRenderer(ItemBlock.getItemFromBlock(this), 0, "inventory");
    }

}
