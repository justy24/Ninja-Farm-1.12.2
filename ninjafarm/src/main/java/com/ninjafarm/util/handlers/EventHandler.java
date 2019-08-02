package com.ninjafarm.util.handlers;

import com.ninjafarm.guis.GuiUpdatedInventory;
import com.ninjafarm.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

    @SubscribeEvent
    public static void openGui(GuiOpenEvent event) {
        if(event.getGui() instanceof GuiInventory) event.setGui(new GuiUpdatedInventory(Minecraft.getMinecraft().player));
    }
}
