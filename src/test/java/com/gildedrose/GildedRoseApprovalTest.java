package com.gildedrose;


import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemNames.*;
import static com.github.writethemfirst.approvals.Approvals.*;
import static java.util.Arrays.asList;


class GildedRoseApprovalTest {


    @Test
    void updateQuality_normal_shouldDecrease() {
        Item item = doTest(BRIE, -2, 10);
        verify(item);
    }

    @Test
    void updateQuality_normal_shouldDecrease_all() {
        verifyAllCombinations(
            asList("normal item"),
            asList(-1, 0, 1, 10),
            asList(-1, 0, 1, 10),
            this::doTest);
    }

    @Test
    void updateQuality_brie_shouldDecrease_all() {
        verifyAllCombinations(
            asList(BRIE),
            asList(-1, 0, 1, 10),
            asList(-1, 0, 1, 10),
            this::doTest);
    }

    @Test
    void updateQuality_sulfuras_shouldStay() {
        verifyAllCombinations(
            asList(SULFURAS),
            asList(-1, 0, 1, 10),
            asList(-1, 0, 1, 50, 51),
            this::doTest);
    }

    @Test
    void updateQuality_pass_shouldEvolve() {
        verifyAllCombinations(
            asList(PASS),
            asList(-1, 0, 1, 5, 6, 10, 11),
            asList(-1, 0, 1, 10),
            this::doTest);
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
