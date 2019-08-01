package com.ninjafarm.items.tools;

import com.Main;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

import java.util.List;

public class ToolSword extends ItemSword implements IHasModel {

    public ToolSword(String name, ToolMaterial material){
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

