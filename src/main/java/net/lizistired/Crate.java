package net.lizistired;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Crate extends Block implements Stainable{
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");
    private static Entity crateBlockEntity;
    private static final VoxelShape RAYCAST_SHAPE = createCuboidShape(0.0, 0.0, 0.0, 32.0, 80.0, 32.0);
    protected static final VoxelShape OUTLINE_SHAPE_CLOSED = voxelShapeCrate.makeShapeClosed();
    protected static final VoxelShape OUTLINE_SHAPE_OPEN = voxelShapeCrate.makeShapeOpen();
    public static final MapCodec<Crate> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(DyeColor.CODEC.fieldOf("color").forGetter(Crate::getColor), createSettingsCodec())
                    .apply(instance, Crate::new)
    );
    private final DyeColor color;

    public Crate(DyeColor color, Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(ACTIVATED, false)
                .with(Properties.FACING, Direction.NORTH));
        this.color = color;
    }

    @Override
    public MapCodec<Crate> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
        builder.add(Properties.FACING);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            // Skip if the player isn't allowed to modify the world.
            return ActionResult.PASS;
        } else {
            // Get the current value of the "activated" property
            boolean activated = state.get(ACTIVATED);

            // Flip the value of activated and save the new blockstate.
            world.setBlockState(pos, state.with(ACTIVATED, !activated));

            // Play a click sound to emphasise the interaction.
            world.playSound(player, pos, SoundEvents.BLOCK_CHEST_LOCKED, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        CrateBlockEntity crate = new CrateBlockEntity(ModBlockEntities.CRATE_BLOCK_ENTITY,world);
        world.spawnEntity(crate);
        crateBlockEntity = crate;
        crate.requestTeleport(pos.getX() + 0.5f, pos.getY() - 0.95f, pos.getZ() + 0.5f);

    }
    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        try {
            crateBlockEntity.discard();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return state;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(state.get(ACTIVATED)) {
            return OUTLINE_SHAPE_CLOSED;
        }
        return OUTLINE_SHAPE_OPEN;
    }

    @Override
    protected VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return RAYCAST_SHAPE;
    }


    @Override
    public DyeColor getColor() {
        return color;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(Properties.FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
