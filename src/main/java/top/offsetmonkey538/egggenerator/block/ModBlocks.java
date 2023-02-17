package top.offsetmonkey538.egggenerator.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import top.offsetmonkey538.egggenerator.block.entity.AbstractEggGeneratorBlockEntity;
import top.offsetmonkey538.egggenerator.block.entity.Tier1EggGeneratorBlockEntity;

import static top.offsetmonkey538.egggenerator.EggGenerator.MOD_ID;

public class ModBlocks {

    public static final AbstractEggGeneratorBlock TIER_1_EGG_GENERATOR = registerWithItem("tier_1_egg_generator", new Tier1EggGeneratorBlock());

    public static final BlockEntityType<AbstractEggGeneratorBlockEntity> TIER_1_EGG_GENERATOR_ENTITY = register("tier_1_egg_generator_entity", Tier1EggGeneratorBlockEntity::new, TIER_1_EGG_GENERATOR);

    private static <T extends Block> T registerWithItem(String name, T block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
        return register(name, block);
    }

    private static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }


    private static <T extends BlockEntity, B extends Block> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<T> blockEntity, B block) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, name), FabricBlockEntityTypeBuilder.create(blockEntity, block).build());
    }

    public static void initialize() {
        // Initializes the blocks by loading this class, and it's constants
    }
}
