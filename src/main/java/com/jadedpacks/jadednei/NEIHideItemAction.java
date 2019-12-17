package com.jadedpacks.jadednei;

import codechicken.nei.api.API;
import minetweaker.IUndoableAction;
import net.minecraft.item.ItemStack;

public class NEIHideItemAction implements IUndoableAction {
	private final ItemStack stack;

	public NEIHideItemAction(ItemStack stack) {
		this.stack = stack;
	}

	public void apply() {
		API.hideItem(stack);
	}

	public boolean canUndo() {
		return true;
	}

	public void undo() {
		API.addItemListEntry(stack);
	}

	public String describe() {
		return "Hiding " + stack.getUnlocalizedName() + " in NEI";
	}

	public String describeUndo() {
		return "Displaying " + stack.getUnlocalizedName() + " in NEI";
	}

	public Object getOverrideKey() {
		return null;
	}
}