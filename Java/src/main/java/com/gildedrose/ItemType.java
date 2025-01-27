package com.gildedrose;

public enum ItemType {

        AGED_BRIE("Aged Brie", new AgedBrieUpdater()),
        BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater()),
        CONJURED("Conjured Mana Cake", new ConjuredUpdater()),
        DEXTERITY_VEST("+5 Dexterity Vest", new StandardItemUpdater()),
        SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasUpdater()),
        ELIXIR("Elixir of the Mongoose", new StandardItemUpdater());

        private final String displayName;
        private final ItemUpdater updater;

        ItemType(String displayName, ItemUpdater updater) {
            this.displayName = displayName;
            this.updater = updater;
        }

        public String getDisplayName() {
            return displayName;
        }

        public ItemUpdater getUpdater() {
            return updater;
        }
    }

