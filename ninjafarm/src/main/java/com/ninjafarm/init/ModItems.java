package com.ninjafarm.init;

import com.ninjafarm.items.ItemBase;
import com.ninjafarm.items.armor.ArmorBase;
import com.ninjafarm.items.crops.FoodBase;
import com.ninjafarm.items.crops.ItemRice;
import com.ninjafarm.items.tools.ToolStaff;
import com.ninjafarm.items.tools.ToolSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    //items
    public static final Item ANTIBED = new ItemBase("antibed", CreativeTabs.DECORATIONS);
    public static final Item OWO = new ItemBase("owo", CreativeTabs.MATERIALS);
    public static final Item AWA = new ItemBase("awa", CreativeTabs.MATERIALS);
    public static final Item EWE = new ItemBase("ewe", CreativeTabs.MATERIALS);
    public static final Item IWI = new ItemBase("iwi", CreativeTabs.MATERIALS);
    public static final Item UWU = new ItemBase("uwu", CreativeTabs.MATERIALS);
    public static final Item THICC_THIGHS = new ItemBase("thicc_thighs", CreativeTabs.MATERIALS);
    public static final Item THIGHS = new ItemBase("thighs");

    //tools
    public static final Item JUSTINS_TOOL = new ItemBase("justins_tool", CreativeTabs.TOOLS);
    public static final Item MARTINS_TOOL = new ToolStaff("martins_tool");
    public static final Item MAXS_TOOL = new ItemBase("maxs_tool", CreativeTabs.TOOLS);
    public static final Item UWU_SWORD = new ToolSword("uwu_sword", ModMaterials.MATERIAL_UWU);

    //armor
    public static final Item UWU_HELMET = new ArmorBase("uwu_helmet", ModMaterials.ARMOR_MATERIAL_UWU, 1, EntityEquipmentSlot.HEAD);
    public static final Item UWU_CHESTPLATE = new ArmorBase("uwu_chestplate", ModMaterials.ARMOR_MATERIAL_UWU, 1, EntityEquipmentSlot.CHEST);
    public static final Item UWU_LEGGINGS = new ArmorBase("uwu_leggings", ModMaterials.ARMOR_MATERIAL_UWU, 2, EntityEquipmentSlot.LEGS);
    public static final Item UWU_BOOTS = new ArmorBase("uwu_boots", ModMaterials.ARMOR_MATERIAL_UWU, 1, EntityEquipmentSlot.FEET);
    public static final Item THIGH_HELMET = new ArmorBase("thigh_helmet", ModMaterials.ARMOR_MATERIAL_THICC_THIGHS,1, EntityEquipmentSlot.HEAD);
    public static final Item THIGH_CHESTPLATE = new ArmorBase("thigh_chestplate", ModMaterials.ARMOR_MATERIAL_THICC_THIGHS, 1, EntityEquipmentSlot.CHEST);
    public static final Item THIGH_LEGGINGS = new ArmorBase("thigh_leggings", ModMaterials.ARMOR_MATERIAL_THICC_THIGHS,2, EntityEquipmentSlot.LEGS);
    public static final Item THIGH_BOOTS = new ArmorBase("thigh_boots", ModMaterials.ARMOR_MATERIAL_THICC_THIGHS, 1,EntityEquipmentSlot.FEET);

    //crops
    public static final Item RICE = new ItemRice("rice", 0, 1, false);

    //food
    public static final Item RICE_BOWL = new FoodBase("rice_bowl", 0, 8, false);



}
