package net.lizistired;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.RideableInventory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CrateBlockEntity extends VehicleEntity {
    private float field_52518;
    private float field_52519;

    public CrateBlockEntity(EntityType<?> entityType, World world) {
        super(ModBlockEntities.CRATE_BLOCK_ENTITY, world);
    }

    @Override
    protected Item asItem() {
        return null;
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        ActionResult actionResult = super.interact(player, hand);
            player.startRiding(this, true);
            actionResult = ActionResult.CONSUME;
            return actionResult;
    }

    @Override
    public boolean canHit(){
        super.canHit();
        return true;
    }

    //@Override
    //public void onPlayerCollision(PlayerEntity player) {
      //  player.startRiding(this, true);
    //}


    @Override
    protected void updatePassengerPosition(Entity passenger, Entity.PositionUpdater positionUpdater) {
        super.updatePassengerPosition(passenger, positionUpdater);
        if (this.getWorld().isClient && passenger instanceof PlayerEntity playerEntity) {
                float f = (float) MathHelper.lerpAngleDegrees(0.5, (double)this.field_52519, (double)this.field_52518);
                playerEntity.setYaw(playerEntity.getYaw() - (f - this.field_52519));
                this.field_52519 = f;
        }

    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }
}
