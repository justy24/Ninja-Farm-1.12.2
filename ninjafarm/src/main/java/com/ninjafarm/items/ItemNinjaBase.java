package com.ninjafarm.items;

import com.Main;
import com.ninjafarm.entity.EntityNinja;
import com.ninjafarm.entity.chill.EntityChill;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemNinjaBase extends Item implements IHasModel {

    private String ninjaType;
    private EntityNinja entity;

    public ItemNinjaBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.NINJATAB);

        ModItems.ITEMS.add(this);

        this.ninjaType = name;
        this.maxStackSize = 1;
    }

    public void registerModels(){

        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entityplayer, EnumHand enumHand) {
        if (!world.isRemote) {
            int previous = entityplayer.getCapability(NinjaCountProvider.NINJA_COUNT, null).getNinjaCount();
            if(previous < 5) {
                ItemStack itemstack = entityplayer.getHeldItem(enumHand);
                if(selectNinjaType(this.ninjaType, world, entityplayer)) {
                    entity.setTamed(true);
                    //entity.setOwnerId(entityplayer.getUniqueID());
                    entity.setPlayer(entityplayer);
                    entity.setLocationAndAngles(entityplayer.posX, entityplayer.posY, entityplayer.posZ, 0, 0);
                    world.spawnEntity(entity);
                    itemstack.shrink(1);
                    entityplayer.sendMessage(new TextComponentString("Ninja Count: " + (int)(previous + 1)));
                    entityplayer.getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(previous + 1);
                }
            }
        }
        return new ActionResult(EnumActionResult.PASS, entityplayer.getHeldItem(enumHand));
    }

    public boolean selectNinjaType(String entity, World world, EntityPlayer player) {
        if(entity == "flamy") {
            this.entity = new EntityFlamy(world);
            return true;
        }
        else if(entity == "pebble") {
            this.entity = new EntityPebble(world);
            return true;
        }
        else if(entity == "chill") {
            this.entity = new EntityChill(world);
            return true;
        }
        else {
            player.sendMessage(new TextComponentString("Ninja mob not implemented yet. :("));
            return false;
        }
    }
}
