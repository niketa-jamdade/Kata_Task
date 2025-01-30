package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SulfurasUpdaterTest {

    private SulfurasUpdater updater;
    private Item item;

    @BeforeEach
    void setUp() {
        updater = new SulfurasUpdater();
    }

    @Test
    void testUpdateSulfuras() {
        // Item with sellIn = 5 and quality = 80
        item = new Item("Sulfuras, Hand of Ragnaros", 5, 80);

        item = updater.update(item);

        // After updating, Sulfuras' quality and sellIn should remain unchanged
        assertEquals(80, item.quality);  // Quality should remain 80
        assertEquals(5, item.sellIn);    // sellIn should remain 5
    }

    @Test
    void testUpdateSulfurasQualityMax() {
        // Item with sellIn = 10 and quality = 50 (max quality)
        item = new Item("Sulfuras, Hand of Ragnaros", 10, 50);

        item = updater.update(item);

        // After updating, Sulfuras' quality and sellIn should remain unchanged
        assertEquals(50, item.quality);  // Quality should remain 50 (max quality)
        assertEquals(10, item.sellIn);  // sellIn should remain 10
    }

    @Test
    void testUpdateSulfurasNegativeSellIn() {
        // Item with sellIn = -5 and quality = 30
        item = new Item("Sulfuras, Hand of Ragnaros", -5, 30);

        item = updater.update(item);

        // After updating, Sulfuras' quality and sellIn should remain unchanged
        assertEquals(30, item.quality);  // Quality should remain 30
        assertEquals(-5, item.sellIn);  // sellIn should remain -5
    }
}
