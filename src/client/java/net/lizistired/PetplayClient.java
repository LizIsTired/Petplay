package net.lizistired;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class PetplayClient implements ClientModInitializer {
	public static final EntityModelLayer CRATE_BLOCK_ENTITY_MODEL_LAYER = new EntityModelLayer(Identifier.of(Petplay.MOD_ID, "crate_block_entity_model_layer"), "main");
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRATE, RenderLayer.getTranslucent());

		EntityRendererRegistry.register(ModBlockEntities.CRATE_BLOCK_ENTITY, (context) -> new CrateBlockEntityRenderer(context, CRATE_BLOCK_ENTITY_MODEL_LAYER));

		EntityModelLayerRegistry.registerModelLayer(CRATE_BLOCK_ENTITY_MODEL_LAYER, CrateBlockEntityModel::getTexturedModelData);

		//EntityModelLayerRegistry.registerModelLayer(CRATE_BLOCK_ENTITY_MODEL_LAYER, CrateBlockEntityModel::new);

	}
}