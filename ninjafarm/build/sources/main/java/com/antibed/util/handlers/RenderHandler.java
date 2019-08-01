package com.antibed.util.handlers;

import com.antibed.entity.EntityAnimeGirl;
import com.antibed.entity.render.RenderAnimeGirl;
import com.antibed.init.ModBlocks;
import com.antibed.init.ModFluids;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityAnimeGirl.class, new IRenderFactory<EntityAnimeGirl>() {
            @Override
            public Render<? super EntityAnimeGirl> createRenderFor(RenderManager manager) {
                return new RenderAnimeGirl(manager);
            }
        });
    }

    public static void CallMe() {
        new RenderHandler().registerCustomMeshesAndStates();
    }

    public void registerCustomMeshesAndStates() {
        ModFluids.renderFluids();
    }
}
