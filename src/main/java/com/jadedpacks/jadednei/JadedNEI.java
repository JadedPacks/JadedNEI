package com.jadedpacks.jadednei;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import stanhebben.minetweaker.api.Tweaker;

@Mod(modid = "jadednei", name = "JadedNEI", version = "@VERSION@", dependencies = "required-after:MineTweaker")
public class JadedNEI {
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		if(Loader.isModLoaded("NotEnoughItems")) {
			Tweaker.registerModInterface(NEI.INSTANCE);
		}
	}
}