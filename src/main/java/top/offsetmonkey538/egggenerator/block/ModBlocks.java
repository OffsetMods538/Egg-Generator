package top.offsetmonkey538.egggenerator.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static top.offsetmonkey538.egggenerator.EggGenerator.MOD_ID;

public class ModBlocks {

    public static final EggGeneratorBlock EGG_GENERATOR = registerWithItem("egg_generator", new EggGeneratorBlock(FabricBlockSettings.copyOf(Blocks.HAY_BLOCK)));

    private static <T extends Block> T registerWithItem(String name, T block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        return register(name, block);
    }

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static void initialize() {
        // Initializes the blocks by loading this class, and it's constants
    }
}
