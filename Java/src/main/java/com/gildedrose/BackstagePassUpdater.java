package com.gildedrose;

import java.util.stream.IntStream;

public class BackstagePassUpdater implements ItemUpdater {

    public Item update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0; // Explicitly set quality to 0 when sellIn <= 0
        } else {
            item.quality = IntStream.of(
                    item.sellIn > 0 && item.sellIn <= 5 ? item.quality + 3 : item.quality, // Increase by 3 when sellIn <= 5
                    item.sellIn > 5 && item.sellIn <= 10 ? item.quality + 2 : item.quality, // Increase by 2 when 5 < sellIn <= 10
                    item.sellIn > 10 ? item.quality + 1 : item.quality // Regular increase when sellIn > 10
                )
                .filter(quality -> quality <= 50) // Ensure quality does not exceed 50
                .max() // Use the highest applicable quality value
                .orElse(item.quality);

            // Decrease sellIn
            item.sellIn--;
        }
        return item;
    }
}

