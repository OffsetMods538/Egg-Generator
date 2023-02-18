package top.offsetmonkey538.egggenerator.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import top.offsetmonkey538.egggenerator.ModBlocks;

public class Tier4EggGeneratorBlockEntity extends AbstractEggGeneratorBlockEntity {

    public Tier4EggGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.TIER_4_EGG_GENERATOR_ENTITY, pos, state, 0.5f);
    }
}
