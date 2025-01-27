package com.gildedrose;

public class StandardItemUpdater implements ItemUpdater{
    @Override
    public Item update(Item item) {
        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality -= 2;  // Degrades twice as fast after sell-by date
        } else {
            item.quality--; // Regular degradation
        }

        // Ensure quality doesn't go below 0
        item.quality = Math.max(0, item.quality);

        return item;
    }
}

