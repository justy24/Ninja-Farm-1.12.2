package com.ninjafarm.entity.pebble;

import com.ninjafarm.entity.flamy.ModelFlamy;
import com.ninjafarm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderPebble extends RenderLiving<EntityPebble>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/pebble.png");

    public RenderPebble(RenderManager manager) {
        super(manager, new ModelPebble(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPebble entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityPebble entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}