package top.offsetmonkey538.egggenerator;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static top.offsetmonkey538.egggenerator.ModBlocks.*;

public class EggGenerator implements ModInitializer {

	public static final String MOD_ID = "egg-generator";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> {
			content.addAfter(Items.BLAST_FURNACE,           TIER_1_EGG_GENERATOR.asItem());
			content.addAfter(TIER_1_EGG_GENERATOR.asItem(), TIER_2_EGG_GENERATOR.asItem());
			content.addAfter(TIER_2_EGG_GENERATOR.asItem(), TIER_3_EGG_GENERATOR.asItem());
			content.addAfter(TIER_3_EGG_GENERATOR.asItem(), TIER_4_EGG_GENERATOR.asItem());
		});
	}
}