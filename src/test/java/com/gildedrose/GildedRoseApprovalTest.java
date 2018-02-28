package com.gildedrose;


import com.github.writethemfirst.approvals.Approvals;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemNames.BRIE;


class GildedRoseApprovalTest {

    private Approvals approvals = new Approvals();

    @Test
    void updateQuality_normal_shouldDecrease() {
        Item item = doTest(BRIE, -2, 10);
        approvals.verify(item);
    }

    private Item doTest(String name, int sellIn, int quality) {
        //GIVEN
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        //WHEN
        app.updateQuality();
        return app.items[0];
    }

}
