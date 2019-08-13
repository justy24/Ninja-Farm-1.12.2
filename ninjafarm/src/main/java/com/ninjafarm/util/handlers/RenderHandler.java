package com.ninjafarm.util.handlers;

import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.flamy.RenderFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.entity.pebble.RenderPebble;
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
        RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new IRenderFactory<EntityPebble>() {
            @Override
            public Render<? super EntityPebble> createRenderFor(RenderManager manager) {
                return new RenderPebble(manager);
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
