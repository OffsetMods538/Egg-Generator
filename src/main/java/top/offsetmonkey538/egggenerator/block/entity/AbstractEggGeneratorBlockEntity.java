package top.offsetmonkey538.egggenerator.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.item.Items.EGG;

public abstract class AbstractEggGeneratorBlockEntity extends BlockEntity implements SidedInventory {
    private SimpleInventory inventory;
    private int generationTime;
    private int generationTimeLeft;

    public AbstractEggGeneratorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, float generationTimeSeconds) {
        super(type, pos, state);
        this.generationTime = (int) (generationTimeSeconds * 20);
        this.generationTimeLeft = this.generationTime;
        this.inventory = new SimpleInventory(1);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("GenerationTime", generationTime);
        nbt.putInt("GenerationTimeLeft", generationTimeLeft);
        nbt.put("Items", inventory.toNbtList());
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        this.generationTime = nbt.getInt("GenerationTime");
        this.generationTimeLeft = nbt.getInt("GenerationTimeLeft");
        this.inventory = new SimpleInventory(1);
        this.inventory.readNbtList(nbt.getList("Items", NbtElement.COMPOUND_TYPE));
    }

    public static void tick(World world, BlockPos pos, BlockState state, AbstractEggGeneratorBlockEntity entity) {
        if (entity.generationTimeLeft > 0) {
            entity.generationTimeLeft--;
            return;
        }

        entity.generationTimeLeft = entity.generationTime;

        ItemStack stack = entity.getStack(0);
        if (stack.getItem() != EGG) stack = new ItemStack(EGG, 0);
        stack.increment(1);
        entity.setStack(0, stack);
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) return new int[]{0};
        return new int[]{};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public int size() {
        return this.inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return this.getStack(0).isEmpty();
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.inventory.getStack(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        return this.inventory.removeStack(slot, amount);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return this.inventory.removeStack(slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        this.inventory.setStack(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (world == null) return false;
        if (this.world.getBlockEntity(this.pos) != this) return false;
        return player.squaredDistanceTo(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }
}
