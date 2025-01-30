package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConjuredUpdaterTest {

    private ConjuredUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new ConjuredUpdater();
    }

    @Test
    void testUpdateBeforeSellIn() {
        // Item with sellIn = 5 and quality = 10
        item = new Item("Conjured Item", 5, 10);

        item = updater.update(item);

        // After updating, the quality should degrade by 2 (new quality = 8)
        assertEquals(8, item.quality);
        assertEquals(4, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateAfterSellIn() {
        // Item with sellIn = 0 and quality = 10
        item = new Item("Conjured Item", 0, 10);

        item = updater.update(item);

        // After updating, the quality should degrade by 4 (new quality = 6)
        assertEquals(6, item.quality);
        assertEquals(-1, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateQualityNotNegative() {
        // Item with sellIn = 1 and quality = 3
        item = new Item("Conjured Item", 1, 3);

        item = updater.update(item);

        // After updating, the quality should degrade by 2, but it can't go below 0
        assertEquals(1, item.quality); // new quality = 1 (not negative)
        assertEquals(0, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateQualityAtZero() {
        // Item with sellIn = 1 and quality = 1
        item = new Item("Conjured Item", 1, 1);

        item = updater.update(item);

        // After updating, the quality should degrade by 2, but it will be capped at 0
        assertEquals(0, item.quality); // new quality = 0
        assertEquals(0, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateQualityAfterSellInExpired() {
        // Item with sellIn = 0 and quality = 2
        item = new Item("Conjured Item", 0, 2);

        item = updater.update(item);

        // After updating, the quality should degrade by 4, but it will be capped at 0
        assertEquals(0, item.quality); // new quality = 0 (can't go below 0)
        assertEquals(-1, item.sellIn); // sellIn is decreased by 1
    }
}
