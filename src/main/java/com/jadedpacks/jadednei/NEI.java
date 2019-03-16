package com.jadedpacks.jadednei;

import com.jadedpacks.jadednei.values.NEIValue;
import stanhebben.minetweaker.api.MineTweakerInterface;

class NEI extends MineTweakerInterface {
	static final NEI INSTANCE;

	private NEI() {
		super("NEI", NEIValue.INSTANCE);
	}

	static {
		INSTANCE = new NEI();
	}
}