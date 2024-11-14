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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class LeashMixin {

    @Inject(method = "interact", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;"))
    public void interact(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (((Entity) (Object) this).isAlive() && this instanceof Leashable leashable) {
            ItemStack itemStack1 = player.getStackInHand(hand);
            if (itemStack1.isOf(ModItems.COLLAR)) {
                leashable.attachLeash(player, true);

            }
            //itemStack1.decrement(1);
        }
    }
}
