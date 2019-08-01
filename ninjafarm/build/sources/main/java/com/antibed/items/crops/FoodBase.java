package com.antibed.items.crops;

import com.Main;
import com.antibed.init.ModItems;
import com.antibed.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel {
    public FoodBase(String name, int heal, float satAmount, boolean isWolfFood) {
        super(heal, satAmount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
