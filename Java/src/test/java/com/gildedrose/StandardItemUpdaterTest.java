package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardItemUpdaterTest {

    private StandardItemUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new StandardItemUpdater();
    }

    @Test
    void testUpdateBeforeSellIn() {
        // Item with sellIn = 5 and quality = 10
        item = new Item("Standard Item", 5, 10);

        item = updater.update(item);

        // After updating, the quality should decrease by 1 (new quality = 9)
        assertEquals(9, item.quality);
        assertEquals(4, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateAfterSellIn() {
        // Item with sellIn = 0 and quality = 10
        item = new Item("Standard Item", 0, 10);

        item = updater.update(item);

        // After updating, the quality should decrease by 2 (new quality = 8)
        assertEquals(8, item.quality);
        assertEquals(-1, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateQualityNotNegative() {
        // Item with sellIn = 1 and quality = 1
        item = new Item("Standard Item", 1, 1);

        item = updater.update(item);

        // After updating, the quality should decrease by 1, but it can't go below 0
        assertEquals(0, item.quality); // new quality = 0 (not negative)
        assertEquals(0, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateQualityAfterSellInExpired() {
        // Item with sellIn = 0 and quality = 3
        item = new Item("Standard Item", 0, 3);

        item = updater.update(item);

        // After updating, the quality should decrease by 2 (new quality = 1)
        assertEquals(1, item.quality); // new quality = 1
        assertEquals(-1, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateMultipleDays() {
        // Item with sellIn = 3 and quality = 5
        item = new Item("Standard Item", 3, 5);

        // Simulate 3 days of updates
        item = updater.update(item); // sellIn = 2, quality = 4
        item = updater.update(item); // sellIn = 1, quality = 3
        item = updater.update(item); // sellIn = 0, quality = 2

        // After 3 days, the quality should have decreased by 3, and sellIn should be 0
        assertEquals(2, item.quality);
        assertEquals(0, item.sellIn);
    }
}
