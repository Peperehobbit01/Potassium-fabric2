package me.jellysquid.mods.hydrogen.common.state.property;

import net.minecraft.state.property.Property;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakPropertyCache {

    /**
     * Values are {@link WeakReference} because values in {@link WeakHashMap} are strongly-referenced by default.
     */
    private static final WeakHashMap<Property<?>, WeakReference<Property<?>>> CACHE = new WeakHashMap<>();

    /**
     * Caches properties passed into it in a {@link WeakHashMap}.
     *
     * @param newProperty the property to cache
     * @param <T>         the property type (checked by the property's equals method)
     * @return the cached property
     */
    @SuppressWarnings("unchecked")
    public static <T extends Property<?>> T tryCacheProperty(T newProperty) {
        return (T) CACHE.computeIfAbsent(newProperty, WeakReference::new).get();
    }
}
