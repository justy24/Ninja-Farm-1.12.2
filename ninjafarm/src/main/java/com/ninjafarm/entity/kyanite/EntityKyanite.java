package com.ninjafarm.entity.kyanite;

import com.ninjafarm.entity.EntityNinja;
import com.ninjafarm.util.handlers.LootTableHandler;
import com.ninjafarm.util.handlers.SoundsHandler;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKyanite extends EntityNinja {
    public EntityKyanite(World worldIn) {
        super(worldIn, 0.6F, 1.95F,1.74F, 20.0D, 0.3D, 2.0D);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.FLAMY;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundsHandler.ENTITY_FLAMY_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundsHandler.ENTITY_FLAMY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundsHandler.ENTITY_FLAMY_DEATH;
    }
}
