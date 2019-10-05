package com.ninjafarm.util.cababilities.owner;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class OwnerProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IOwner.class)
    public static final Capability<IOwner> OWNER = null;

    private IOwner instance = OWNER.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == OWNER;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == OWNER ? OWNER.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return OWNER.getStorage().writeNBT(OWNER, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        OWNER.getStorage().readNBT(OWNER, this.instance, null, nbt);
    }
}
