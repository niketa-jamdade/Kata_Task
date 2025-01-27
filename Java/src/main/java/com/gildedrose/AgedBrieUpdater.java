package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {

    @Override
    public Item update(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;

        return item;
    }
}

