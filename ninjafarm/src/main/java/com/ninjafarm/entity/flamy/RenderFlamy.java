package com.ninjafarm.entity.flamy;

import com.ninjafarm.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFlamy extends RenderLiving<EntityFlamy>
{
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/flamy.png");

    public RenderFlamy(RenderManager manager) {
        super(manager, new ModelFlamy(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFlamy entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityFlamy entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}