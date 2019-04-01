package com.saucelabs.saucedemo.tests;

import com.saucelabs.saucedemo.pages.InventoryPage;
import com.saucelabs.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseWebDriverTest {
    @Test(dataProvider = "sauceBrowsers")
    public void loginTestValid(String browser, String browserVersion, String platformName, RunType runType) {
        this.createDriver(browser, browserVersion, platformName, "loginTest", runType);
        LoginPage loginPage = new LoginPage(getWebDriver());
        InventoryPage inventoryPage = new InventoryPage(getWebDriver());
        loginPage.visitPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test(dataProvider = "sauceBrowsers")
    public void loginTestInvalid(String browser, String browserVersion, String platformName, RunType runType) {
        this.createDriver(browser, browserVersion, platformName, "loginTest", runType);
        LoginPage loginPage = new LoginPage(getWebDriver());
        loginPage.visitPage();
        loginPage.login("invalid_user", "secret_sauce");
        Assert.assertTrue(loginPage.isOnPage());
    }
}