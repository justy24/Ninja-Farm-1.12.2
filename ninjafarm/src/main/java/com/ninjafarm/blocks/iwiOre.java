package com.ninjafarm.blocks;

import com.ninjafarm.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class iwiOre extends BlockBase {
    public iwiOre(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setResistance(15.0F);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.IWI;
    }

    @Override
    public int quantityDropped(Random rand) {
        int max = 3;
        int min = 1;
        return rand.nextInt(max) + min;
    }
}
