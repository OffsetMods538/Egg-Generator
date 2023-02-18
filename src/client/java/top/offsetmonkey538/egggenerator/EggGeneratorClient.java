package top.offsetmonkey538.egggenerator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static top.offsetmonkey538.egggenerator.ModBlocks.*;

public class EggGeneratorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_1_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_2_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_3_EGG_GENERATOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TIER_4_EGG_GENERATOR, RenderLayer.getCutout());
	}
}