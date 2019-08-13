package com.ninjafarm.util;

import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

public class PlayerNinjaCount {
    private int ninjaCount = 1;
    private EntityPlayer player;
    public PlayerNinjaCount(EntityPlayer player){
        this.ninjaCount = 1;
        this.player = player;
    }

    public void increaseNinjaCount() {
        this.ninjaCount++;
    }

    public void decreaseNinjaCount() {
        this.ninjaCount--;
    }

    public int getNinjaCount() {
        return this.ninjaCount;
    }

    public UUID getUniqueID() {
        return this.player.getUniqueID();
    }
}
