package com.ninjafarm.util.handlers;

import com.ninjafarm.blocks.fusionaltar.ContainerFusionAltar;
import com.ninjafarm.blocks.fusionaltar.GuiFusionAltar;
import com.ninjafarm.blocks.fusionaltar.TileEntityFusionAltar;
import com.ninjafarm.blocks.incensecondenser.ContainerIncenseCondenser;
import com.ninjafarm.blocks.incensecondenser.GuiIncenseCondenser;
import com.ninjafarm.blocks.incensecondenser.TileEntityIncenseCondenser;
import com.ninjafarm.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FUSION_ALTAR) return new ContainerFusionAltar(player.inventory, (TileEntityFusionAltar) world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == Reference.GUI_INCENSE_CONDENSER) return new ContainerIncenseCondenser(player.inventory, (TileEntityIncenseCondenser) world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_FUSION_ALTAR) return new GuiFusionAltar(player.inventory, (TileEntityFusionAltar) world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == Reference.GUI_INCENSE_CONDENSER) return new GuiIncenseCondenser(player.inventory, (TileEntityIncenseCondenser) world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}
