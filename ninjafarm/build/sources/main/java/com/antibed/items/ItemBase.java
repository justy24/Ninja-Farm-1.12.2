package com.antibed.items;

import com.Main;
import com.antibed.init.ModItems;
import com.antibed.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{

    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.DECORATIONS);

        ModItems.ITEMS.add(this);

    }

    public ItemBase(String name, CreativeTabs creativeTabs){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(creativeTabs);

        ModItems.ITEMS.add(this);

    }
    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
