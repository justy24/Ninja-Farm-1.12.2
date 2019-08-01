package com.ninjafarm.util.handlers;

import com.ninjafarm.entity.EntityCentaur;
import com.ninjafarm.entity.render.RenderCentaur;
import com.ninjafarm.init.ModFluids;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
            @Override
            public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
                return new RenderCentaur(manager);
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
