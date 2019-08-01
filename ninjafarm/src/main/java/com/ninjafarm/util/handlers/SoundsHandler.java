package com.ninjafarm.util.handlers;

import com.ninjafarm.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler
{
    public static SoundEvent ENTITY_FLAMY_AMBIENT, ENTITY_FLAMY_HURT, ENTITY_FLAMY_DEATH;

    public static void registerSounds()
    {
        ENTITY_FLAMY_AMBIENT = registerSound("entity.flamy.ambient");
        ENTITY_FLAMY_HURT = registerSound("entity.flamy.hurt");
        ENTITY_FLAMY_DEATH = registerSound("entity.flamy.death");
    }

    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}