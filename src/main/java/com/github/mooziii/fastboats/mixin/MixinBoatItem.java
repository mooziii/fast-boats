package com.github.mooziii.fastboats.mixin;

import com.github.mooziii.fastboats.FastBoats;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatItem.class)
public class MixinBoatItem {

    @Inject(method = "getBoat", at = @At("RETURN"), cancellable = true)
    private void injected(Level level, HitResult hitResult, ItemStack stack, Player player, CallbackInfoReturnable<Boat> cir) {
        var enchantmentLevel = stack.getEnchantments().getLevel(); // stupid mojang stuff idk
        if (enchantmentLevel < 1) {
            return;
        }
        var boat = cir.getReturnValue();
        FastBoats.WAVE_RIDER.get(boat).setValue(enchantmentLevel);
        cir.setReturnValue(boat);
    }
}
