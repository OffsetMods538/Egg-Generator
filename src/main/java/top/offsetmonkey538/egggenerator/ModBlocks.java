package top.offsetmonkey538.egggenerator;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import top.offsetmonkey538.egggenerator.block.*;
import top.offsetmonkey538.egggenerator.block.entity.*;

import static top.offsetmonkey538.egggenerator.EggGenerator.MOD_ID;

public class ModBlocks {

    public static final AbstractEggGeneratorBlock TIER_1_EGG_GENERATOR = register("tier_1_egg_generator", new Tier1EggGeneratorBlock());
    public static final AbstractEggGeneratorBlock TIER_2_EGG_GENERATOR = register("tier_2_egg_generator", new Tier2EggGeneratorBlock());
    public static final AbstractEggGeneratorBlock TIER_3_EGG_GENERATOR = register("tier_3_egg_generator", new Tier3EggGeneratorBlock());
    public static final AbstractEggGeneratorBlock TIER_4_EGG_GENERATOR = register("tier_4_egg_generator", new Tier4EggGeneratorBlock());

    public static final BlockEntityType<Tier1EggGeneratorBlockEntity> TIER_1_EGG_GENERATOR_ENTITY = register("tier_1_egg_generator_entity", Tier1EggGeneratorBlockEntity::new, TIER_1_EGG_GENERATOR);
    public static final BlockEntityType<Tier2EggGeneratorBlockEntity> TIER_2_EGG_GENERATOR_ENTITY = register("tier_2_egg_generator_entity", Tier2EggGeneratorBlockEntity::new, TIER_2_EGG_GENERATOR);
    public static final BlockEntityType<Tier3EggGeneratorBlockEntity> TIER_3_EGG_GENERATOR_ENTITY = register("tier_3_egg_generator_entity", Tier3EggGeneratorBlockEntity::new, TIER_3_EGG_GENERATOR);
    public static final BlockEntityType<Tier4EggGeneratorBlockEntity> TIER_4_EGG_GENERATOR_ENTITY = register("tier_4_egg_generator_entity", Tier4EggGeneratorBlockEntity::new, TIER_4_EGG_GENERATOR);

    private static <T extends Block> T register(String name, T block) {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(ItemGroup.REDSTONE)));
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }


    private static <T extends BlockEntity, B extends Block> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<T> blockEntity, B block) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, name), FabricBlockEntityTypeBuilder.create(blockEntity, block).build());
    }

    public static void initialize() {
        // Initializes the blocks by loading this class, and it's constants
    }
}
