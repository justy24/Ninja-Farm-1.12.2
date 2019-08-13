package com.ninjafarm.util.handlers;

import com.ninjafarm.util.PlayerNinjaCount;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class NinjaCountHandler {
    public static final List<PlayerNinjaCount> PLAYERS = new ArrayList<>();

    public static void registerPlayerNinjaCount(EntityPlayer player) {
        boolean detect = false;
        for(int i = 0; i < PLAYERS.size(); i++) {
            if(PLAYERS.get(i).getUniqueID() == player.getUniqueID()) {
                detect = true;
            }
        }
        if(detect == false) {
            PLAYERS.add(new PlayerNinjaCount(player));
        }
    }

    public static void increasePlayerNinjaCount(EntityPlayer player) {
        for(int i = 0; i < PLAYERS.size(); i++) {
            if(PLAYERS.get(i).getUniqueID() == player.getUniqueID()) {
                PLAYERS.get(i).increaseNinjaCount();
            }
        }
    }

    public static void decreasePlayerNinjaCount(EntityPlayer player) {
        for(int i = 0; i < PLAYERS.size(); i++) {
            if(PLAYERS.get(i).getUniqueID() == player.getUniqueID()) {
                PLAYERS.get(i).decreaseNinjaCount();
            }
        }
    }

    public static int getNinjaCount(EntityPlayer player) {
        int temp = 0;
        for(int i = 0; i < PLAYERS.size(); i++) {
            if(PLAYERS.get(i).getUniqueID() == player.getUniqueID()) {
                temp = i;
            }
        }
        return PLAYERS.get(temp).getNinjaCount();
    }
}
