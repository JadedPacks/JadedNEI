package com.jadedpacks.jadednei.actions;

import codechicken.nei.api.API;
import codechicken.nei.api.ItemInfo;
import stanhebben.minetweaker.api.IUndoableAction;
import stanhebben.minetweaker.api.value.TweakerItem;
import stanhebben.minetweaker.api.value.TweakerItemStackPattern;

public class NEIShowAction implements IUndoableAction {
	private final TweakerItemStackPattern item;

	public NEIShowAction(final TweakerItemStackPattern item) {
		this.item = item;
	}

	@Override
	public void apply() {
		for(TweakerItem item : item.getMatches()) {
			if(!ItemInfo.excludeIds.contains(item.make().itemID)) {
				API.addNBTItem(item.make());
			}
			ItemInfo.excludeIds.remove(item.make().itemID);
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		for(TweakerItem item : item.getMatches()) {
			API.hideItem(item.make().itemID);
		}
	}

	@Override
	public String describe() {
		return "Showing " + item.toPatternString() + " as NEI entry.";
	}

	@Override
	public String describeUndo() {
		return "Hiding " + item.toPatternString() + " as NEI entry.";
	}
}