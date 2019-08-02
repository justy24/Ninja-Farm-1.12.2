package com.ninjafarm.items.ninjas;

import com.Main;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFlamy extends Item implements IHasModel {

    public ItemFlamy(String name){
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
            ItemStack itemstack = entityplayer.getHeldItem(enumHand);
            EntityFlamy entity = new EntityFlamy(world);
        /*entity.setNinjaHealth(1.0D);
        entity.setNinjaMovementSpeed(1.0D);*/
            entity.setOwnerId(entityplayer.getUniqueID());
            entity.setLocationAndAngles(entityplayer.posX, entityplayer.posY, entityplayer.posZ, 0, 0);
            world.spawnEntity(entity);
            itemstack.shrink(1);
        }
        return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItem(enumHand));
    }
}
