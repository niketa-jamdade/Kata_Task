package com.gildedrose;

public class ConjuredUpdater implements ItemUpdater{
    @Override
    public Item update(Item item) {
        int degradeRate = item.sellIn > 0 ? 2 : 4;
        item.quality = Math.max(0, item.quality - degradeRate);
        item.sellIn--;

        return item;
    }
}
