package com.github.mooziii.fastboats.enchantment;


import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class WaveRiderEnchantment extends Enchantment {
    public static final WaveRiderEnchantment INSTANCE = new WaveRiderEnchantment();

    public WaveRiderEnchantment() {
        super(Enchantment.definition(ItemTags.BOATS, 2, 1, Enchantment.dynamicCost(10, 10), Enchantment.dynamicCost(40, 10), 2, EquipmentSlot.MAINHAND));
    }
}
