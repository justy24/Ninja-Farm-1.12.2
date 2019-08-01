package com.antibed.entity;

import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAnimeGirl extends EntityPigZombie {
    public EntityAnimeGirl(World world) {
    super(world);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLOCK_ANVIL_PLACE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.AMBIENT_CAVE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return super.getDeathSound();
    }
}
