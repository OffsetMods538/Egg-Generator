package top.offsetmonkey538.egggenerator;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.RotationAxis;
import top.offsetmonkey538.egggenerator.block.entity.AbstractEggGeneratorBlockEntity;

public class EggGeneratorBlockEntityRenderer implements BlockEntityRenderer<AbstractEggGeneratorBlockEntity> {
    private final EntityRenderDispatcher entityRenderDispatcher;
    private ChickenEntity chicken;

    public EggGeneratorBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.entityRenderDispatcher = context.getEntityRenderDispatcher();
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public void render(AbstractEggGeneratorBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (this.chicken == null) {
            this.chicken = EntityType.CHICKEN.create(entity.getWorld());
            this.chicken.setAiDisabled(true);
        }
        matrices.push();

        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.translate(0.75f, 0.63f, 1f);
        matrices.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(entity.getCachedState().get(Properties.HORIZONTAL_FACING).asRotation()));

        this.entityRenderDispatcher.render(chicken, 0, 0, 0, 0, 0, matrices, vertexConsumers, light);

        matrices.pop();
    }
}
