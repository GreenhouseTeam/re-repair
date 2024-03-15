package dev.greenhouseteam.rerepair;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ReRepair.MOD_ID)
public class ReRepairNeoForge {

    public ReRepairNeoForge(IEventBus eventBus) {
        ReRepair.init();
    }
}