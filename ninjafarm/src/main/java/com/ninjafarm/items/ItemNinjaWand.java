package com.ninjafarm.items;

import com.Main;
import com.ninjafarm.entity.chill.EntityChill;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemNinjaWand extends Item implements IHasModel {

    public ItemNinjaWand(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.NINJATAB);

        ModItems.ITEMS.add(this);

    }

    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target, EnumHand enumHand) {
        int previous = player.getCapability(NinjaCountProvider.NINJA_COUNT, null).getNinjaCount();
        if(!player.getEntityWorld().isRemote) {
            if (target instanceof EntityFlamy) {
                if (((EntityFlamy) target).getOwnerId() == player.getUniqueID()) {
                    target.setDead();
                    player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.FLAMY)));
                    player.getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(previous - 1);
                }
            }
            if (target instanceof EntityPebble) {
                if (((EntityPebble) target).getOwnerId() == player.getUniqueID()) {
                    target.setDead();
                    player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.PEBBLE)));
                    player.getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(previous - 1);
                }
            }
            if (target instanceof EntityChill) {
                if (((EntityChill) target).getOwnerId() == player.getUniqueID()) {
                    target.setDead();
                    player.getEntityWorld().spawnEntity(new EntityItem(target.getEntityWorld(), target.posX, target.posY, target.posZ, new ItemStack(ModItems.CHILL)));
                    player.getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(previous - 1);
                }
            }
        }
        return true;
    }
}
