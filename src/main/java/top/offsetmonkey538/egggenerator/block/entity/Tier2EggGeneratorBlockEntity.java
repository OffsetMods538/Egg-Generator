package top.offsetmonkey538.egggenerator.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import top.offsetmonkey538.egggenerator.block.ModBlocks;

public class Tier2EggGeneratorBlockEntity extends AbstractEggGeneratorBlockEntity {

    public Tier2EggGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.TIER_2_EGG_GENERATOR_ENTITY, pos, state, 1.5f);
    }
}
