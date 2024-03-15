package dev.greenhouseteam.rerepair;

import net.fabricmc.api.ModInitializer;

public class ReRepairFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ReRepair.init();
    }

}
