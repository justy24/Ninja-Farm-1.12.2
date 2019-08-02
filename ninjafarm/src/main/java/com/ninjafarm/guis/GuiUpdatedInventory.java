package com.ninjafarm.guis;

import java.io.IOException;

import com.Main;
import com.ninjafarm.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiUpdatedInventory extends InventoryEffectRenderer implements IRecipeShownListener {
    private float oldMouseX;
    private float oldMouseY;
    private GuiButtonImage recipeButton, ninjaMenu;
    private final GuiRecipeBook recipeBookGui = new GuiRecipeBook();
    private boolean widthTooNarrow;
    private boolean buttonClicked;
    public static final ResourceLocation UPDATED_INVENTORY_BACKGROUND = new ResourceLocation(Reference.MOD_ID + ":textures/gui/inventory.png");

    public GuiUpdatedInventory(EntityPlayer p_i1094_1_) {
        super(p_i1094_1_.inventoryContainer);
        this.allowUserInput = true;
    }

    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }

        this.recipeBookGui.tick();
    }

    public void initGui() {
        this.buttonList.clear();
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        } else {
            super.initGui();
        }

        this.widthTooNarrow = this.width < 379;
        this.recipeBookGui.func_194303_a(this.width, this.height, this.mc, this.widthTooNarrow, ((ContainerPlayer)this.inventorySlots).craftMatrix);
        this.guiLeft = this.recipeBookGui.updateScreenPosition(this.widthTooNarrow, this.width, this.xSize);
        this.recipeButton = new GuiButtonImage(10, this.guiLeft + 104, this.height / 2 - 22, 20, 18, 178, 0, 19, INVENTORY_BACKGROUND);
        this.buttonList.add(this.recipeButton);
        this.ninjaMenu = new GuiButtonImage(11, this.guiLeft + 149, this.height / 2 - 22, 20, 18, 199, 0, 19, UPDATED_INVENTORY_BACKGROUND);
        this.buttonList.add(this.ninjaMenu);
    }

    protected void drawGuiContainerForegroundLayer(int p_drawGuiContainerForegroundLayer_1_, int p_drawGuiContainerForegroundLayer_2_) {
        this.fontRenderer.drawString(I18n.format("container.crafting", new Object[0]), 97, 8, 4210752);
    }

    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_) {
        this.drawDefaultBackground();
        this.hasActivePotionEffects = !this.recipeBookGui.isVisible();
        if (this.recipeBookGui.isVisible() && this.widthTooNarrow) {
            this.drawGuiContainerBackgroundLayer(p_drawScreen_3_, p_drawScreen_1_, p_drawScreen_2_);
            this.recipeBookGui.render(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
        } else {
            this.recipeBookGui.render(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
            super.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
            this.recipeBookGui.renderGhostRecipe(this.guiLeft, this.guiTop, false, p_drawScreen_3_);
        }

        this.renderHoveredToolTip(p_drawScreen_1_, p_drawScreen_2_);
        this.recipeBookGui.renderTooltip(this.guiLeft, this.guiTop, p_drawScreen_1_, p_drawScreen_2_);
        this.oldMouseX = (float)p_drawScreen_1_;
        this.oldMouseY = (float)p_drawScreen_2_;
    }

    protected void drawGuiContainerBackgroundLayer(float p_drawGuiContainerBackgroundLayer_1_, int p_drawGuiContainerBackgroundLayer_2_, int p_drawGuiContainerBackgroundLayer_3_) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(INVENTORY_BACKGROUND);
        int lvt_4_1_ = this.guiLeft;
        int lvt_5_1_ = this.guiTop;
        this.drawTexturedModalRect(lvt_4_1_, lvt_5_1_, 0, 0, this.xSize, this.ySize);
        drawEntityOnScreen(lvt_4_1_ + 51, lvt_5_1_ + 75, 30, (float)(lvt_4_1_ + 51) - this.oldMouseX, (float)(lvt_5_1_ + 75 - 50) - this.oldMouseY, this.mc.player);
    }

    public static void drawEntityOnScreen(int p_drawEntityOnScreen_0_, int p_drawEntityOnScreen_1_, int p_drawEntityOnScreen_2_, float p_drawEntityOnScreen_3_, float p_drawEntityOnScreen_4_, EntityLivingBase p_drawEntityOnScreen_5_) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)p_drawEntityOnScreen_0_, (float)p_drawEntityOnScreen_1_, 50.0F);
        GlStateManager.scale((float)(-p_drawEntityOnScreen_2_), (float)p_drawEntityOnScreen_2_, (float)p_drawEntityOnScreen_2_);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float lvt_6_1_ = p_drawEntityOnScreen_5_.renderYawOffset;
        float lvt_7_1_ = p_drawEntityOnScreen_5_.rotationYaw;
        float lvt_8_1_ = p_drawEntityOnScreen_5_.rotationPitch;
        float lvt_9_1_ = p_drawEntityOnScreen_5_.prevRotationYawHead;
        float lvt_10_1_ = p_drawEntityOnScreen_5_.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(p_drawEntityOnScreen_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_drawEntityOnScreen_5_.renderYawOffset = (float)Math.atan((double)(p_drawEntityOnScreen_3_ / 40.0F)) * 20.0F;
        p_drawEntityOnScreen_5_.rotationYaw = (float)Math.atan((double)(p_drawEntityOnScreen_3_ / 40.0F)) * 40.0F;
        p_drawEntityOnScreen_5_.rotationPitch = -((float)Math.atan((double)(p_drawEntityOnScreen_4_ / 40.0F))) * 20.0F;
        p_drawEntityOnScreen_5_.rotationYawHead = p_drawEntityOnScreen_5_.rotationYaw;
        p_drawEntityOnScreen_5_.prevRotationYawHead = p_drawEntityOnScreen_5_.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager lvt_11_1_ = Minecraft.getMinecraft().getRenderManager();
        lvt_11_1_.setPlayerViewY(180.0F);
        lvt_11_1_.setRenderShadow(false);
        lvt_11_1_.renderEntity(p_drawEntityOnScreen_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        lvt_11_1_.setRenderShadow(true);
        p_drawEntityOnScreen_5_.renderYawOffset = lvt_6_1_;
        p_drawEntityOnScreen_5_.rotationYaw = lvt_7_1_;
        p_drawEntityOnScreen_5_.rotationPitch = lvt_8_1_;
        p_drawEntityOnScreen_5_.prevRotationYawHead = lvt_9_1_;
        p_drawEntityOnScreen_5_.rotationYawHead = lvt_10_1_;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    protected boolean isPointInRegion(int p_isPointInRegion_1_, int p_isPointInRegion_2_, int p_isPointInRegion_3_, int p_isPointInRegion_4_, int p_isPointInRegion_5_, int p_isPointInRegion_6_) {
        return (!this.widthTooNarrow || !this.recipeBookGui.isVisible()) && super.isPointInRegion(p_isPointInRegion_1_, p_isPointInRegion_2_, p_isPointInRegion_3_, p_isPointInRegion_4_, p_isPointInRegion_5_, p_isPointInRegion_6_);
    }

    protected void mouseClicked(int p_mouseClicked_1_, int p_mouseClicked_2_, int p_mouseClicked_3_) throws IOException {
        if (!this.recipeBookGui.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_)) {
            if (!this.widthTooNarrow || !this.recipeBookGui.isVisible()) {
                super.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_);
            }
        }
    }

    protected void mouseReleased(int p_mouseReleased_1_, int p_mouseReleased_2_, int p_mouseReleased_3_) {
        if (this.buttonClicked) {
            this.buttonClicked = false;
        } else {
            super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_2_, p_mouseReleased_3_);
        }
    }

    protected boolean hasClickedOutside(int p_hasClickedOutside_1_, int p_hasClickedOutside_2_, int p_hasClickedOutside_3_, int p_hasClickedOutside_4_) {
        boolean lvt_5_1_ = p_hasClickedOutside_1_ < p_hasClickedOutside_3_ || p_hasClickedOutside_2_ < p_hasClickedOutside_4_ || p_hasClickedOutside_1_ >= p_hasClickedOutside_3_ + this.xSize || p_hasClickedOutside_2_ >= p_hasClickedOutside_4_ + this.ySize;
        return this.recipeBookGui.hasClickedOutside(p_hasClickedOutside_1_, p_hasClickedOutside_2_, this.guiLeft, this.guiTop, this.xSize, this.ySize) && lvt_5_1_;
    }

    protected void actionPerformed(GuiButton buttonID) throws IOException {
        if (buttonID.id == 10) {
            this.recipeBookGui.initVisuals(this.widthTooNarrow, ((ContainerPlayer)this.inventorySlots).craftMatrix);
            this.recipeBookGui.toggleVisibility();
            this.guiLeft = this.recipeBookGui.updateScreenPosition(this.widthTooNarrow, this.width, this.xSize);
            this.recipeButton.setPosition(this.guiLeft + 104, this.height / 2 - 22);
            this.ninjaMenu.setPosition(this.guiLeft + 149, this.height / 2 -22);
            this.buttonClicked = true;
        }
        if (buttonID.id == 11) {
            GuiIngameMenu menu = new GuiIngameMenu();
            FMLClientHandler.instance().showInGameModOptions(menu);
        }
    }

    protected void keyTyped(char p_keyTyped_1_, int p_keyTyped_2_) throws IOException {
        if (!this.recipeBookGui.keyPressed(p_keyTyped_1_, p_keyTyped_2_)) {
            super.keyTyped(p_keyTyped_1_, p_keyTyped_2_);
        }

    }

    protected void handleMouseClick(Slot p_handleMouseClick_1_, int p_handleMouseClick_2_, int p_handleMouseClick_3_, ClickType p_handleMouseClick_4_) {
        super.handleMouseClick(p_handleMouseClick_1_, p_handleMouseClick_2_, p_handleMouseClick_3_, p_handleMouseClick_4_);
        this.recipeBookGui.slotClicked(p_handleMouseClick_1_);
    }

    public void recipesUpdated() {
        this.recipeBookGui.recipesUpdated();
    }

    public void onGuiClosed() {
        this.recipeBookGui.removed();
        super.onGuiClosed();
    }

    public GuiRecipeBook func_194310_f() {
        return this.recipeBookGui;
    }
}
