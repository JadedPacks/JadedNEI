package com.jadedpacks.jadednei;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import minetweaker.MineTweakerAPI;

@Mod(modid = "jadednei", name = "JadedNEI", version = "@VERSION@", dependencies = "required-after:MineTweaker3")
public class JadedNEI {
	@Mod.EventHandler
	public void preInit(final FMLInitializationEvent event) {
		if(Loader.isModLoaded("NotEnoughItems")) {
			MineTweakerAPI.registerClass(NEITweaker.class);
		}
	}
}