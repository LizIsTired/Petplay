package net.lizistired;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.minecraft.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Petplay implements ModInitializer {
	public static final String MOD_ID = "petplay";


	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockEntities.initialize();
	}
}