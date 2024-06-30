package com.github.mooziii.fastboats.mixin;

import com.github.mooziii.fastboats.FastBoats;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VehicleEntity.class)
public abstract class MixinVehicleEntity {
    @ModifyArg(method = "destroy(Lnet/minecraft/world/item/Item;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/VehicleEntity;spawnAtLocation(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemStack injected(ItemStack par1) {
        if ((Object) this instanceof Boat) {
            var level = FastBoats.WAVE_RIDER.get(this).value();
            //EnchantmentHelper.enchantItem(Enchantment) this is stupid mojang stuff again
        }
        return par1;
    }

}
