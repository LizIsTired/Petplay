package net.lizistired;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final EntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Petplay.MOD_ID, "crate_block_entity"),
            EntityType.Builder.create(CrateBlockEntity::new, SpawnGroup.MISC).dimensions(1.1f, 1.1f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Petplay.MOD_ID, "crate_block_entity")))
    );


    public static void initialize() {
    }
}
