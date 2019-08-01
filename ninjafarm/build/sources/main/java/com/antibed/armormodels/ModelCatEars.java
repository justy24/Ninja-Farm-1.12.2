package armormodels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelCatEars extends ModelBase {
    public ModelRenderer Left_Ear;
    public ModelRenderer Right_Ear;

    public ModelCatEars() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Left_Ear = new ModelRenderer(this, 64, 10);
        this.Left_Ear.setRotationPoint(-4.0F, -8.0F, -2.0F);
        this.Left_Ear.addBox(5.0F, -3.0F, 0.0F, 3, 3, 3, 0.0F);
        this.Right_Ear = new ModelRenderer(this, 64, 10);
        this.Right_Ear.setRotationPoint(-4.0F, -8.0F, -2.0F);
        this.Right_Ear.addBox(0.0F, -3.0F, 0.0F, 3, 3, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Left_Ear.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Right_Ear.offsetX, this.Right_Ear.offsetY, this.Right_Ear.offsetZ);
        GlStateManager.translate(this.Right_Ear.rotationPointX * f5, this.Right_Ear.rotationPointY * f5, this.Right_Ear.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.0D, 1.0D);
        GlStateManager.translate(-this.Right_Ear.offsetX, -this.Right_Ear.offsetY, -this.Right_Ear.offsetZ);
        GlStateManager.translate(-this.Right_Ear.rotationPointX * f5, -this.Right_Ear.rotationPointY * f5, -this.Right_Ear.rotationPointZ * f5);
        this.Right_Ear.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
