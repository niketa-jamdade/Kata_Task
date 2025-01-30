package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgedBrieUpdaterTest {

    private AgedBrieUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new AgedBrieUpdater();
    }

    @Test
    void testUpdateBeforeQualityMax() {
        // Item with sellIn = 5 and quality = 10
        item = new Item("Aged Brie", 5, 10);

        item = updater.update(item);

        // After updating, the quality should increase by 1 (new quality = 11)
        assertEquals(11, item.quality);
        assertEquals(4, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateAtMaxQuality() {
        // Item with sellIn = 5 and quality = 50 (max quality)
        item = new Item("Aged Brie", 5, 50);

        item = updater.update(item);

        // After updating, the quality should not increase because it is already at the max (50)
        assertEquals(50, item.quality);
        assertEquals(4, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateWithQualityNearMax() {
        // Item with sellIn = 1 and quality = 49
        item = new Item("Aged Brie", 1, 49);

        item = updater.update(item);

        // After updating, the quality should increase by 1 (new quality = 50)
        assertEquals(50, item.quality);
        assertEquals(0, item.sellIn); // sellIn is decreased by 1
    }

    @Test
    void testUpdateAfterSellInExpired() {
        // Item with sellIn = 0 and quality = 30
        item = new Item("Aged Brie", 0, 30);

        item = updater.update(item);

        // After updating, the quality should increase by 1 (new quality = 31)
        assertEquals(31, item.quality);
        assertEquals(-1, item.sellIn); // sellIn is decreased by 1
    }
}
