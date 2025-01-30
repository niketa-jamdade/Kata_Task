package com.gildedrose;

// Mock Item class to match the interface
class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return String.format("%s, sellIn: %d, quality: %d", name, sellIn, quality);
    }
}

// Mock ItemUpdater interface to simulate the required behavior
interface ItemUpdater {
    Item update(Item item);
}
