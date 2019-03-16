package com.jadedpacks.jadednei.function;

import com.jadedpacks.jadednei.actions.NEIShowAction;
import stanhebben.minetweaker.api.Tweaker;
import stanhebben.minetweaker.api.TweakerExecuteException;
import stanhebben.minetweaker.api.TweakerNameSpace;
import stanhebben.minetweaker.api.value.TweakerFunction;
import stanhebben.minetweaker.api.value.TweakerItemStack;
import stanhebben.minetweaker.api.value.TweakerValue;

public class NEIShowFunction extends TweakerFunction {
	public static final NEIShowFunction INSTANCE;

	public TweakerValue call(final TweakerNameSpace namespace, final TweakerValue... arguments) {
		if(arguments.length != 1) {
			throw new TweakerExecuteException("NEI.show requires 1 arguments.");
		}
		final TweakerItemStack item = TweakerValue.notNull(arguments[0], "name cannot be null").toItemStack("name must be an item");
		Tweaker.apply(new NEIShowAction(item));
		return null;
	}

	public String toString() {
		return "NEI.show";
	}

	static {
		INSTANCE = new NEIShowFunction();
	}
}