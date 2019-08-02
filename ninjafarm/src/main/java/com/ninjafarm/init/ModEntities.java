package com.ninjafarm.init;

import com.Main;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
    public static void registerEntities() {
        registerEntity("flamy", EntityFlamy.class, Reference.ENTITY_FLAMY, 50, 16777181, 2544047);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
