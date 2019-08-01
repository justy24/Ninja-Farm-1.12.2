package com.antibed.init;

import com.Main;
import com.antibed.entity.EntityAnimeGirl;
import com.antibed.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
    public static void registerEntities() {
    registerEntity("anime_girl", EntityAnimeGirl.class, Reference.ENTITY_ANIME_GIRL, 50, 16777181, 2544047);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
