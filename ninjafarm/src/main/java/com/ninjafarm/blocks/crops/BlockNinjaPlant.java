package com.ninjafarm.blocks.crops;

import com.Main;
import com.ninjafarm.init.ModBlocks;
import com.ninjafarm.init.ModItems;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

public class BlockNinjaPlant extends BlockCrops {

    //private static final AxisAlignedBB[] ninja_plant = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
    private static final AxisAlignedBB[] ninja_plant = {new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.125D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.25D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.375D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.5D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.625D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.75D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 0.875D, 0.75D), new AxisAlignedBB(0.25D, 0, 0.25D, 0.75D, 1D, 0.75D)};
    private String ninja;

    public BlockNinjaPlant(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.NINJATAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        this.ninja = name;
        this.blockSoundType = SoundType.PLANT;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            if(this.isMaxAge(state)) {
                cropDrops(worldIn, pos);
                worldIn.setBlockToAir(pos);
                return true;
            }
        }
        return false;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
    }

    public void cropDrops(World worldIn, BlockPos pos) {
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this.getCrop(), 1)));
    }

    @Override
    protected Item getSeed() { //what is required to plant
        if(this.ninja == "flamy_plant") {
            return ModItems.FLAMY_SOUL;
        }
        if(this.ninja == "pebble_plant") {
            return ModItems.PEBBLE_SOUL;
        }
        if(this.ninja == "chill_plant") {
            return ModItems.CHILL_SOUL;
        }
        return ModItems.FLAMY_SOUL;
    }

    @Override
    protected Item getCrop() { //what is dropped when grown
        if(this.ninja == "flamy_plant") {
            return ModItems.FLAMY;
        }
        if(this.ninja == "pebble_plant") {
            return ModItems.PEBBLE;
        }
        if(this.ninja == "chill_plant") {
            return ModItems.CHILL;
        }
        return ModItems.FLAMY;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return ninja_plant[((Integer)state.getValue(this.getAgeProperty())).intValue()];
        //return ninja_plant;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    /*@Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return false;
    }*/
}
