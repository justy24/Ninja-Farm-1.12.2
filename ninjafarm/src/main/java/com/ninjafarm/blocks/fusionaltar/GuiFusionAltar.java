package com.ninjafarm.blocks.fusionaltar;

import com.ninjafarm.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;

public class GuiFusionAltar extends GuiContainer {
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/fusion_altar.png");
    private final InventoryPlayer player;
    private final TileEntityFusionAltar tileentity;

    public GuiFusionAltar(InventoryPlayer player, TileEntityFusionAltar tileentity)
    {
        super(new ContainerFusionAltar(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String tileName = this.tileentity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntityFusionAltar.isBurning(tileentity))
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(this.guiLeft + 82, this.guiTop + 62 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(24);
        if(tileentity.isInputEmpty()) l = 0;
        this.drawTexturedModalRect(this.guiLeft + 55, this.guiTop + 15, 176, 14, l + 1, 16);
        this.drawTexturedModalRect(this.guiLeft + 99, this.guiTop + 15, 176, 32, 23 - l, 16);
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileentity.getField(1);
        if(i == 0) i = 200;
        return this.tileentity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
