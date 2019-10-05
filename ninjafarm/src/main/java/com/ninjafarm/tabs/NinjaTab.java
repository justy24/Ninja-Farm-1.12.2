package com.ninjafarm.tabs;

import com.ninjafarm.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NinjaTab extends CreativeTabs {
    public NinjaTab(String label) {
        super("ninjatab");
        this.setBackgroundImageName("ninja.png");
    }

    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.FLAMY);
    }
}
