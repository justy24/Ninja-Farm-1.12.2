package com.ninjafarm.items.tools;

import com.Main;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe implements IHasModel {

    public ToolAxe(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);

    }

    public void registerModels() {

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
