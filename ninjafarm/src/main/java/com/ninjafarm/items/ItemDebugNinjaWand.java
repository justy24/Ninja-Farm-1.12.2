package com.ninjafarm.items;

import com.Main;
import com.ninjafarm.entity.chill.EntityChill;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemDebugNinjaWand extends Item implements IHasModel {

    public ItemDebugNinjaWand(String name){
        setUnlocalizedName(name);
        setRegistryName(name);

        ModItems.ITEMS.add(this);

    }

    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target, EnumHand enumHand) {
        if(!player.getEntityWorld().isRemote) {
            if (target instanceof EntityFlamy) {
                target.setDead();
                player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.FLAMY)));
            }
            if (target instanceof EntityPebble) {
                target.setDead();
                player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.PEBBLE)));
            }
            if (target instanceof EntityChill) {
                target.setDead();
                player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.CHILL)));
            }
        }
        return true;
    }
}
