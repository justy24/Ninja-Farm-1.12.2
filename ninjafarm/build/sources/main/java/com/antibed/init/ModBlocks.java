package com.antibed.init;

import com.antibed.blocks.BlockBase;
import com.antibed.blocks.crops.BlockRicePlant;
import com.antibed.blocks.fluids.BlockFluidBase;
import com.antibed.blocks.MaxsBlock;
import com.antibed.blocks.iwiOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    //decorative
    public static final Block MARTINS_BLOCK = new BlockBase("martins_block", Material.IRON);
    public static final Block MAXS_BLOCK = new MaxsBlock();
    public static final Block JUSTINS_BLOCK = new BlockBase("justins_block", Material.IRON);
    public static final Block CORUM_CORE = new BlockBase("corum_core", Material.IRON);

    //machines

    //multiblocks

    //ore
    public static final Block IWI_ORE = new iwiOre("iwi_ore", Material.ROCK);

    //fluids
    public static final Block FAKE_WATER_BLOCK = new BlockFluidBase("fake_water", ModFluids.FAKE_WATER, Material.WATER);
    public static final Block FAKE_MILK_BLOCK = new BlockFluidBase("fake_milk", ModFluids.FAKE_MILK, Material.WATER);
    public static final Block FAKE_TEARS_BLOCK = new BlockFluidBase("fake_tears", ModFluids.FAKE_TEARS, Material.WATER);

    //crops
    public static final Block RICE_PLANT = new BlockRicePlant("rice_plant");

    //misc
    public static final Block DEBUG_BLOCK = new BlockBase("debug_block", Material.IRON);
}
