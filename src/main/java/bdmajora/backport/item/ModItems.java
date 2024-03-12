package bdmajora.backport.item;

import bdmajora.backport.BackPort;
import bdmajora.backport.UtilIdRegistrar;
import bdmajora.backport.block.ModBlocks;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

public class ModItems {
	//items
	public static final Item recordPigStep = ItemHelper.createItem(BackPort.MOD_ID, new ItemRecordAccessor(BackPort.MOD_ID, UtilIdRegistrar.nextIdItem(), "pig_step"), "record.pig_step", "disc_pig_step.png");



	//armor
//	public static final ArmorMaterial armorclothing = ArmorHelper.createArmorMaterial("clothes", 128, 10.0f, 0.0f, 0.0f, 10.0f);
//	public static final Item armorHelmetCloth = ItemHelper.createItem(BTBTA.MOD_ID, new ItemArmor("Cloth Hood", UtilIdRegistrar.nextIdItem(), armorclothing, 0), "armor.helmet.clothes", "cloth_hood.png").withTags(ModItemTags.hideName);
//	public static final Item armorChestplateCloth = ItemHelper.createItem(BTBTA.MOD_ID, new ItemArmor("Cloth Shirt", UtilIdRegistrar.nextIdItem(), armorclothing, 1), "armor.chestplate.clothes", "cloth_shirt.png");
//	public static final Item armorLeggingsCloth = ItemHelper.createItem(BTBTA.MOD_ID, new ItemArmor("Cloth Pants", UtilIdRegistrar.nextIdItem(), armorclothing, 2), "armor.leggings.clothes", "cloth_pants.png");
//	public static final Item armorBootsCloth = ItemHelper.createItem(BTBTA.MOD_ID, new ItemArmor("Shoes", UtilIdRegistrar.nextIdItem(), armorclothing, 3), "armor.boots.clothes", "cloth_boots.png");
//
//	public static final Item recordPancake = ItemHelper.createItem(BTBTA.MOD_ID, new ItemRecordAccessor(BTBTA.MOD_ID, UtilIdRegistrar.nextIdItem(), "so long"), "record.pancake", "disccake.png").setNotInCreativeMenu();
//	public static final Item recordSahara = ItemHelper.createItem(BTBTA.MOD_ID, new ItemRecordAccessor(BTBTA.MOD_ID, UtilIdRegistrar.nextIdItem(), "sahara"), "record.sahara", "disc_sahara.png");
//	public static final Item crackedCorn = ItemHelper.createItem(BTBTA.MOD_ID, new ItemFood(BTBTA.MOD_ID, UtilIdRegistrar.nextIdItem(),1,false), "corn.cracked", "cracked_corn.png");
//	public static final Item pumpkinPie = ItemHelper.createItem(BTBTA.MOD_ID, new ItemPlaceable("pumpkin_pie",UtilIdRegistrar.nextIdItem(),ModBlocks.pumpkinPie),"pie.pumpkin","pumpkin_pie.png").setMaxStackSize(1);
//	public static final Item cherryPie = ItemHelper.createItem(BTBTA.MOD_ID, new ItemPlaceable("cherry_pie",UtilIdRegistrar.nextIdItem(),ModBlocks.cherryPie),"pie.cherry","cherry_pie.png").setMaxStackSize(1);

	//spawn eggs
//	public static Item penguinSpawnEgg = ItemHelper.createItem(BTBTA.MOD_ID, new Item("spawn.egg.penguin", UtilIdRegistrar.nextIdSpawnEggItem()), "spawn.egg.penguin", "unknown.png");

	public static void register() {
	}
}
