package top.offsetmonkey538.egggenerator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import static top.offsetmonkey538.egggenerator.ModBlocks.*;

public class EggGeneratorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_1_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_2_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_3_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_4_EGG_GENERATOR, RenderLayer.getCutout());


		ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
			if (world == null || pos == null) return GrassColors.getColor(0.5, 1.0);
			return BiomeColors.getGrassColor(world, pos);
		}), TIER_1_EGG_GENERATOR, TIER_2_EGG_GENERATOR, TIER_3_EGG_GENERATOR, TIER_4_EGG_GENERATOR);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5, 1.0),
				TIER_1_EGG_GENERATOR.asItem(), TIER_2_EGG_GENERATOR.asItem(), TIER_3_EGG_GENERATOR.asItem(), TIER_4_EGG_GENERATOR.asItem()
		);


		BlockEntityRendererFactories.register(TIER_1_EGG_GENERATOR_ENTITY, EggGeneratorBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(TIER_2_EGG_GENERATOR_ENTITY, EggGeneratorBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(TIER_3_EGG_GENERATOR_ENTITY, EggGeneratorBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(TIER_4_EGG_GENERATOR_ENTITY, EggGeneratorBlockEntityRenderer::new);
	}
}