package com.ninjafarm.util.handlers;

import com.ninjafarm.blocks.fusionaltar.TileEntityFusionAltar;
import com.ninjafarm.blocks.incensecondenser.TileEntityIncenseCondenser;
import com.ninjafarm.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityFusionAltar.class, new ResourceLocation(Reference.MOD_ID + ":fusion_altar"));
        GameRegistry.registerTileEntity(TileEntityIncenseCondenser.class, new ResourceLocation(Reference.MOD_ID + ":incense_condenser"));
    }
}
