package com.ninjafarm.util.cababilities.ninjacount;

/**
 * Default implementation of INinjaCount
 */
public class NinjaCount implements INinjaCount {
    private int count = 0;

    public void setNinjaCount(int count) {
        this.count = count;
    }
    public int getNinjaCount() {
        return this.count;
    }
}
