package com.ninjafarm.init;

import com.ninjafarm.blocks.BlockBase;
import com.ninjafarm.blocks.fluids.BlockFluidBase;
import com.ninjafarm.blocks.fusionaltar.BlockFusionAltar;
import com.ninjafarm.blocks.crops.BlockRicePlant;
import com.ninjafarm.blocks.incensecondenser.BlockIncenseCondenser;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    //decorative

    //machines

    //custom crafting
    public static final Block FUSION_ALTAR = new BlockFusionAltar("fusion_altar");
    public static final Block INCENSE_CONDENSER = new BlockIncenseCondenser("incense_condenser");

    //multiblocks

    //ore

    //fluids

    //crops
    public static final Block RICE_PLANT = new BlockRicePlant("rice_plant");

    //misc
}
