package com.ninjafarm.init;

import com.ninjafarm.fluids.FluidBase;
import com.ninjafarm.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.awt.*;

public class ModFluids {
    public static final Fluid FAKE_WATER = new FluidBase("fake_water", new ResourceLocation("ab:blocks/fake_water_still"), new ResourceLocation("ab:blocks/fake_water_flow"), new ResourceLocation("ab:blocks/fake_water_overlay"), Color.YELLOW, 0, 1000, 300, 1000);
    public static final Fluid FAKE_MILK = new FluidBase("fake_milk", new ResourceLocation("ab:blocks/fake_milk_still"), new ResourceLocation("ab:blocks/fake_milk_flow"), new ResourceLocation("ab:blocks/fake_milk_overlay"), Color.WHITE, 0, 1000, 300, 1000);
    public static final Fluid FAKE_TEARS = new FluidBase("fake_tears", new ResourceLocation("ab:blocks/fake_tears_still"), new ResourceLocation("ab:blocks/fake_tears_flow"), new ResourceLocation("ab:blocks/fake_tears_overlay"), Color.CYAN, 0, 1000, 300, 1000);


    public static void registerFluids() {
        registerFluid(FAKE_WATER);
        registerFluid(FAKE_MILK);
        registerFluid(FAKE_TEARS);
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    public static void renderFluids() {
        renderFluid(ModBlocks.FAKE_WATER_BLOCK, FAKE_WATER);
        renderFluid(ModBlocks.FAKE_MILK_BLOCK, FAKE_MILK);
        renderFluid(ModBlocks.FAKE_TEARS_BLOCK, FAKE_TEARS);
    }

    public static void renderFluid(Block block, Fluid fluid) {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(block), new ItemMeshDefinition() {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation(Reference.MOD_ID + ":" + fluid.getName(), "fluid");
            }
        });

        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {

            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation(Reference.MOD_ID + ":" + fluid.getName(), "fluid");
            }
        });
    }
}
