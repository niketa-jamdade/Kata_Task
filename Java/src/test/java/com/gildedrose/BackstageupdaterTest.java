package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class BackstagePassUpdaterTest {

        private BackstagePassUpdater updater;
        private Item item;

        @BeforeEach
        void setUp() {
            updater = new BackstagePassUpdater();
        }

        @Test
        void testUpdateBeforeSellIn5() {
            // Item with sellIn = 4 and quality = 10
            item = new Item("Backstage Pass", 4, 10);

            item = updater.update(item);

            // After updating, the quality should increase by 3 (new quality = 13)
            assertEquals(13, item.quality);
            assertEquals(3, item.sellIn); // sellIn is decreased by 1
        }

        @Test
        void testUpdateBeforeSellIn10() {
            // Item with sellIn = 8 and quality = 20
            item = new Item("Backstage Pass", 8, 20);

            item = updater.update(item);

            // After updating, the quality should increase by 2 (new quality = 22)
            assertEquals(22, item.quality);
            assertEquals(7, item.sellIn); // sellIn is decreased by 1
        }

        @Test
        void testUpdateBeforeSellInMoreThan10() {
            // Item with sellIn = 15 and quality = 30
            item = new Item("Backstage Pass", 15, 30);

            item = updater.update(item);

            // After updating, the quality should increase by 1 (new quality = 31)
            assertEquals(31, item.quality);
            assertEquals(14, item.sellIn); // sellIn is decreased by 1
        }

        @Test
        void testUpdateAfterSellIn0() {
            // Item with sellIn = 0 and quality = 10
            item = new Item("Backstage Pass", 0, 10);

            item = updater.update(item);

            // After updating, the quality should become 0
            assertEquals(0, item.quality);
            assertEquals(-1, item.sellIn); // sellIn is decreased by 1
        }

        @Test
        void testUpdateQualityNotExceed50() {
            // Item with sellIn = 5 and quality = 50 (already at max)
            item = new Item("Backstage Pass", 5, 50);

            item = updater.update(item);

            // After updating, the quality should remain 50 (can't exceed 50)
            assertEquals(50, item.quality);
            assertEquals(4, item.sellIn); // sellIn is decreased by 1
        }
    }

