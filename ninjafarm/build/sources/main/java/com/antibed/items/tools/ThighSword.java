package com.antibed.items.tools;

import com.Main;
import com.antibed.init.ModItems;
import com.antibed.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ThighSword extends ItemSword implements IHasModel {

    public ThighSword(String name, ToolMaterial material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);

    }

    public void registerModels() {

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void addInformation(ItemStack p_addInformation_1_, @Nullable World p_addInformation_2_, List<String> p_addInformation_3_, ITooltipFlag p_addInformation_4_) {
        super.addInformation(p_addInformation_1_, p_addInformation_2_, p_addInformation_3_, p_addInformation_4_);
        p_addInformation_3_.add("Opens enemies as well as thighs");
    }

}

