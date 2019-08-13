package com.ninjafarm.init;

import com.ninjafarm.items.ItemBase;
import com.ninjafarm.items.ItemNinjaWand;
import com.ninjafarm.items.armor.ArmorBase;
import com.ninjafarm.items.crops.FoodBase;
import com.ninjafarm.items.crops.ItemRice;
import com.ninjafarm.items.ninjas.ItemFlamy;
import com.ninjafarm.items.ninjas.ItemPebble;
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

    //tools

    //armor

    //crops
    public static final Item RICE = new ItemRice("rice", 0, 1, false);
    public static final Item FLAMY_SOUL = new ItemRice("flamy_soul", 0, 0, false);

    //food

    //ninja items
    public static final Item NINJA_WAND = new ItemNinjaWand("ninja_wand");
    public static final Item FLAMY = new ItemFlamy("flamy");
    public static final Item PEBBLE = new ItemPebble("pebble");
}
