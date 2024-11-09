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
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.function.Function;

public class ModBlocks {
    public static final Block CRATE = registerBlockWithItem(Identifier.of(Petplay.MOD_ID,"crate"), Block::new, AbstractBlock.Settings.create().nonOpaque()).getLeft();

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
        });
    }

}
