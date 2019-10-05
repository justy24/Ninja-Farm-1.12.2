package com.ninjafarm.proxy;

import com.ninjafarm.util.cababilities.ninjacount.INinjaCount;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCount;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCountStorage;
import com.ninjafarm.util.handlers.CapabilityHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id){

    }
    public void init()
    {
        CapabilityManager.INSTANCE.register(INinjaCount.class, new NinjaCountStorage(), NinjaCount.class);
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }
}
