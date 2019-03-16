package com.jadedpacks.jadednei.actions;

import codechicken.nei.api.API;
import stanhebben.minetweaker.api.IUndoableAction;
import stanhebben.minetweaker.api.value.TweakerItemStack;

public class NEIHideAction implements IUndoableAction {
	private final TweakerItemStack item;

	public NEIHideAction(final TweakerItemStack item) {
		this.item = item;
	}

	@Override
	public void apply() {
		API.hideItem(item.get().itemID);
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		API.addNBTItem(item.get());
	}

	@Override
	public String describe() {
		return "Hiding " + item.getDisplayName() + " as NEI entry.";
	}

	@Override
	public String describeUndo() {
		return "Showing " + item.getDisplayName() + " as NEI entry.";
	}
}