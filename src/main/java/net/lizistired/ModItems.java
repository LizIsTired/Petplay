package net.lizistired;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item COLLAR = registerItem(Identifier.of(Petplay.MOD_ID,"collar"), Item::new, new Item.Settings());

    public static final RegistryKey<ItemGroup> PETPLAY_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Petplay.MOD_ID, "item_group"));

    public static final ItemGroup PETPLAY_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.COLLAR))
            .displayName(Text.translatable("itemGroup.petPlay"))
            .build();



    public static <T extends Item> T registerItem(Identifier identifier, Function<Item.Settings, T> factory, Item.Settings settings) {
        return Registry.register(
                Registries.ITEM,
                identifier,
                factory.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, identifier)))
        );
    }

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, PETPLAY_ITEM_GROUP_KEY, PETPLAY_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(PETPLAY_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.COLLAR);
        });
    }
}

