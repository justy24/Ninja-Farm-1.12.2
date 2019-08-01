package com.ninjafarm.blocks.fusionaltar;

import net.minecraftforge.items.IItemHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotFusionAltarFuel extends SlotItemHandler {
    public SlotFusionAltarFuel(IItemHandler handler, int index, int x, int y) {
        super(handler, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return TileEntityFusionAltar.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return super.getItemStackLimit(stack);
    }
}
