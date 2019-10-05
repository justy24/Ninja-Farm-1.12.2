package com.ninjafarm.entity.chill;

import com.ninjafarm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderChill extends RenderLiving<EntityChill>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/chill.png");

    public RenderChill(RenderManager manager) {
        super(manager, new ModelChill(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChill entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityChill entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}