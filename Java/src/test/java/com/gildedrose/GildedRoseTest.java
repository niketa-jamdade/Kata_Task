package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Map<String, ItemUpdater> updaters =GildedRose.createDefaultUpdaters();
        GildedRose app = new GildedRose(items,updaters);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
