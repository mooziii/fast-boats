package com.github.mooziii.fastboats.mixin;

import com.github.mooziii.fastboats.FastBoats;
import com.github.mooziii.fastboats.enchantment.WaveRiderEnchantment;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VehicleEntity.class)
public abstract class MixinVehicleEntity {
    @ModifyArg(method = "destroy(Lnet/minecraft/world/item/Item;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/VehicleEntity;spawnAtLocation(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemStack injected(ItemStack par1) {
        if ((Object) this instanceof Boat) {
            var level = FastBoats.WAVE_RIDER.get(this).value();
            par1.enchant(WaveRiderEnchantment.INSTANCE, level);
        }
        return par1;
    }

}
