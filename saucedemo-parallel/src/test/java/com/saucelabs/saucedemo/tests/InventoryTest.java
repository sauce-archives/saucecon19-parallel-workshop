package com.saucelabs.saucedemo.tests;

import com.saucelabs.saucedemo.pages.InventoryPage;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

public class InventoryTest extends BaseWebDriverTest {
    @Test
    public void addOneItemToCart() {}

    public void addItemsToCart(int items) {
        IntStream.range(0, items).forEach(i -> {
            InventoryPage page = new InventoryPage(getWebDriver());
            page.addItemToCart();
        });
    }
}
