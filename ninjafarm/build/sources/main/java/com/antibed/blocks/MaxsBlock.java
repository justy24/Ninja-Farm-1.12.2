package com.antibed.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class MaxsBlock extends BlockBase {
    public MaxsBlock(){
        super("maxs_block", Material.IRON);
        setSoundType(SoundType.ANVIL);
        setHardness(3.0f);
        setResistance(3.0f);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(-15.0f);
        //setLightOpacity(1);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public void observedNeighborChange(IBlockState observerState, World world, BlockPos observerPos, Block changedBlock, BlockPos changedBlockPos) {
        super.observedNeighborChange(observerState, world, observerPos, changedBlock, changedBlockPos);
        System.out.println("change");
        if(world.getBlockState(changedBlockPos).canProvidePower()) {
            System.out.println("boom");
            if(world.isBlockPowered(observerPos)){
                Random rand = new Random();
                for(int x = -9; x < 10; x++){
                    for(int y = -9; y < 10; y++){
                        for(int z = -9; z < 10; z++){
                            if(Math.sqrt(x*x+y*y+z*z)<9) {
                                world.setBlockToAir(observerPos.up(x).east(y).north(z));
                            }
                        }
                    }
                }
                world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, changedBlockPos.getX(), changedBlockPos.getY(), changedBlockPos.getZ(), 5.0D, 5.0D, 5.0D);
            }
        }
        //world.spawnParticle(EnumParticleTypes.getParticleFromId(0), observerPos);
        world.setWorldTime(world.getWorldTime()+1000);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        if(worldIn.getWorldTime() < 13000){
            worldIn.setWorldTime(13000);
        }
    }
}
