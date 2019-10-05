package com.ninjafarm.util.cababilities.ninjacount;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * This class is responsible for saving and reading mana data from or to server
 */
public class NinjaCountStorage implements Capability.IStorage<INinjaCount>
{
    @Override
    public NBTBase writeNBT(Capability<INinjaCount> capability, INinjaCount instance, EnumFacing side)
    {
        return new NBTTagFloat(instance.getNinjaCount());
    }

    @Override
    public void readNBT(Capability<INinjaCount> capability, INinjaCount instance, EnumFacing side, NBTBase nbt)
    {
        instance.setNinjaCount(((NBTPrimitive)nbt).getInt());
    }
}