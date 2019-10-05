package com.ninjafarm.entity;

import com.google.common.base.Optional;
import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import com.ninjafarm.util.handlers.LootTableHandler;
import com.ninjafarm.util.handlers.SoundsHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityNinja extends EntityTameable
{
    private double health, speed, damage;
    private float eyeHeight;

    private EntityPlayer player;
    public EntityNinja(World worldIn, float width, float height, float eyeHeight, double health, double speed, double damage) {
        super(worldIn);
        this.setSize(width, height);
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.eyeHeight = eyeHeight;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        attributes(10.0D, 0.3D, 2.0D);
    }

    public void attributes(double health, double speed, double damage) {
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(health);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(speed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(damage);
        /*this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.0D);*/
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
        if (flag) {
            this.applyEnchantments(this, entityIn);
        }
        if (entityIn instanceof EntityPlayer) {
            return false;
        }
        return flag;
    }


    @Override
    public float getEyeHeight() {
        return eyeHeight;
    }

    @Override
    public EntityCow createChild(EntityAgeable ageable) {
        return null;
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

    @Override
    public void setOwnerId(@Nullable UUID p_setOwnerId_1_) {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(p_setOwnerId_1_));
    }

    @Override
    public UUID getOwnerId() {
        return (UUID)((Optional)this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote) {
            int previous = player.getCapability(NinjaCountProvider.NINJA_COUNT, null).getNinjaCount();
            player.getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(previous - 1);
        }
    }

    public void setPlayer(EntityPlayer player) {
        this.player = player;
        this.setOwnerId(player.getUniqueID());
    }

    /*@Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (!world.isRemote) {
            for (PlayerNinjaCount player : NinjaCountHandler.PLAYERS) {
                if (player.getUniqueID() == getOwnerId()) {
                    player.increaseNinjaCount();
                }
            }
        }
    }*/


    /*public void setNinjaHealth(double health) {
        this.health = health;
        super.applyEntityAttributes();
    }

    public double getNinjaHealth() {
        return this.health;
    }

    public void setNinjaMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
        super.applyEntityAttributes();
    }

    public double getNinjaMovementSpeed() {
        return this.movementSpeed;
    }*/
}