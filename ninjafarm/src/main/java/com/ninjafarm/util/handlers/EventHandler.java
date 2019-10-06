package com.ninjafarm.util.handlers;

import com.ninjafarm.guis.GuiUpdatedInventory;
import com.ninjafarm.util.cababilities.ninjacount.INinjaCount;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import com.ninjafarm.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void openGui(GuiOpenEvent event) {
        if(event.getGui() instanceof GuiInventory) event.setGui(new GuiUpdatedInventory(Minecraft.getMinecraft().player));
    }

    /*@SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        EntityPlayer player = event.player;
        INinjaCount ninjaCount = player.getCapability(NinjaCountProvider.NINJA_COUNT, null);
        INinjaCount oldNinjaCount = player.getCapability(NinjaCountProvider.NINJA_COUNT, null);

        ninjaCount.setNinjaCount(ninjaCount.getNinjaCount());
    }*/
}
