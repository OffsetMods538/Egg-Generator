package top.offsetmonkey538.egggenerator.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import top.offsetmonkey538.egggenerator.block.entity.AbstractEggGeneratorBlockEntity;

public abstract class AbstractEggGeneratorBlock extends BlockWithEntity {

    public AbstractEggGeneratorBlock(Settings settings) {
        super(settings.nonOpaque());
    }

    @Override
    public abstract BlockEntity createBlockEntity(BlockPos pos, BlockState state);

    protected <T extends BlockEntity> BlockEntityTicker<T> checkType(BlockEntityType<T> givenType, BlockEntityType<? extends AbstractEggGeneratorBlockEntity> expectedType) {
        return checkType(givenType, expectedType, AbstractEggGeneratorBlockEntity::tick);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
