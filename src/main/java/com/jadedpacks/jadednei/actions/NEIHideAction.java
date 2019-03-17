package com.jadedpacks.jadednei.actions;

import codechicken.nei.api.API;
import codechicken.nei.api.ItemInfo;
import net.minecraft.item.ItemStack;
import stanhebben.minetweaker.api.IUndoableAction;
import stanhebben.minetweaker.api.value.TweakerItem;
import stanhebben.minetweaker.api.value.TweakerItemStackPattern;

public class NEIHideAction implements IUndoableAction {
	private final TweakerItemStackPattern item;

	public NEIHideAction(final TweakerItemStackPattern item) {
		this.item = item;
	}

	@Override
	public void apply() {
		for(TweakerItem itemz : item.getMatches()) {
			ItemStack item = itemz.make();
			API.hideItem(item.itemID);
			if(item.getItemDamage() > 0 && !ItemInfo.itemcompounds.containsKey(item.itemID)) {
				ItemStack item2 = item.copy();
				item2.setItemDamage(0);
				API.addNBTItem(item2);
			}
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public void undo() {
		for(TweakerItem item : item.getMatches()) {
			if(!ItemInfo.excludeIds.contains(item.make().itemID)) {
				API.addNBTItem(item.make());
			}
			ItemInfo.excludeIds.remove(item.make().itemID);
		}
	}

	@Override
	public String describe() {
		return "Hiding " + item.toPatternString() + " as NEI entry.";
	}

	@Override
	public String describeUndo() {
		return "Showing " + item.toPatternString() + " as NEI entry.";
	}
}