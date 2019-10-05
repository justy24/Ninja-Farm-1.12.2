package com.ninjafarm.init;

import com.Main;
import com.ninjafarm.items.ItemBase;
import com.ninjafarm.items.ItemDebugNinjaWand;
import com.ninjafarm.items.ItemNinjaWand;
import com.ninjafarm.items.crops.NinjaSoulBase;
import com.ninjafarm.items.ItemNinjaBase;
import net.minecraft.item.Item;
import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    //items

    //tools

    //armor

    //crops
    public static final Item FLAMY_SOUL = new NinjaSoulBase("flamy_soul", 0, 0, false);
    public static final Item PEBBLE_SOUL = new NinjaSoulBase("pebble_soul", 0, 0, false);
    public static final Item CHILL_SOUL = new NinjaSoulBase("chill_soul", 0, 0, false);

    //food

    //ninja items
    public static final Item NINJA_WAND = new ItemNinjaWand("ninja_wand");
    public static final Item DEBUG_NINJA_WAND = new ItemDebugNinjaWand("debug_ninja_wand");
    public static final Item SHURIKEN = new ItemBase("shuriken", Main.NINJATAB);

    //ninja souls
    public static final Item FLAMY = new ItemNinjaBase("flamy");
    public static final Item CHILL = new ItemNinjaBase("chill");
    public static final Item PEBBLE = new ItemNinjaBase("pebble");
    public static final Item LITE = new ItemNinjaBase("lite");
    public static final Item ONYX = new ItemNinjaBase("onyx");
    public static final Item KYANITE = new ItemNinjaBase("kyanite");
}
