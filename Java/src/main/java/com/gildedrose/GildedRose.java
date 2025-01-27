package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {

    public Item[] items;
    private Map<String, ItemUpdater> itemUpdaters;

    public GildedRose(Item[] items, Map<String, ItemUpdater> itemUpdaters) {
        this.items = items;
        this.itemUpdaters = itemUpdaters;
    }

    public void updateQuality() {
        items = Arrays.stream(items)
            .map(item -> {
                ItemUpdater updater = itemUpdaters.getOrDefault(item.name,Updaters.STANDARD);
                return updater.update(item);
            })
            .toArray(Item[]::new); // Collect stream elements back into an array
        }

    // Static method to create the map of updaters
    public static Map<String, ItemUpdater> createDefaultUpdaters() {
        Map<String, ItemUpdater> updaters = new HashMap<>();
        for (ItemType type : ItemType.values()) {
            updaters.put(type.getDisplayName(), type.getUpdater());
        }
        return updaters;
    }
}
















































