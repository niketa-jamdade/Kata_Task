import com.gildedrose.BackstagePassUpdater;

public class BackstagePassUpdaterTest {
    public static void main(String[] args) {
        // Create a BackstagePassUpdater instance
        BackstagePassUpdater updater= new BackstagePassUpdater();

        // Test cases
        Item[] items = {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20)
        };

        // Print initial state and updates
        System.out.println("Before Update:");
        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println("\nAfter Update:");
        for (Item item : items) {
            updater.update(item);
            System.out.println(item);
        }
    }
}

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
