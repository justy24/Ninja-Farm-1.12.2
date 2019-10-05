package com.ninjafarm.util.cababilities.owner;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * This class is responsible for saving and reading mana data from or to server
 */
public class OwnerStorage implements Capability.IStorage<IOwner>
{
    @Override
    public NBTBase writeNBT(Capability<IOwner> capability, IOwner instance, EnumFacing side)
    {
        return new NBTTagString(instance.getOwner().toString());
    }

    @Override
    public void readNBT(Capability<IOwner> capability, IOwner instance, EnumFacing side, NBTBase nbt)
    {
        instance.setOwner(((NBTPrimitive)nbt).toString());
    }
}