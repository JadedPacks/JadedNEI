package com.jadedpacks.jadednei;

import cpw.mods.fml.common.registry.GameRegistry;
import minetweaker.MineTweakerAPI;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;

@ZenClass("mods.jadedpacks.NEITweaker")
public class NEITweaker {
	@ZenMethod
	public static void hideAE2Facades() {
		ItemStack i = getStack("appliedenergistics2:item.ItemFacade"), is = i;
		final NBTTagCompound data = new NBTTagCompound();
		data.setIntArray("x", new int[]{1, 0});
		data.setString("modid", "minecraft");
		data.setString("itemname", "stone");
		is.setTagCompound(data);
		MineTweakerAPI.apply(new NEISetEntriesAction(i, Arrays.asList(is)));
	}

	@ZenMethod
	public static void hideExUDrums() {
		MineTweakerAPI.apply(new NEISetEntriesAction(getStack("ExtraUtilities:drum"), new int[]{0,1}));
	}

	@ZenMethod
	public static void hideExUMicroblocks() {
		ItemStack i = getStack("ExtraUtilities:microblocks");
		ArrayList<ItemStack> stacks = new ArrayList<>();
		for(ItemStack s : buildStack(i, new int[]{1, 2, 3})) {
			try {
				stacks.add((ItemStack) i.getItem().getClass().getDeclaredMethod("getStack", new Class[] {
					ItemStack.class, String.class
				}).invoke(null, new Object[]{s, "minecraft:stone"}));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		MineTweakerAPI.apply(new NEISetEntriesAction(i, stacks));
	}

	@ZenMethod
	public static void hideForgeMicroblocks() {
		ItemStack i = getStack("ForgeMicroblock:microblock");
		ArrayList<ItemStack> stacks = new ArrayList<>();
		for(ItemStack s : buildStack(i, new int[]{1, 2, 4, 257, 258, 260, 513, 514, 516, 769, 770, 772})) {
			try {
				stacks.add((ItemStack) i.getItem().getClass().getDeclaredMethod("create", new Class[] {
					int.class, String.class
				}).invoke(null, new Object[]{s.getMetadata(), "minecraft:stone"}));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		MineTweakerAPI.apply(new NEISetEntriesAction(i, stacks));
	}

	@ZenMethod
	public static void hideTEFlorbs() {
		MineTweakerAPI.apply(new NEISetEntriesAction(getStack("ThermalExpansion:florb"), new int[]{0,1}));
	}

	private static ItemStack getStack(String itemstring) {
		String[] spl = itemstring.split(":");
		String mod = spl[0], item = spl[1];
		Item i = GameRegistry.findItem(mod, item);
		if(i != null) {
			return new ItemStack(i, 1, 0);
		}
		Block b = GameRegistry.findBlock(mod, item);
		if(b != null) {
			return new ItemStack(b, 1, 0);
		}
		return null;
	}

	private static ArrayList<ItemStack> buildStack(ItemStack item, int[] metas) {
		ArrayList<ItemStack> stacks = new ArrayList<>();
		for(int i : metas) {
			stacks.add(new ItemStack(item.getItem(), 1, i));
		}
		return stacks;
	}
}