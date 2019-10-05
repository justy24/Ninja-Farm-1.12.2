package com.ninjafarm.init;

import com.ninjafarm.blocks.fusionaltar.BlockFusionAltar;
import com.ninjafarm.blocks.crops.BlockNinjaPlant;
import com.ninjafarm.blocks.incensecondenser.BlockIncenseCondenser;
import net.minecraft.block.Block;

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
    public static final Block FLAMY_PLANT_BLOCK = new BlockNinjaPlant("flamy_plant");
    public static final Block PEBBLE_PLANT_BLOCK = new BlockNinjaPlant("pebble_plant");
    public static final Block CHILL_PLANT_BLOCK = new BlockNinjaPlant("chill_plant");

    //misc
}
