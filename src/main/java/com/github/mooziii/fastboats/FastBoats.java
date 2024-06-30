package com.github.mooziii.fastboats;

import com.github.mooziii.fastboats.components.SyncedIntComponent;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public class FastBoats implements ModInitializer, EntityComponentInitializer {

    private static final ResourceLocation ENCHANTMENT_LOCATION = ResourceLocation.fromNamespaceAndPath("fastboats", "wave_rider");

    public static final ComponentKey<SyncedIntComponent> WAVE_RIDER =
            ComponentRegistry.getOrCreate(ENCHANTMENT_LOCATION, SyncedIntComponent.class);

    @Override
    public void onInitialize() {
        //Registry.register(BuiltInRegistries.ENCHANTMENT, ENCHANTMENT_LOCATION, WaveRiderEnchantment.INSTANCE);
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(Boat.class, WAVE_RIDER, SyncedIntComponent::new);
    }
}
