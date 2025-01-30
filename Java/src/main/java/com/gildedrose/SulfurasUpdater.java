package com.gildedrose;

public class SulfurasUpdater implements ItemUpdater{
    @Override
    public Item update(Item item) {
        // Sulfuras does not change
        //A legendary item that never has to be sold or decreases in quality.
        //sellIn and quality remain constant.
        return item;
    }
}
