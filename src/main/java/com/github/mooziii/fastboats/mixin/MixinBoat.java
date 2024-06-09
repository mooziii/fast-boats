package com.github.mooziii.fastboats.mixin;

import com.github.mooziii.fastboats.FastBoats;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Boat.class)
public class MixinBoat {

    @ModifyArgs(method = "floatBoat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/Boat;setDeltaMovement(DDD)V", ordinal = 0))
    private void injected(Args args) {
        var level = FastBoats.WAVE_RIDER.get((MixinBoat) (Object) this).value();
        if (level > 0) {
            args.set(0, (double) args.get(0)*1.07);
            args.set(2, (double) args.get(2)*1.07);
        }
    }
}
