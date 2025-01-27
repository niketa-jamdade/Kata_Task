package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater{
    @Override
    public Item update(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0; // Quality drops to 0 after the concert.
        } else {
            if (item.sellIn <= 5) {
                item.quality += 3; // Increase by 3 when sellIn is 5 or less.
            } else if (item.sellIn <= 10) {
                item.quality += 2; // Increase by 2 when sellIn is 10 or less but more than 5.
            } else {
                item.quality += 1; // Regular increase.
            }
            // Ensure quality does not exceed 50.
            if (item.quality > 50) {
                item.quality = 50;
            }
        }
        // Decrease sellIn.
        item.sellIn--;
        return item;
    }
}

