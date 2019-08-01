package com.antibed.entity.render;

import com.antibed.entity.EntityAnimeGirl;
import com.antibed.entity.model.ModelAnimeGirl;
import com.antibed.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderAnimeGirl extends RenderLiving<EntityAnimeGirl> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/animegirl.png");

    public RenderAnimeGirl(RenderManager manager) {
        super(manager, new ModelAnimeGirl(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAnimeGirl entityAnimeGirl) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityAnimeGirl p_applyRotations_1_, float p_applyRotations_2_, float p_applyRotations_3_, float p_applyRotations_4_) {
        super.applyRotations(p_applyRotations_1_, p_applyRotations_2_, p_applyRotations_3_, p_applyRotations_4_);
    }
}
