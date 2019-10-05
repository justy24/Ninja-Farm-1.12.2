package com.ninjafarm.entity.pebble;

import com.ninjafarm.entity.EntityNinja;
import com.ninjafarm.util.handlers.LootTableHandler;
import com.ninjafarm.util.handlers.SoundsHandler;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityPebble extends EntityNinja {
    public EntityPebble(World worldIn) {
        super(worldIn, 1.4F, 2.7F,2.5F, 30.0D, 0.2D, 2.0D);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.PEBBLE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundsHandler.ENTITY_PEBBLE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundsHandler.ENTITY_PEBBLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundsHandler.ENTITY_PEBBLE_DEATH;
    }
}