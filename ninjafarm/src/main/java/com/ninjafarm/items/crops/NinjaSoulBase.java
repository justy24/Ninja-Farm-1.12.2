package com.ninjafarm.items.crops;

import com.Main;
import com.ninjafarm.init.ModBlocks;
import com.ninjafarm.init.ModItems;
import com.ninjafarm.util.IHasModel;
import com.ninjafarm.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class NinjaSoulBase extends ItemFood implements IHasModel, IPlantable {

    private String ninja;

    public NinjaSoulBase(String name, int heal, float satAmount, boolean isWolfFood) {
        super(heal, satAmount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.NINJATAB);

        ModItems.ITEMS.add(this);

        this.ninja = name;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        if(facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.getPlant(worldIn, pos));
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }

        else return EnumActionResult.FAIL;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.NONE;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        if(this.ninja == "flamy_soul") {
            return ModBlocks.FLAMY_PLANT_BLOCK.getDefaultState();
        }
        if(this.ninja == "pebble_soul") {
            return ModBlocks.PEBBLE_PLANT_BLOCK.getDefaultState();
        }
        if(this.ninja == "chill_soul") {
            return ModBlocks.CHILL_PLANT_BLOCK.getDefaultState();
        }
        return ModBlocks.FLAMY_PLANT_BLOCK.getDefaultState();
    }
}
