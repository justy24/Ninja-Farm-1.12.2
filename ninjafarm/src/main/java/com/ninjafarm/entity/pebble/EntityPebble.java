package com.ninjafarm.entity.pebble;

import com.google.common.base.Optional;
import com.ninjafarm.util.handlers.LootTableHandler;
import com.ninjafarm.util.handlers.SoundsHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityPebble extends EntityTameable
{
    //private double health;
    //private double movementSpeed;
    public EntityPebble(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 2.7F);
        //this.health = 20.0D;
        //this.movementSpeed = 0.2D;
    }

    @Override
    protected void initEntityAI() {
        //this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        /*this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.0D);*/
    }

    @Override
    public float getEyeHeight() {
        return 2.5F;
    }

    @Override
    public EntityCow createChild(EntityAgeable ageable) {
        return null;
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

    @Override
    public void setOwnerId(@Nullable UUID p_setOwnerId_1_) {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(p_setOwnerId_1_));
    }

    @Override
    public UUID getOwnerId() {
        return (UUID)((Optional)this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
    }

    /*public void setNinjaHealth(double health) {
        this.health = health;
        applyEntityAttributes();
    }

    public double getNinjaHealth() {
        return this.health;
    }

    public void setNinjaMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
        applyEntityAttributes();
    }

    public double getNinjaMovementSpeed() {
        return this.movementSpeed;
    }*/
}