package com.ninjafarm.init;

import com.ninjafarm.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {

    //tools
    public static final Item.ToolMaterial MATERIAL_THICC_THIGHS = EnumHelper.addToolMaterial("material_thicc_thighs", 2, 2000, 16.0F, 7.0F, 10);
    public static final Item.ToolMaterial MATERIAL_UWU = EnumHelper.addToolMaterial("material_uwu", 4,2000, 15.0F, 6.0F, 10);
    public static final Item.ToolMaterial MATERIAL_UWU_THIGHS = EnumHelper.addToolMaterial("material_uwu_thighs", 8,4000, 25.0F, 15.0F, 10);

    //armor
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_UWU = EnumHelper.addArmorMaterial("armor_material_uwu", Reference.MOD_ID + ":uwu", 25, new int[] {6, 16, 12, 6}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_THICC_THIGHS = EnumHelper.addArmorMaterial("armor_material_thicc_thighs", Reference.MOD_ID + ":thicc_thighs", 30, new int[] {8, 14, 18, 8}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
}
