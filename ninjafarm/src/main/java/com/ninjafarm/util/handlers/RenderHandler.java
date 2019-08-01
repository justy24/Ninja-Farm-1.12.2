package com.ninjafarm.util.handlers;

import com.ninjafarm.entity.EntityFlamy;
import com.ninjafarm.entity.render.RenderFlamy;
import com.ninjafarm.init.ModFluids;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFlamy.class, new IRenderFactory<EntityFlamy>() {
            @Override
            public Render<? super EntityFlamy> createRenderFor(RenderManager manager) {
                return new RenderFlamy(manager);
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
