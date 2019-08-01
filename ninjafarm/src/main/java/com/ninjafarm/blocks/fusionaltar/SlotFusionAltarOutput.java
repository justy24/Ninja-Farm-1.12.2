package com.ninjafarm.blocks.fusionaltar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.items.IItemHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotFusionAltarOutput extends SlotItemHandler {
    private final EntityPlayer player;
    private int removeCount;

    public SlotFusionAltarOutput(EntityPlayer player, IItemHandler handler, int index, int x, int y) {
        super(handler, index, x, y);
        this.player = player;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return false;
    }

    @Override
    public ItemStack onTake(EntityPlayer player, ItemStack stack) {
        this.onCrafting(stack);
        super.onTake(player, stack);
        return stack;
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        if (this.getHasStack()) this.removeCount += Math.min(amount, this.getStack().getCount());
        return super.decrStackSize(amount);
    }
}
