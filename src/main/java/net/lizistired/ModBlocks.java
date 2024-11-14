package net.lizistired;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.function.Function;

public class ModBlocks {
    public static final Crate CRATE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate"), settings -> new Crate(DyeColor.BLACK, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_WHITE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_white"), settings -> new Crate(DyeColor.WHITE, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_BLACK = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_black"), settings -> new Crate(DyeColor.BLACK, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_BLUE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_blue"), settings -> new Crate(DyeColor.BLUE, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_RED = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_red"), settings -> new Crate(DyeColor.RED, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_PINK = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_pink"), settings -> new Crate(DyeColor.PINK, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_PURPLE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_purple"), settings -> new Crate(DyeColor.PURPLE, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_ORANGE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_orange"), settings -> new Crate(DyeColor.ORANGE, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();
    public static final Crate CRATE_GREEN = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate_green"), settings -> new Crate(DyeColor.GREEN, settings), AbstractBlock.Settings.create().nonOpaque()).getLeft();

    public static <T extends Block> T registerBlock(Identifier identifier, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        return Registry.register(
                Registries.BLOCK,
                identifier,
                factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, identifier)))
        );
    }
    public static <T extends Block> Pair<T, BlockItem> registerBlockWithItem(Identifier identifier, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings) {
        T block = registerBlock(identifier, factory, settings);

        return new Pair<>(block, ModItems.registerItem(identifier, (itemSettings) -> new BlockItem(block, itemSettings), new Item.Settings()));
    }



    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.PETPLAY_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CRATE.asItem());
            itemGroup.add(ModBlocks.CRATE_WHITE.asItem());
            itemGroup.add(ModBlocks.CRATE_BLACK.asItem());
            itemGroup.add(ModBlocks.CRATE_BLUE.asItem());
            itemGroup.add(ModBlocks.CRATE_RED.asItem());
            itemGroup.add(ModBlocks.CRATE_PINK.asItem());
            itemGroup.add(ModBlocks.CRATE_GREEN.asItem());
            itemGroup.add(ModBlocks.CRATE_ORANGE.asItem());
            itemGroup.add(ModBlocks.CRATE_PURPLE.asItem());
        });
    }

}
