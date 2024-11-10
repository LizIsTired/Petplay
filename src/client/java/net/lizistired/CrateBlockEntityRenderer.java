package net.lizistired;

import net.minecraft.client.model.Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.state.BoatEntityRenderState;
import net.minecraft.client.render.entity.state.MinecartEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrateBlockEntityRenderer extends EntityRenderer<CrateBlockEntity, CrateBlockEntityRenderState> {
    private final Identifier texture;
    private final EntityModel<CrateBlockEntityRenderState> model;
    @Override
    public CrateBlockEntityRenderState createRenderState() {
        return new CrateBlockEntityRenderState();
    }

    public CrateBlockEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer) {
        super(ctx);
        this.texture = layer.id().withPath((path) -> "textures/entity/crate_block_entity.png");
        this.model = new CrateBlockEntityModel(ctx.getPart(layer));
    }


    @Override
    public void render(CrateBlockEntityRenderState crateBlockEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(crateBlockEntityRenderState, matrixStack, vertexConsumerProvider, i);
        matrixStack.push();
        EntityModel<CrateBlockEntityRenderState> entityModel = this.getModel();
        matrixStack.translate(0,-0.75f,0);
        entityModel.setAngles(crateBlockEntityRenderState);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutout(this.texture));
        //this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
    }

    protected EntityModel<CrateBlockEntityRenderState> getModel() {
        return this.model;
    }

    protected RenderLayer getRenderLayer() {
        return this.model.getLayer(this.texture);
    }
}