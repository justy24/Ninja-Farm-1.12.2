package com.ninjafarm.util.handlers;

import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import com.ninjafarm.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler
{
    public static final ResourceLocation NINJA_COUNT = new ResourceLocation(Reference.MOD_ID, "ninja_count");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(NINJA_COUNT, new NinjaCountProvider());
        }
        return;
    }
}