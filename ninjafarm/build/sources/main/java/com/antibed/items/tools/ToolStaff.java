package com.antibed.items.tools;

import com.Main;
import com.antibed.init.ModItems;
import com.antibed.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ToolStaff extends Item implements IHasModel {

    public ToolStaff(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.ITEMS.add(this);

    }

    public void registerModels() {

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand p_onItemRightClick_3_) {
        ItemStack itemstack = entityplayer.getHeldItem(p_onItemRightClick_3_);
        EntitySnowball snowball = new EntitySnowball(world, entityplayer);
        snowball.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, 1.5F, 1.0F);
        world.spawnEntity(snowball);
            return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }

    public int getItemEnchantability() { return 0; }

    public int getMaxItemUseDuration(ItemStack p_getMaxItemUseDuration_1_) {
        return 72000;
    }

}
