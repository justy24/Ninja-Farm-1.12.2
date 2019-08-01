package com.antibed.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.awt.*;

public class FluidBase extends Fluid {
    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay) {
        super(name, still, flow, overlay);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, Color color) {
        super(name, still, flow, overlay);
        this.setColor(color);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, Color color, int luminosity) {
        super(name, still, flow, overlay);
        this.setColor(color);
        this.setLuminosity(luminosity);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, Color color, int luminosity, int density) {
        super(name, still, flow, overlay);
        this.setColor(color);
        this.setLuminosity(luminosity);
        this.setDensity(density);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, Color color, int luminosity, int density, int temperature) {
        super(name, still, flow, overlay);
        this.setColor(color);
        this.setLuminosity(luminosity);
        this.setDensity(density);
        this.setTemperature(temperature);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flow, ResourceLocation overlay, Color color, int luminosity, int density, int temperature, int viscosity) {
        super(name, still, flow, overlay);
        this.setColor(color);
        this.setLuminosity(luminosity);
        this.setDensity(density);
        this.setTemperature(temperature);
        this.setViscosity(viscosity);
    }
}

/*Default Values
    this.luminosity = 0;
    this.density = 1000;
    this.temperature = 300;
    this.viscosity = 1000;
    this.rarity = EnumRarity.COMMON;
    this.block = null;
    this.color = -1;
    this.fluidName = fluidName.toLowerCase(Locale.ENGLISH);
    this.unlocalizedName = fluidName;
    this.still = still;
    this.flowing = flowing;
    this.overlay = overlay;*/
