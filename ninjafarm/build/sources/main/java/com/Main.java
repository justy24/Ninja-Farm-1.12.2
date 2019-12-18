package com;

import com.ninjafarm.proxy.CommonProxy;
import com.ninjafarm.tabs.NinjaTab;
import com.ninjafarm.util.ClearNinjaCountCommand;
import com.ninjafarm.util.Reference;
import com.ninjafarm.util.getUUIDCommand;
import com.ninjafarm.util.handlers.RegistryHandler;
import com.ninjafarm.world.ModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.VERSION, version = Reference.VERSION)
public class Main {

    @Mod.Instance
    public static Main instance;

    public static final CreativeTabs NINJATAB = new NinjaTab("ninjatab");

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event){
        RegistryHandler.preInitRegistries();
        proxy.init();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        RegistryHandler.initRegistries();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event){

    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // register server commands

        event.registerServerCommand(new getUUIDCommand());
        event.registerServerCommand(new ClearNinjaCountCommand());
    }
}
