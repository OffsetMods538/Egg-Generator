package top.offsetmonkey538.egggenerator.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import top.offsetmonkey538.egggenerator.ModBlocks;

public class Tier1EggGeneratorBlockEntity extends AbstractEggGeneratorBlockEntity {

    public Tier1EggGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.TIER_1_EGG_GENERATOR_ENTITY, pos, state, 2);
    }
}
