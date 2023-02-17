package top.offsetmonkey538.egggenerator.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import top.offsetmonkey538.egggenerator.ModBlocks;
import top.offsetmonkey538.egggenerator.block.entity.Tier3EggGeneratorBlockEntity;

public class Tier3EggGeneratorBlock extends AbstractEggGeneratorBlock {

    public Tier3EggGeneratorBlock() {
        super(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK));
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlocks.TIER_3_EGG_GENERATOR_ENTITY);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Tier3EggGeneratorBlockEntity(pos, state);
    }
}
