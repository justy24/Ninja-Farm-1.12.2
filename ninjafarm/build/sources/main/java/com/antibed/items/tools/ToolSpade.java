package com.antibed.items.tools;

import com.Main;
import com.antibed.init.ModItems;
import com.antibed.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade implements IHasModel {

    public ToolSpade(String name, ToolMaterial material){
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
