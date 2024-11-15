package net.lizistired;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Leashable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.LeashKnotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

public class Collar extends Item {
    public Collar(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(BlockTags.FENCES)) {
            PlayerEntity playerEntity = context.getPlayer();
            if (!world.isClient && playerEntity != null) {
                return attachHeldMobsToBlock(playerEntity, world, blockPos);
            }
        }

        return ActionResult.PASS;
    }

    public static ActionResult attachHeldMobsToBlock(PlayerEntity player, World world, BlockPos pos) {
        LeashKnotEntity leashKnotEntity = null;
        List<Leashable> list = collectLeashablesAround(world, pos, entity -> entity.getLeashHolder() == player);

        for (Leashable leashable : list) {
            if (leashKnotEntity == null) {
                leashKnotEntity = LeashKnotEntity.getOrCreate(world, pos);
                leashKnotEntity.onPlace();
            }

            leashable.attachLeash(leashKnotEntity, true);
        }

        if (!list.isEmpty()) {
            world.emitGameEvent(GameEvent.BLOCK_ATTACH, pos, GameEvent.Emitter.of(player));
            return ActionResult.SUCCESS_SERVER;
        } else {
            return ActionResult.PASS;
        }
    }

    public static List<Leashable> collectLeashablesAround(World world, BlockPos pos, Predicate<Leashable> predicate) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        Box box = new Box((double)i - 7.0, (double)j - 7.0, (double)k - 7.0, (double)i + 7.0, (double)j + 7.0, (double)k + 7.0);
        return world.getEntitiesByClass(Entity.class, box, entity -> entity instanceof Leashable leashable && predicate.test(leashable)).stream().map(Leashable.class::cast).toList();
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        return ActionResult.CONSUME;
    }
}



