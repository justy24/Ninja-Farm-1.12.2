package com.ninjafarm.util.cababilities.owner;

import java.util.UUID;

/**
 * Default implementation of INinjaCount
 */
public class Owner implements IOwner {
    private UUID player = UUID.randomUUID();

    public void setOwner(String player) {
        this.player = UUID.fromString(player);
    }
    public UUID getOwner() {
        return this.player;
    }
}
