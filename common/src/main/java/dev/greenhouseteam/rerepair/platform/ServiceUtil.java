package dev.greenhouseteam.rerepair.platform;

import dev.greenhouseteam.rerepair.ReRepair;

import java.util.ServiceLoader;

public class ServiceUtil {
    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        ReRepair.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}