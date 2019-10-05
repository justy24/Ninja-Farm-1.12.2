package com.ninjafarm.init;

import com.Main;
import com.ninjafarm.entity.EntityNinja;
import com.ninjafarm.entity.chill.EntityChill;
import com.ninjafarm.entity.flamy.EntityFlamy;
import com.ninjafarm.entity.pebble.EntityPebble;
import com.ninjafarm.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

    public static void registerEntities() {
        registerEntity("flamy", EntityFlamy.class, Reference.ENTITY_FLAMY, 50);
        registerEntity("pebble", EntityPebble.class, Reference.ENTITY_PEBBLE, 50);
        registerEntity("chill", EntityChill.class, Reference.ENTITY_CHILL, 50);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true);
    }
}
