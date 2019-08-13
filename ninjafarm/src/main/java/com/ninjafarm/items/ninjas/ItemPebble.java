package com.ninjafarm.items.ninjas;

import com.Main;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import com.ninjafarm.util.handlers.NinjaCountHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemPebble extends Item implements IHasModel {

    public ItemPebble(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.DECORATIONS);

        ModItems.ITEMS.add(this);

    }

    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand enumHand) {
        if (!world.isRemote) {
            NinjaCountHandler.registerPlayerNinjaCount(entityplayer);
            if(NinjaCountHandler.getNinjaCount(entityplayer) <= 5) {
                ItemStack itemstack = entityplayer.getHeldItem(enumHand);
                EntityPebble entity = new EntityPebble(world);
        /*entity.setNinjaHealth(1.0D);
        entity.setNinjaMovementSpeed(1.0D);*/
                entity.setOwnerId(entityplayer.getUniqueID());
                entity.setLocationAndAngles(entityplayer.posX, entityplayer.posY, entityplayer.posZ, 0, 0);
                world.spawnEntity(entity);
                itemstack.shrink(1);
                entityplayer.sendMessage(new TextComponentString("Ninja Count: " + NinjaCountHandler.getNinjaCount(entityplayer)));
                NinjaCountHandler.increasePlayerNinjaCount(entityplayer);
            }
        }
        return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItem(enumHand));
    }
}
