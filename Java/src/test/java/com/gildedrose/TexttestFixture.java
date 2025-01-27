package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        // Initialize updaters
        Map<String, ItemUpdater> updaters =GildedRose.createDefaultUpdaters();

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20),

            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };
            new Item("",0,0);

        GildedRose app = new GildedRose(items,updaters);


        // Print results
      /*  for (Item item : items) {
            System.out.println(item.name + ", " + item.sellIn + ", " + item.quality);
        }*/

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
