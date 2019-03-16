package com.jadedpacks.jadednei.values;

import com.jadedpacks.jadednei.function.*;
import stanhebben.minetweaker.api.TweakerExecuteException;
import stanhebben.minetweaker.api.value.TweakerValue;

public class NEIValue extends TweakerValue {
	public static final NEIValue INSTANCE;

	@Override
	public TweakerValue index(final String index) {
		if(index.equals("hide")) {
			return NEIHideFunction.INSTANCE;
		}
		if(index.equals("show")) {
			return NEIShowFunction.INSTANCE;
		}
		throw new TweakerExecuteException("No such member in NEIValue: " + index);
	}

	@Override
	public String toString() {
		return "nei";
	}

	static {
		INSTANCE = new NEIValue();
	}
}