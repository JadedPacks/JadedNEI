package com.jadedpacks.jadednei;

import codechicken.nei.api.API;
import minetweaker.IUndoableAction;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;

public class NEISetEntriesAction implements IUndoableAction {
	private final ItemStack item;
	private final Iterable<ItemStack> items;

	public NEISetEntriesAction(ItemStack item, ItemStack items) {
		this(item, Collections.singletonList(items));
	}

	public NEISetEntriesAction(ItemStack item, int[] metas) {
		this.item = item;
		this.items = buildStack(metas);
	}

	public NEISetEntriesAction(ItemStack item, Iterable<ItemStack> items) {
		this.item = item;
		this.items = items;
	}

	@Override
	public void apply() {
		if(item != null) {
			API.setItemListEntries(item.getItem(), items);
		}
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public void undo() {}

	@Override
	public String describe() {
		return "Hiding " + item.getUnlocalizedName() + " in NEI";
	}

	@Override
	public String describeUndo() {
		return "";
	}

	@Override
	public Object getOverrideKey() {
		return null;
	}

	private ArrayList<ItemStack> buildStack(int[] metas) {
		ArrayList<ItemStack> stacks = new ArrayList<>();
		for(int i : metas) {
			stacks.add(new ItemStack(item.getItem(), 1, i));
		}
		return stacks;
	}
}