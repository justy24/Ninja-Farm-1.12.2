package com.ninjafarm.items;

import com.Main;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.items.ninjas.ItemFlamy;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemNinjaWand extends Item {

    public ItemNinjaWand(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.DECORATIONS);

        ModItems.ITEMS.add(this);

    }

    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target, EnumHand enumHand) {
        if(target instanceof EntityFlamy) {
            if(((EntityFlamy)target).getOwnerId() == player.getUniqueID()) {
                target.setDead();
                player.addItemStackToInventory(new ItemStack(ModItems.FLAMY));
            }
        }
        return true;
    }
}
