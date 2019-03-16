package com.jadedpacks.jadednei.actions;

import codechicken.nei.api.API;
import stanhebben.minetweaker.api.IUndoableAction;
import stanhebben.minetweaker.api.value.TweakerItemStack;

public class NEIShowAction implements IUndoableAction {
	private final TweakerItemStack item;

	public NEIShowAction(final TweakerItemStack item) {
		this.item = item;
	}

	@Override
	public void apply() {
		API.addNBTItem(item.get());
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		API.hideItem(item.get().itemID);
	}

	@Override
	public String describe() {
		return "Showing " + item.getDisplayName() + " as NEI entry.";
	}

	@Override
	public String describeUndo() {
		return "Hiding " + item.getDisplayName() + " as NEI entry.";
	}
}