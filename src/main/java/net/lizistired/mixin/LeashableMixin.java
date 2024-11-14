package net.lizistired.mixin;

import net.lizistired.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Leashable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Leashable.class)
public class LeashableMixin {

    @Inject(method = "detachLeash(Lnet/minecraft/entity/Entity;ZZ)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;dropItem(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/item/ItemConvertible;)Lnet/minecraft/entity/ItemEntity;"))
    private static <E extends Entity & Leashable> void detachLeash(E entity, boolean sendPacket, boolean dropItem, CallbackInfo cir) {
    }
}
