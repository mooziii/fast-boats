package com.github.mooziii.fastboats.components;

import com.github.mooziii.fastboats.FastBoats;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class SyncedIntComponent implements AutoSyncedComponent {
    private final Object provider;
    private int value;

    public SyncedIntComponent(Object provider) {
        this.provider = provider;
    }

    @Override
    public void readFromNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        value = tag.getInt("value");
    }

    @Override
    public void writeToNbt(CompoundTag tag, HolderLookup.Provider registryLookup) {
        tag.putInt("value", value);
    }

    public int value() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        FastBoats.WAVE_RIDER.sync(provider);
    }
}
