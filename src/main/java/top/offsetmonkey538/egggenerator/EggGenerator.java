package top.offsetmonkey538.egggenerator;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EggGenerator implements ModInitializer {

	public static final String MOD_ID = "egg-generator";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
	}
}