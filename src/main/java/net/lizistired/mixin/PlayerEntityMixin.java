package net.lizistired.mixin;

import net.lizistired.LeashImpl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Leashable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "interact(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;", at = @At("RETURN"), cancellable = true)
    private void leashplayers$onInteract(Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> info) {
        if (info.getReturnValue() != ActionResult.PASS) return;
        if ((Object) this instanceof ServerPlayerEntity player && entity instanceof LeashImpl impl) {
            info.setReturnValue(impl.leashplayers$interact(player, hand));
            info.cancel();
        }
    }

}
