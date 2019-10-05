package com.ninjafarm.util.cababilities.ninjacount;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NinjaCountProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(INinjaCount.class)
    public static final Capability<INinjaCount> NINJA_COUNT = null;

    private INinjaCount instance = NINJA_COUNT.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == NINJA_COUNT;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == NINJA_COUNT ? NINJA_COUNT.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return NINJA_COUNT.getStorage().writeNBT(NINJA_COUNT, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        NINJA_COUNT.getStorage().readNBT(NINJA_COUNT, this.instance, null, nbt);
    }
}
