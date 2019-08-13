package com.ninjafarm.entity.pebble;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelPebble - justy24
 * Created using Tabula 7.0.1
 */
public class ModelPebble extends ModelBase {
    public ModelRenderer UpperChest;
    public ModelRenderer LowerChest;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer LeftLeg;

    public ModelPebble() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.RightArm = new ModelRenderer(this, 60, 23);
        this.RightArm.setRotationPoint(-2.0F, -6.5F, 0.0F);
        this.RightArm.addBox(-13.0F, -2.5F, -3.0F, 6, 21, 6, 0.0F);
        this.LeftArm = new ModelRenderer(this, 60, 58);
        this.LeftArm.setRotationPoint(0.0F, -6.5F, 0.0F);
        this.LeftArm.addBox(9.0F, -2.5F, -3.0F, 6, 21, 6, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-1.0F, -7.0F, 0.0F);
        this.Head.addBox(-4.0F, -12.0F, -5.5F, 10, 10, 10, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 64, 0);
        this.LeftLeg.setRotationPoint(5.0F, 11.0F, 0.0F);
        this.LeftLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 6, 0.0F);
        this.UpperChest = new ModelRenderer(this, 0, 39);
        this.UpperChest.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.UpperChest.addBox(-9.0F, -2.0F, -6.0F, 18, 12, 12, 0.0F);
        this.LowerChest = new ModelRenderer(this, 0, 70);
        this.LowerChest.setRotationPoint(-2.5F, -7.0F, 0.0F);
        this.LowerChest.addBox(-4.5F, 10.0F, -3.0F, 14, 5, 6, 0.5F);
        this.RightLeg = new ModelRenderer(this, 41, 1);
        this.RightLeg.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.RightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.RightArm.render(f5);
        this.LeftArm.render(f5);
        this.Head.render(f5);
        this.LeftLeg.render(f5);
        this.UpperChest.render(f5);
        this.LowerChest.render(f5);
        this.RightLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
        this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount;

        this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6F) * 0.9F * MathHelper.abs(limbSwingAmount);
        this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6F + (float)Math.PI) * 0.9F * MathHelper.abs(limbSwingAmount);

        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Head.rotateAngleX = headPitch * 0.017453292F;
    }
}
