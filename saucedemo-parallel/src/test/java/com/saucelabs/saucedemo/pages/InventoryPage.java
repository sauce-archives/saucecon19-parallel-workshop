package com.saucelabs.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header_label")
    private WebElement headerLabel;

    @FindBy(className = "product_sort_container")
    private WebElement sortList;

    @FindBy(className ="add-to-cart-button")
    private WebElement addToCart;

    @FindBy(className ="remove-from-cart-button")
    private WebElement removeFromCartButton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "inventory_container")
    private WebElement inventoryContainer;

    public boolean isOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header_label")));
        return headerLabel.isDisplayed();
    }

    public void addItemToCart() {
        addToCart.click();
    }

    public void removeItemFromCart() {
        removeFromCartButton.click();
    }

    public int getNumberOfItemsInCart() {
        return Integer.valueOf(shoppingCartBadge.getText());
    }

    public int getItemsInPage() {
        return Integer.valueOf(inventoryContainer.getText());
    }
}
